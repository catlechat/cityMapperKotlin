package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class Journeys (

  @SerializedName("status"              ) var status            : String?              = null,
  @SerializedName("distances"           ) var distances         : Distances?           = Distances(),
  @SerializedName("links"               ) var links             : ArrayList<Links>     = arrayListOf(),
  @SerializedName("tags"                ) var tags              : ArrayList<String>    = arrayListOf(),
  @SerializedName("nb_transfers"        ) var nbTransfers       : Int?                 = null,
  @SerializedName("durations"           ) var durations         : Durations?           = Durations(),
  @SerializedName("arrival_date_time"   ) var arrivalDateTime   : String?              = null,
  @SerializedName("calendars"           ) var calendars         : ArrayList<Calendars> = arrayListOf(),
  @SerializedName("departure_date_time" ) var departureDateTime : String?              = null,
  @SerializedName("requested_date_time" ) var requestedDateTime : String?              = null,
  @SerializedName("fare"                ) var fare              : Fare?                = Fare(),
  @SerializedName("co2_emission"        ) var co2Emission       : Co2Emission?         = Co2Emission(),
  @SerializedName("type"                ) var type              : String?              = null,
  @SerializedName("duration"            ) var duration          : Int?                 = null,
  @SerializedName("sections"            ) var sections          : ArrayList<Sections>  = arrayListOf()

) {
  override fun toString(): String {
    return "Journeys(status=$status, distances=$distances, links=$links, tags=$tags, nbTransfers=$nbTransfers, durations=$durations, arrivalDateTime=$arrivalDateTime, calendars=$calendars, departureDateTime=$departureDateTime, requestedDateTime=$requestedDateTime, fare=$fare, co2Emission=$co2Emission, type=$type, duration=$duration, sections=$sections)"
  }
}