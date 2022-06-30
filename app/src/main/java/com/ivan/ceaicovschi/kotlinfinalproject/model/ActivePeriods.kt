package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class ActivePeriods (

  @SerializedName("begin" ) var begin : String? = null,
  @SerializedName("end"   ) var end   : String? = null

)