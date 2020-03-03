package com.example.nasaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
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
            Request.Method.GET,
            url,
            Response.Listener<String1> { response -> textView.text="Response is: ${response.substring(0,500)}" },
            Response.ErrorListener { textView.text="Error kal 3ada" }
        )
        req.add(strReq)
    }
}
