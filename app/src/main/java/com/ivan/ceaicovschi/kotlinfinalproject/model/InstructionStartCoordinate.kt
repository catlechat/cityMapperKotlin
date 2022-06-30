package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class InstructionStartCoordinate (

  @SerializedName("lat" ) var lat : String? = null,
  @SerializedName("lon" ) var lon : String? = null

)