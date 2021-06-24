package com.ravish.restapiexample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ravish.restapiexample.R
import com.ravish.restapiexample.adpter.ApiResponseAdapter
import com.ravish.restapiexample.model.ApiResponse
import com.ravish.restapiexample.model.MarketData
import com.ravish.restapiexample.networking.RetrofitService
import com.ravish.restapiexample.repository.ApiResponseRepository
import com.ravish.restapiexample.viewmodel.ApiResponseViewModel
import com.ravish.restapiexample.viewmodel.ApiResponseViewModelFactory

class MainActivity : AppCompatActivity() {

    /** Variable for the Log Tag. */
    private val TAG = "MainActivity"
    private lateinit var recyclerView: RecyclerView

    /** Initializing the variable for the adapter, progress bar and view model.*/
    private lateinit var adapter: ApiResponseAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var viewModel: ApiResponseViewModel
    private val retrofitService: RetrofitService = RetrofitService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // binding the recyclerview and progress bar with corresponding xml file.
        recyclerView = findViewById(R.id.api_response_recyclerview)
        progressBar = findViewById(R.id.progress_bar)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ApiResponseAdapter(this)

        // initializing the view model with the custom view model factory
        viewModel = ViewModelProvider(this, ApiResponseViewModelFactory(ApiResponseRepository(retrofitService))).get(ApiResponseViewModel::class.java)

        // observing the live data that we are getting from the view model
        // which will give the data of the List<MarketData> and then setting with the adapter
        viewModel.marketDataList.observe(this, Observer {
            adapter.setMarketDataList(it)
            progressBar.visibility = View.GONE
        })


        // If any error occurs then displaying the error message in the Log message.
        viewModel.errorMessage.observe(this, Observer {
            Log.e(TAG, it)
        })

        viewModel.getAllApiResponse()
        // Setting the adapter with the recyclerview.
        recyclerView.adapter = adapter

    }

}