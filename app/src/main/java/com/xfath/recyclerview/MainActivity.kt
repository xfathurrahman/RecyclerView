package com.xfath.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.xfath.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val listBahasaModel: ArrayList<BahasaPemprogramanModel> = ArrayList()

        listBahasaModel.add(BahasaPemprogramanModel("Kotlin", R.drawable.kotlin))
        listBahasaModel.add(BahasaPemprogramanModel("Java", R.drawable.java))
        listBahasaModel.add(BahasaPemprogramanModel("Flutter", R.drawable.flutter))

        val bahasaAdapter = BahasaAdapter(listBahasaModel) { item ->
            Toast.makeText(this, item.namaBahasa, Toast.LENGTH_LONG).show()
        }

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = bahasaAdapter
    }
}