package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName
import com.ivan.ceaicovschi.kotlinfinalproject.model.Codes
import com.ivan.ceaicovschi.kotlinfinalproject.model.Coord


data class StopArea (

    @SerializedName("codes"    ) var codes    : ArrayList<Codes>  = arrayListOf(),
    @SerializedName("name"     ) var name     : String?           = null,
    @SerializedName("links"    ) var links    : ArrayList<Links> = arrayListOf(),
    @SerializedName("coord"    ) var coord    : Coord?            = Coord(),
    @SerializedName("label"    ) var label    : String?           = null,
    @SerializedName("timezone" ) var timezone : String?           = null,
    @SerializedName("id"       ) var id       : String?           = null

)