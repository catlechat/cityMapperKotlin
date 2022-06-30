package com.ivan.ceaicovschi.kotlinfinalproject.retrofit

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ivan.ceaicovschi.kotlinfinalproject.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers
import java.io.IOException


open class RetrofitClient {
    val BASE_URL = "https://api.navitia.io/v1/coverage/fr-idf/"

    private val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain ->
                val request =
                    chain.request().newBuilder()
                        .header("Authorization", "5727053e-ae2e-4f95-a876-e5bd7bfbdae1")
                        .build()
                Log.d("URLL", "URL:${request.url().toString()} "  )
                return@Interceptor chain.proceed(request)
            })
            .build()
    }

    protected val retrofit: Retrofit by lazy {
                Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build()
        }
}