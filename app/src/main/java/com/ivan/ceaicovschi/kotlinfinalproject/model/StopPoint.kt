package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName
import com.ivan.ceaicovschi.kotlinfinalproject.model.*


data class StopPoint (

  @SerializedName("codes"                  ) var codes                 : ArrayList<Codes>                 = arrayListOf(),
  @SerializedName("stop_area"              ) var stopArea              : StopArea?                        = StopArea(),
  @SerializedName("links"                  ) var links                 : ArrayList<Links>                = arrayListOf(),
  @SerializedName("coord"                  ) var coord                 : Coord?                           = Coord(),
  @SerializedName("label"                  ) var label                 : String?                          = null,
  @SerializedName("equipments"             ) var equipments            : ArrayList<String>                = arrayListOf(),
  @SerializedName("administrative_regions" ) var administrativeRegions : ArrayList<AdministrativeRegions> = arrayListOf(),
  @SerializedName("address"                ) var address               : Address?                         = Address(),
  @SerializedName("id"                     ) var id                    : String?                          = null,
  @SerializedName("name"                   ) var name                  : String?                          = null

)