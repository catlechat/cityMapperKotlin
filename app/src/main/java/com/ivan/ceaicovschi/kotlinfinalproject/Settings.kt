package com.ivan.ceaicovschi.kotlinfinalproject

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.startActivityForResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val REQUEST_CODE_SIGN_IN = 0

class Settings : AppCompatActivity() {

    private lateinit var gso: GoogleSignInOptions
    private lateinit var googleSignInCLient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val signInButton = findViewById<View>(R.id.sign_in_btn)
        val signOutButton = findViewById<View>(R.id.sign_out_btn)

        auth = FirebaseAuth.getInstance()
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInCLient = GoogleSignIn.getClient(this, gso)

        val chooseCity = findViewById<View>(R.id.choose_city) as Button
        chooseCity.setOnClickListener {
            intent = Intent(this@Settings, ChooseCity::class.java)
            startActivity(intent)
            finish()
        }

        val backButton = findViewById<View>(R.id.backButton) as Button
        backButton.setOnClickListener {
            startActivity(Intent(this@Settings, ChooseCity::class.java))
        }

        signInButton.setOnClickListener {
            signIn()
        }

        signOutButton.setOnClickListener {
            Firebase.auth.signOut()
            googleSignInCLient.signOut().addOnCompleteListener(this) {
                Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Settings::class.java))
                finish()
            }
            signInButton.visibility = View.VISIBLE
            signOutButton.visibility = View.GONE
        }

        if (auth.currentUser != null) {
            signInButton.visibility = View.GONE
            signOutButton.visibility = View.VISIBLE
        }
    }


    private fun signIn() {
        val signInIntent = googleSignInCLient.signInIntent
        startActivityForResult(signInIntent, REQUEST_CODE_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                Log.w(TAG, "Google sign in failed", e)
                Toast.makeText(this, "Google sign in failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Toast.makeText(this, "Successfully signed in with Google", Toast.LENGTH_SHORT)
                        .show()
                    CoroutineScope(Dispatchers.Main).launch {
                        withContext(Dispatchers.IO) {
                            val user = auth.currentUser
                            if (user != null) {
                                runOnUiThread {
                                    Toast.makeText(
                                        applicationContext,
                                        "Successfully signed in with Google" + user.displayName,
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                                val intent = Intent(this@Settings, Settings::class.java)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }
                }
            }
    }
}