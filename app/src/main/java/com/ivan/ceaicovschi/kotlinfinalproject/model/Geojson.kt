package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class Geojson (

  @SerializedName("type"        ) var type        : String?                      = null,
  @SerializedName("properties"  ) var properties  : ArrayList<Properties>        = arrayListOf(),
  @SerializedName("coordinates" ) var coordinates : ArrayList<ArrayList<Double>> = arrayListOf()

)