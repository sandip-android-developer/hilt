package com.example.hiltdemo.repository

import com.example.hiltdemo.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getEmployee() = apiHelper.getEmployees()
}