package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName
import com.ivan.ceaicovschi.kotlinfinalproject.model.Address


data class From (

  @SerializedName("embedded_type" ) var embeddedType : String?  = null,
  @SerializedName("id"            ) var id           : String?  = null,
  @SerializedName("quality"       ) var quality      : Int?     = null,
  @SerializedName("name"          ) var name         : String?  = null,
  @SerializedName("address"       ) var address      : Address? = Address()

)