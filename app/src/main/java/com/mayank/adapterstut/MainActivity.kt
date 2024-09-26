package com.mayank.adapterstut

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        // 1-> Initializing List View
        // List View : Displays a scrollable list of items
        val myListView:ListView=findViewById(R.id.listView)

        // 2-> Data Source
        // The underlying set of data that listview displays
        val operatingSystem = listOf("Windows","Linux","iOS","Android")

        // 3-> Adapter
        // The listview doesn't directly hold the data,it displays
        // Instead it relies on an adapter to populate the data

        // The adapter is responsible for creating views for each item in the data source
        // and binding data to those views

        // Use the below code when not using custom layout
        // val myAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,operatingSystem)

        val customAdapter = MyCustomAdapter(this,operatingSystem)

        // 4-> Set adapter to listview
        myListView.adapter=customAdapter
    }
}