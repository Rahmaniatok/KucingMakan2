package com.example.kucingmakan2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataFood = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Food>("key_food", Food::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Food>("key_food")
        }
        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val tvHistory = findViewById<TextView>(R.id.tv_history)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)

        if (dataFood != null) {
            tvDetailName.text = dataFood.name
        }
        if (dataFood != null) {
            tvDetailDescription.text = dataFood.description
        }
        if (dataFood != null) {
            tvHistory.text = dataFood.history
        }
        if (dataFood != null) {
            ivDetailPhoto.setImageResource(dataFood.photo)
        }
    }
}