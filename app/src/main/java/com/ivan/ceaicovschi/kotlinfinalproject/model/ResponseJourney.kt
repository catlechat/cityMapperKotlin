package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName

data class ResponseJourney(
    @SerializedName("tickets"   ) var tickets: ArrayList<Tickets> = arrayListOf(),
    @SerializedName("journeys") var journeys: ArrayList<Journeys> = arrayListOf(),
    ) {
    override fun toString(): String {
        return "ResponseJourney(tickets=$tickets, journeys=$journeys)"
    }
}
