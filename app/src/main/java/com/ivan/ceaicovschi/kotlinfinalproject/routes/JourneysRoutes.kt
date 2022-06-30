package com.ivan.ceaicovschi.kotlinfinalproject.routes

import com.ivan.ceaicovschi.kotlinfinalproject.model.Journeys
import com.ivan.ceaicovschi.kotlinfinalproject.model.ResponseJourney
import com.ivan.ceaicovschi.kotlinfinalproject.retrofit.RetrofitClient
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

object JourneysService: RetrofitClient() {
    val journeys: JourneysRoutes by lazy {
        this.retrofit.create(JourneysRoutes::class.java)
    }
}

interface JourneysRoutes {
    @GET("journeys")
    suspend fun getJourneys(@Query("from") from: String, @Query("to") to: String): Response<ResponseJourney>
}
