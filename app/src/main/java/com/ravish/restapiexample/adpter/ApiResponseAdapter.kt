package com.ravish.restapiexample.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ravish.restapiexample.R
import com.ravish.restapiexample.model.ApiResponse
import com.ravish.restapiexample.model.MarketData

class ApiResponseAdapter(val context: Context ) :
    RecyclerView.Adapter<ApiResponseAdapter.ApiResponseViewHolder>() {

    private var marketDataList: List<MarketData> = arrayListOf()

    fun setMarketDataList(marketDataList: List<MarketData>){
        this.marketDataList = marketDataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiResponseViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.single_item_view, parent, false)
        return ApiResponseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApiResponseViewHolder, position: Int) {
        val marketData: MarketData = marketDataList.get(position)

        holder.exchange_id.text = marketData.exchange_id
        holder.symbol.text  = marketData.symbol
        holder.price_unconverted.text = marketData.price_unconverted.toString()
        holder.price.text = marketData.price.toString()
        holder.change_24h.text = marketData.change_24h.toString()
        holder.spread.text = marketData.spread.toString()
        holder.volume_24h.text = marketData.volume_24h.toString()
        holder.status.text = marketData.status
        holder.time.text = marketData.time
    }

    override fun getItemCount(): Int {
        return marketDataList.size
    }

    class ApiResponseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var exchange_id = itemView.findViewById<TextView>(R.id.tv_exchange_id)
        var symbol = itemView.findViewById<TextView>(R.id.tv_symbol)
        var price_unconverted = itemView.findViewById<TextView>(R.id.tv_price_unconverted)
        var price = itemView.findViewById<TextView>(R.id.tv_price)
        var change_24h = itemView.findViewById<TextView>(R.id.tv_change_24h)
        var spread = itemView.findViewById<TextView>(R.id.tv_spread)
        var volume_24h = itemView.findViewById<TextView>(R.id.tv_volume_24h)
        var status = itemView.findViewById<TextView>(R.id.tv_status)
        var time = itemView.findViewById<TextView>(R.id.tv_time)
    }
}