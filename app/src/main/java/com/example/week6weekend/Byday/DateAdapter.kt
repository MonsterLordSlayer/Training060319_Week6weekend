package com.example.week6weekend.Byday



import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week6weekend.R
import kotlinx.android.synthetic.main.item.view.*


class DateAdapter(val items: kotlin.collections.List<List>?, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        if (items != null) {
            return items.size
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.tvDate?.text = items?.get(position)?.dtTxt
        holder?.tvHottest?.text=(items?.get(position)?.main?.tempMax).toString()
        holder?.tvColdest?.text=(items?.get(position)?.main?.tempMax).toString()

    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val tvDate=view.tvdate
    val tvHottest=view.tvHottest
    val tvColdest=view.tvColdest
}