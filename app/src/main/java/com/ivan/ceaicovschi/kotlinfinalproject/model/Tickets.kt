package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName

data class Tickets(
    @SerializedName("comment"   ) var comment  : String?          = null,
    @SerializedName("name"      ) var name     : String?          = null,
    @SerializedName("links"     ) var links    : ArrayList<Links> = arrayListOf(),
    @SerializedName("cost"      ) var cost     : Cost?            = Cost(),
    @SerializedName("source_id" ) var sourceId : String?          = null,
    @SerializedName("found"     ) var found    : Boolean?         = null,
    @SerializedName("id"        ) var id       : String?          = null
)
