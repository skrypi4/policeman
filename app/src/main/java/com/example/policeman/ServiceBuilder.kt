package com.example.policeman

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://mad2019.hakta.pro/")
            .addConverterFactory(GsonConverterFactory.create(gson)) //настройка
            .build()

    fun<T> buildService (service: Class<T>): T{
        return retrofit.create(service)
    }

}