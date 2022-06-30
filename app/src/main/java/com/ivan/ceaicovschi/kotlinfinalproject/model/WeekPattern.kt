package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class WeekPattern (

  @SerializedName("monday"    ) var monday    : Boolean? = null,
  @SerializedName("tuesday"   ) var tuesday   : Boolean? = null,
  @SerializedName("friday"    ) var friday    : Boolean? = null,
  @SerializedName("wednesday" ) var wednesday : Boolean? = null,
  @SerializedName("thursday"  ) var thursday  : Boolean? = null,
  @SerializedName("sunday"    ) var sunday    : Boolean? = null,
  @SerializedName("saturday"  ) var saturday  : Boolean? = null

)