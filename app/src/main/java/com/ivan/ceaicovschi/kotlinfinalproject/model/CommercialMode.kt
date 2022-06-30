package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName

data class CommercialMode(
    @SerializedName("id"    )   val id      :   String? = null,
    @SerializedName("name"  )   val name    :   String? = null,
)
