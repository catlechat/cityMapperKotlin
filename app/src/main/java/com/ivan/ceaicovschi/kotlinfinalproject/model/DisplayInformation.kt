package com.ivan.ceaicovschi.kotlinfinalproject.model

import android.net.Network
import com.google.gson.annotations.SerializedName

data class DisplayInformation(
    @SerializedName("code"              ) val code              : String?       = "",
    @SerializedName("color"             ) val color             : String?       = "",
    @SerializedName("commercial_mode"   ) val commercialMode    : String?       = null,
    @SerializedName("description"       ) val description       : String?       = "",
    @SerializedName("direction"         ) val direction         : String?       = "",
    @SerializedName("equipments"        ) val equipments        : List<Any>?    = listOf(),
    @SerializedName("headsign"          ) val headsign          : String?       = "",
    @SerializedName("label"             ) val label             : String?       = "",
    @SerializedName("links"             ) val links             : List<Links>?  = listOf(),
    @SerializedName("name"              ) val name              : String?       = "",
    @SerializedName("network"           ) val network           : String?       = null,
    @SerializedName("physical_mode"     ) val physical_mode     : String?       = "",
    @SerializedName("text_color"        ) val text_color        : String?       = "",
    @SerializedName("trip_short_name"   ) val trip_short_name   : String?       = "",
)
