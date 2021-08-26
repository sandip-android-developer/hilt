package com.example.hiltdemo.api

import com.example.hiltdemo.models.EmployeeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("employees")
    suspend fun getEmployees(): Response<EmployeeResponse>
}