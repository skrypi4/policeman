package com.example.policeman

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("api/login/")
        fun logIn(@Query("login") login: String,
                  @Query("password") password: String): Call<Response.response>

    @GET ("api/wanted/")
        fun wanted(): Call<Response.wanted>

    @GET ("api/department/")
    fun department(): Call<Response.department>

}