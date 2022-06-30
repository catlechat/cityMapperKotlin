package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName
import com.ivan.ceaicovschi.kotlinfinalproject.model.CarDirectPath


data class Context (

  @SerializedName("timezone"         ) var timezone        : String?        = null,
  @SerializedName("current_datetime" ) var currentDatetime : String?        = null,
  @SerializedName("car_direct_path"  ) var carDirectPath   : CarDirectPath? = CarDirectPath()

)