package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class Elevations (

  @SerializedName("distance_from_start" ) var distanceFromStart : Int? = null,
  @SerializedName("geojson_offset"      ) var geojsonOffset     : Int? = null,
  @SerializedName("elevation"           ) var elevation         : Int? = null

)