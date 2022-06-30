package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class AdministrativeRegions (

  @SerializedName("insee"    ) var insee   : String? = null,
  @SerializedName("name"     ) var name    : String? = null,
  @SerializedName("level"    ) var level   : Int?    = null,
  @SerializedName("coord"    ) var coord   : Coord?  = Coord(),
  @SerializedName("label"    ) var label   : String? = null,
  @SerializedName("id"       ) var id      : String? = null,
  @SerializedName("zip_code" ) var zipCode : String? = null

)