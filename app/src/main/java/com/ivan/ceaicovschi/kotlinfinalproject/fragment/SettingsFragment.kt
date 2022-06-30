package com.ivan.ceaicovschi.kotlinfinalproject.fragment

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgument
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ivan.ceaicovschi.kotlinfinalproject.R
import com.ivan.ceaicovschi.kotlinfinalproject.retrofit.RetrofitClient
import com.ivan.ceaicovschi.kotlinfinalproject.routes.JourneysRoutes
import com.ivan.ceaicovschi.kotlinfinalproject.routes.JourneysService
import com.ivan.ceaicovschi.kotlinfinalproject.routes.JourneysService.journeys
import kotlinx.android.synthetic.main.fragment_settings.view.*
import kotlinx.coroutines.*

const val REQUEST_CODE_SIGN_IN = 0

class Settings : Fragment() {

    private lateinit var gso: GoogleSignInOptions
    private lateinit var googleSignInCLient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signInButton = view.sign_in_btn
        val signOutButton = view.sign_out_btn
        val fm: FragmentManager = requireFragmentManager()
        val ft: FragmentTransaction = fm.beginTransaction()

        auth = FirebaseAuth.getInstance()
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInCLient = GoogleSignIn.getClient(view.context, gso)

        val chooseCity = view.choose_city
        chooseCity.setOnClickListener {
            findNavController().navigate(R.id.action_settings_to_chooseCity)
        }

        val backButton = view.backButton
        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_settings_to_chooseCity)
        }

        signInButton.setOnClickListener {
            signIn()
        }

        signOutButton.setOnClickListener {
            Firebase.auth.signOut()
            activity?.let { it1 ->
                googleSignInCLient.signOut().addOnCompleteListener(it1) {
                    Toast.makeText(it1, "Signed out", Toast.LENGTH_SHORT).show()
                }
            }
            signInButton.visibility = View.VISIBLE
            signOutButton.visibility = View.GONE
        }

        if (auth.currentUser != null) {
            signInButton.visibility = View.GONE
            signOutButton.visibility = View.VISIBLE
        }

        getJourneys()
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
                Toast.makeText(view?.context, "Google sign in failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        activity?.let {
            auth.signInWithCredential(credential)
                .addOnCompleteListener(it) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        CoroutineScope(Dispatchers.Main).launch {
                            withContext(Dispatchers.IO) {
                                val user = auth.currentUser
                                if (user != null) {
                                    Handler(Looper.getMainLooper()).post {
                                        Toast.makeText(
                                            it,
                                            "Successfully signed in with Google" + user.displayName,
                                            Toast.LENGTH_LONG
                                        ).show()
                                        findNavController().navigate(R.id.action_settings_self)
                                    }
                                }
                            }
                        }

                    }
                }
        }
    }

     @OptIn(DelicateCoroutinesApi::class)
     fun getJourneys(){
         GlobalScope.launch {
             val journeys = JourneysService.journeys.getJourneys("2.3749036;48.8467927","2.37657;48.871786")
             if (journeys.isSuccessful && journeys.body() != null){
                 Log.d("Req", "getJourneys: " + journeys.body()!!.journeys[0])
             } else {
                 Log.d("E", "getJourneys: " + (journeys.errorBody()?.string()))
             }
         }
    }
}