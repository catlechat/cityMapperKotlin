package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class Address (

  @SerializedName("house_number" ) var houseNumber : Int?    = null,
  @SerializedName("label"        ) var label       : String? = null,
  @SerializedName("name"         ) var name        : String? = null,
  @SerializedName("coord"        ) var coord       : Coord?  = Coord(),
  @SerializedName("id"           ) var id          : String? = null,
  @SerializedName("administrative_regions" ) var administrativeRegions : ArrayList<AdministrativeRegions> = arrayListOf(),


  )