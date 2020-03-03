package com.example.nasaapi

import android.app.DownloadManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.String as String1


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        main()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun main()
    {
        val url="https://api.nasa.gov/planetary/apod?api_key=jTcWV0pmMmG6SOjwIGacrJLlDm1Vj5fmZsO0TBMP"
        val req=Volley.newRequestQueue(this)
        val strReq=StringRequest(
            com.android.volley.Request.Method.GET,
            url,
            Response.Listener<String1> { response -> textView.text="Response is: ${response.substring(0,500)}" },
            Response.ErrorListener { textView.text="Error kal 3ada" }
        )
        val model = Model() //An object to carry api data
        req.add(strReq)
    }
}
