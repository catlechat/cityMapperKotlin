package com.ivan.ceaicovschi.kotlinfinalproject.model

import com.google.gson.annotations.SerializedName


data class Calendars (

    @SerializedName("active_periods" ) var activePeriods : ArrayList<ActivePeriods> = arrayListOf(),
    @SerializedName("week_pattern"   ) var weekPattern   : WeekPattern?             = WeekPattern()

)