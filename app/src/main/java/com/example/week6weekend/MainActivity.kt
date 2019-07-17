package com.example.week6weekend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
    fun onClick(view: View){
        var okhttp:Okhttp;
        okhttp=Okhttp()
        okhttp.getTempZip(this,edZip.text.toString())

        okhttp.getTempDate(this,edZip.text.toString())
    }
}
