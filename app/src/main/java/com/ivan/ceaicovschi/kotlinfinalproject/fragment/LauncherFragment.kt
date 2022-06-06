package com.ivan.ceaicovschi.kotlinfinalproject.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ivan.ceaicovschi.kotlinfinalproject.R

/**
 * A simple [Fragment] subclass.
 * Use the [LauncherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LauncherFragment : Fragment() {
    private val TIME: Long = 2000; //timer to launch next activity
    private val mHandler: Handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_launcher, container, false)
        mHandler.postDelayed({
            findNavController().navigate(R.id.action_launcherFragment_to_chooseCity)
        }, TIME)

        return view
    }
}