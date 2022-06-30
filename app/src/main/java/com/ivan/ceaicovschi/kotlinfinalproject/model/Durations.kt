package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class Durations (

  @SerializedName("taxi"        ) var taxi        : Int? = null,
  @SerializedName("walking"     ) var walking     : Int? = null,
  @SerializedName("car"         ) var car         : Int? = null,
  @SerializedName("ridesharing" ) var ridesharing : Int? = null,
  @SerializedName("bike"        ) var bike        : Int? = null,
  @SerializedName("total"       ) var total       : Int? = null

)