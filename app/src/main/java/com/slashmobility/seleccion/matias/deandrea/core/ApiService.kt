package com.slashmobility.seleccion.matias.deandrea.core

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// API SERVICE: Service to request of API
private const val API_URL = "https://httpbin.org/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(API_URL)
    .build()

interface ApiService {
    @GET("/get")
    fun getData(): Call<Data>
}

object Api {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}