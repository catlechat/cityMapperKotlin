package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class Fare (

  @SerializedName("found" ) var found : Boolean?          = null,
  @SerializedName("total" ) var total : Total?            = Total(),
  @SerializedName("links" ) var links : ArrayList<Links> = arrayListOf()

)