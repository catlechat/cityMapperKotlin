package com.ivan.ceaicovschi.kotlinfinalproject.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ivan.ceaicovschi.kotlinfinalproject.R
import kotlinx.android.synthetic.main.fragment_choose_city.view.*
import java.io.IOException


class ChooseCity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fm: FragmentManager = requireFragmentManager()
        val ft:FragmentTransaction = fm.beginTransaction()

        val jsonFileString = getJsonDataFromAsset(view.context, getString(R.string.city_file_name))
        if (jsonFileString != null) {
            val gson = Gson()
            val listCityType = object : TypeToken<List<City>>() {}.type
            val cities: List<City> = gson.fromJson(jsonFileString, listCityType)
            cities.forEach { city ->
                val frag = CityFragment(city.name)
                ft.add(R.id.city_container,frag)
            }
        }else {
            val frag = CityFragment(getString(R.string.no_city_file_found))
            ft.add(R.id.city_container,frag)
        }
        ft.commit()



        val addNewCityButton = view.addCityButton
        addNewCityButton.setOnClickListener {
            findNavController().navigate(R.id.action_chooseCity_to_settings)
        }
    }

}


fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

data class City(val name: String, val country: String) {
}