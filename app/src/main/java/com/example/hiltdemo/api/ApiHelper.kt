package com.example.hiltdemo.api

import com.example.hiltdemo.models.EmployeeResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getEmployees(): Response<EmployeeResponse>
}