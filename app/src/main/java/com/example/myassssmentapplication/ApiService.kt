package com.example.myassssmentapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("{location}/auth")
    fun login(
        @Path("location") location: String,
        @Body request: LoginRequest): Call<LoginResponse>

    @GET("dashboard/{keypass}")
    fun getDashboard(@Path("keypass") keypass: String): Call<DashboardResponse>
}
