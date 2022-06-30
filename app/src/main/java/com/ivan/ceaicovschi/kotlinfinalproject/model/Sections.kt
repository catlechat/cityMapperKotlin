package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class Sections (

  @SerializedName("from"                ) var from              : From?                  = From(),
  @SerializedName("links"               ) var links             : List<Links>?      = arrayListOf(),
  @SerializedName("arrival_date_time"   ) var arrivalDateTime   : String?                = null,
  @SerializedName("co2_emission"        ) var co2Emission       : Co2Emission?           = Co2Emission(),
  @SerializedName("to"                  ) var to                : To?                    = To(),
  @SerializedName("departure_date_time" ) var departureDateTime : String?                = null,
  @SerializedName("geojson"             ) var geojson           : Geojson?               = Geojson(),
  @SerializedName("duration"            ) var duration          : Int?                   = null,
  @SerializedName("path"                ) var path              : List<Path>?       = arrayListOf(),
  @SerializedName("type"                ) var type              : String?                = null,
  @SerializedName("id"                  ) var id                : String?                = null,
  @SerializedName("elevations"          ) var elevations        : List<Elevations>? = arrayListOf(),
  @SerializedName("mode"                ) var mode              : String?                = null,
  @SerializedName("display_informations") var displayInformation: DisplayInformation?    = null,
)