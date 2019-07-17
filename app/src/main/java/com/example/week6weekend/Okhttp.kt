package com.example.week6weekend

import android.content.Context
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6weekend.Byday.Byday
import com.example.week6weekend.Byday.DateAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request

class Okhttp {

    companion object{
        var apiid="182ebc7284818f43f14cbf362241b270";
    }
    public fun getTempZip(context:Context,zip:String){
        val returnClient = OkHttpClient.Builder().build()
        var zip2=zip
        if (zip2=="") zip2="30047"
        val request =
            Request.Builder().url("http://api.openweathermap.org/data/2.5/weather?zip="+zip2+",us&appid="+ apiid)
                .build()
        val thread = Thread(Runnable {
            try {
                val response = returnClient.newCall(request).execute()

                val gson = Gson()
                var current: Zip
                current=gson.fromJson(response.body()!!.string(),Zip::class.java)
                //RandomResponse randomresponse= gson.fromJson(response.body().string(),RandomResponse.class);
                //Log.d("TAG syncrespond", " "+randomresponse.getResults().size());

                Log.d("TAG syncrespond2", ""+ (current.main?.temp ?: "nothing"))
                var temp= current.main?.temp
                (context as MainActivity).runOnUiThread(Runnable {
                    ((context as MainActivity).findViewById<TextView>(R.id.tvTemperature)).setText(""+current.main?.temp ?: "nothing")
                    if (temp !=null && temp>60f){
                        (context as MainActivity).tvTemperature.setTextColor(context.resources.getColor(R.color.hottest))

                    }
                    else (context as MainActivity).tvTemperature.setTextColor(context.resources.getColor(R.color.coldest))
                })
            } catch (e: Exception) {
                e.printStackTrace();



            }
        })
        thread.start()

    }
    public fun getTempDate(context:Context,zip:String){
        //http://api.openweathermap.org/data/2.5/forecast?zip=30047,us&appid=182ebc7284818f43f14cbf362241b270
        val returnClient = OkHttpClient.Builder().build()
        var zip2=zip
        if (zip2=="") zip2="30047"
        val request =
            Request.Builder().url("http://api.openweathermap.org/data/2.5/forecast?zip="+zip2+",us&appid="+ apiid)
                .build()
        val thread = Thread(Runnable {
            try {
                val response = returnClient.newCall(request).execute()

                val gson = Gson()
                var current:Byday
                current=gson.fromJson(response.body()!!.string(),Byday::class.java)
                //RandomResponse randomresponse= gson.fromJson(response.body().string(),RandomResponse.class);
                //Log.d("TAG syncrespond", " "+randomresponse.getResults().size());

                Log.d("TAG syncrespond2", ""+ (current.list?.get(1)?.dtTxt?: "nothing"))
                (context as MainActivity).runOnUiThread(Runnable {
                    var rvList=((context as MainActivity).findViewById<RecyclerView>(R.id.rvList))
                    var adapter=DateAdapter(current.list,context)
                    rvList.layoutManager=LinearLayoutManager(context)
                    rvList.adapter=adapter
                })


            } catch (e: Exception) {
                e.printStackTrace();



            }
        })
        thread.start()

    }
}