package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class Links (

  @SerializedName("href"      ) var href      : String?  = null,
  @SerializedName("type"      ) var type      : String?  = null,
  @SerializedName("rel"       ) var rel       : String?  = null,
  @SerializedName("templated" ) var templated : Boolean? = null

)