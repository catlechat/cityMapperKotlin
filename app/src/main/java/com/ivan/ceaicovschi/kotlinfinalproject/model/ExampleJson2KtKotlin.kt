package com.example.example

import com.google.gson.annotations.SerializedName
import com.ivan.ceaicovschi.kotlinfinalproject.model.*


data class ExampleJson2KtKotlin (

    @SerializedName("tickets"         ) var tickets        : ArrayList<String>         = arrayListOf(),
    @SerializedName("terminus"        ) var terminus       : ArrayList<Terminus>       = arrayListOf(),
    @SerializedName("links"           ) var links          : ArrayList<Links>          = arrayListOf(),
    @SerializedName("journeys"        ) var journeys       : ArrayList<Journeys>       = arrayListOf(),
    @SerializedName("disruptions"     ) var disruptions    : ArrayList<String>         = arrayListOf(),
    @SerializedName("notes"           ) var notes          : ArrayList<String>         = arrayListOf(),
    @SerializedName("feed_publishers" ) var feedPublishers : ArrayList<FeedPublishers> = arrayListOf(),
    @SerializedName("context"         ) var context        : Context?                  = Context(),
    @SerializedName("exceptions"      ) var exceptions     : ArrayList<String>         = arrayListOf()

)