package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class Codes (

  @SerializedName("type"  ) var type  : String? = null,
  @SerializedName("value" ) var value : String? = null

)