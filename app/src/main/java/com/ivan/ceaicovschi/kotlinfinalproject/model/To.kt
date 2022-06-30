package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName
import com.ivan.ceaicovschi.kotlinfinalproject.model.StopPoint


data class To (

  @SerializedName("embedded_type" ) var embeddedType : String?    = null,
  @SerializedName("stop_point"    ) var stopPoint    : StopPoint? = StopPoint(),
  @SerializedName("quality"       ) var quality      : Int?       = null,
  @SerializedName("name"          ) var name         : String?    = null,
  @SerializedName("id"            ) var id           : String?    = null

)