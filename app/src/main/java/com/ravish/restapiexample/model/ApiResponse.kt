package com.ravish.restapiexample.model

/**
 * Data class for the Response that we are getting from the Rest Api
 */
data class ApiResponse (

    val markets: List<MarketData>
)