package com.ravish.restapiexample.repository

import android.util.Log
import com.ravish.restapiexample.model.ApiResponse
import com.ravish.restapiexample.model.MarketData
import com.ravish.restapiexample.networking.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"
class ApiResponseRepository(private val retrofitService: RetrofitService) {

    fun getAllApiResponse() = retrofitService.getApiResponse()
}