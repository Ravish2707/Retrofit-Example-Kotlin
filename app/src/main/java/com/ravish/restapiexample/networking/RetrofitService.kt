package com.ravish.restapiexample.networking

import com.ravish.restapiexample.model.ApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://www.cryptingup.com/api/"

/**
 * Interface for getting the data from the rest api.
 */
interface RetrofitService {

    @GET("markets")
    fun getApiResponse(): Call<ApiResponse>

    /**
     * Single object for initializing the retrofit
     */
    companion object{

        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService{
            if (retrofitService == null){
                val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }

            return retrofitService!!
        }
    }
}