package com.ivan.ceaicovschi.kotlinfinalproject

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException


class ChooseCity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_city)
        val fm: FragmentManager = supportFragmentManager
        val ft:FragmentTransaction = fm.beginTransaction()

        val jsonFileString = getJsonDataFromAsset(applicationContext, getString(R.string.city_file_name))
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