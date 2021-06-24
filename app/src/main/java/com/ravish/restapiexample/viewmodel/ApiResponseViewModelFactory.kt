package com.ravish.restapiexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ravish.restapiexample.repository.ApiResponseRepository
import java.lang.IllegalArgumentException

class ApiResponseViewModelFactory(private val repository: ApiResponseRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ApiResponseViewModel::class.java)){
            ApiResponseViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}