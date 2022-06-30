package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName

data class Cost(
    @SerializedName("currency" ) var currency : String? = null,
    @SerializedName("value"    ) var value    : String? = null
)
