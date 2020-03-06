package com.example.nasaapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
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
            Response.Listener<String1> {
                    response ->
                val jsonObj: JSONObject = JSONObject(response)
                val model:Model= Model()
                model.date = jsonObj.getString("date")
                model.explanation = jsonObj.getString("explanation")
                model.url = jsonObj.getString("url")
                dateView.text = model.date
                ContetView.text = model.explanation
                Picasso.with(this).load(model.url).into(imageview1)

            },
            Response.ErrorListener { ContetView.text = "Error kal 3ada" }
        )
        req.add(strReq)
    }
}
