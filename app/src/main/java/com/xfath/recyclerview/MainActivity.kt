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

        val listBahasa: ArrayList<BahasaPemprograman> = ArrayList()

        listBahasa.add(BahasaPemprograman("Kotlin", R.drawable.kotlin))
        listBahasa.add(BahasaPemprograman("Java", R.drawable.java))
        listBahasa.add(BahasaPemprograman("Flutter", R.drawable.flutter))

        val bahasaAdapter = BahasaAdapter(listBahasa) { item ->
            Toast.makeText(this, item.namaBahasa, Toast.LENGTH_LONG).show()
        }

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = bahasaAdapter
    }
}