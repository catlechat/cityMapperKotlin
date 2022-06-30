package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName
import com.ivan.ceaicovschi.kotlinfinalproject.model.InstructionStartCoordinate


data class Path (

  @SerializedName("direction"                    ) var direction                  : Int?                        = null,
  @SerializedName("name"                         ) var name                       : String?                     = null,
  @SerializedName("instruction_start_coordinate" ) var instructionStartCoordinate : InstructionStartCoordinate? = InstructionStartCoordinate(),
  @SerializedName("instruction"                  ) var instruction                : String?                     = null,
  @SerializedName("length"                       ) var length                     : Int?                        = null,
  @SerializedName("duration"                     ) var duration                   : Int?                        = null

)