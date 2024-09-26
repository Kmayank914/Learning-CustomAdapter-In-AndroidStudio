package com.mayank.adapterstut

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyCustomAdapter(private val context: Context, private val items:List<String>):BaseAdapter() {
    override fun getCount(): Int {
        // returns the number of items in the data set
        return items.size
    }

    override fun getItem(position: Int): Any {
        // Returns the data item associated with the specified position in the data set
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        // Returns a unique identifier for the item at the specified position
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Returns a view that displays the data at the specified position in the data set
        // convertView : recycled view that can be reused to optimise performance
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view:View
        if (convertView==null){
            // inflate a new view using layout inflater
            view = inflater.inflate(R.layout.my_custom_layout,parent,false)
        }
        else {
            // If convertView is not null, Reuse it
            view = convertView
        }

        // Bind the data
        val item = getItem(position) as String
        val titleTextView = view.findViewById<TextView>(R.id.textViewCustom)
        titleTextView.text = item
        return view

    }
}