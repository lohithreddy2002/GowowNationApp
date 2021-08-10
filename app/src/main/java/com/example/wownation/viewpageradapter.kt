package com.example.wownation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class viewpageradapter(val images : List<viewpagerdata>): RecyclerView.Adapter<viewpageradapter.viewpagerholder>() {

    class viewpagerholder(itemview : View): RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewpagerholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpagerlayout,parent,false)
        return viewpagerholder(view)
    }

    override fun onBindViewHolder(holder: viewpagerholder, position: Int) {
        holder.itemView.findViewById<ImageView>(R.id.imageView).setImageResource(images[position].id)
        holder.itemView.findViewById<TextView>(R.id.viewpagertext).text = images[position].text
    }

    override fun getItemCount(): Int {
        return  images.size
    }
}

data class viewpagerdata(
    val id:Int,
    val text:String
)