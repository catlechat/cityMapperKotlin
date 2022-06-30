package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class Co2Emission (

  @SerializedName("value" ) var value : Double? = null,
  @SerializedName("unit"  ) var unit  : String? = null

)