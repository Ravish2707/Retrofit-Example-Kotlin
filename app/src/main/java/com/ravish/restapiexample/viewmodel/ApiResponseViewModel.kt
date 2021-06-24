package com.ravish.restapiexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravish.restapiexample.model.ApiResponse
import com.ravish.restapiexample.model.MarketData
import com.ravish.restapiexample.repository.ApiResponseRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiResponseViewModel(private val repository: ApiResponseRepository): ViewModel() {

    val marketDataList = MutableLiveData<List<MarketData>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllApiResponse(){

        val response = repository.getAllApiResponse()
        response.enqueue(object: Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.body() != null){
                    marketDataList.postValue(response.body()!!.markets)
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}