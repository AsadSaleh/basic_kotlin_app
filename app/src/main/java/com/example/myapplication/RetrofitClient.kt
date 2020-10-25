package com.example.myapplication

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {

    private const val BASE_URL = "https://5f94f4992de5f50016ca1be1.mockapi.io/"

    private val httpClient = OkHttpClient.Builder()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build()

    fun<T> buildService (service : Class <T>) : T {
        return  retrofit.create(service)
    }
}