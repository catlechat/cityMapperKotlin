package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class FeedPublishers (

  @SerializedName("url"     ) var url     : String? = null,
  @SerializedName("id"      ) var id      : String? = null,
  @SerializedName("license" ) var license : String? = null,
  @SerializedName("name"    ) var name    : String? = null

)