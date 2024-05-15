package com.example.kucingmakan2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvFoods: RecyclerView
    private val list = ArrayList<Food>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvFoods = findViewById(R.id.rv_foods)
        rvFoods.setHasFixedSize(true)

        val ibProfile = findViewById<ImageButton>(R.id.ib_profile)
        ibProfile.setOnClickListener(this)

        list.addAll(getListFoods())
        showRecyclerList()
    }

    override fun onClick(v: View?){
        if (v != null) {
            when(v.id){
                R.id.ib_profile ->{
                    val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                    startActivity(moveIntent)
                }
            }
        }
    }

    private fun getListFoods(): ArrayList<Food> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataHistory = resources.getStringArray(R.array.data_history)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Food>()
        for (i in dataName.indices) {
            val food = Food(dataName[i], dataDescription[i], dataHistory[i], dataPhoto.getResourceId(i, -1))
            listHero.add(food)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFoods.adapter = listFoodAdapter
    }
}