package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class CarDirectPath (

  @SerializedName("co2_emission" ) var co2Emission : Co2Emission? = Co2Emission()

)