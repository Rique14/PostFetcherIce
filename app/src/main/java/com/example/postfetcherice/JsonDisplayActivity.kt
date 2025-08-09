package com.example.postfetcherice

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class JsonDisplayActivity : AppCompatActivity() {

    private lateinit var tvJsonData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_display)

        tvJsonData = findViewById(R.id.tvJsonData)

        val jsonData = intent.getStringExtra("json_data")
        if (jsonData != null) {
            // Pretty print JSON string
            val prettyJson = try {
                val jsonObject = com.google.gson.JsonParser.parseString(jsonData).asJsonObject
                com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson(jsonObject)
            } catch (e: Exception) {
                jsonData
            }
            tvJsonData.text = prettyJson
        } else {
            tvJsonData.text = "No JSON data received."
        }
    }
}
