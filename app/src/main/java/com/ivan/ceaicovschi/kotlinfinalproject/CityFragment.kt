package com.ivan.ceaicovschi.kotlinfinalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.w3c.dom.Text


class CityFragment(var name: String) : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_city, container, false)
        val tv = rootView.findViewById<View>(R.id.city_name) as TextView
        tv.text = name

        return rootView
    }
}