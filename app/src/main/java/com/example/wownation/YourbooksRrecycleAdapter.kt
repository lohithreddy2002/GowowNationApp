package com.example.wownation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.progressindicator.LinearProgressIndicator

class YourbooksRrecycleAdapter:RecyclerView.Adapter<YourbooksRrecycleAdapter.vh>() {
    class vh(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffcallback = object : DiffUtil.ItemCallback<Store>() {
        override fun areItemsTheSame(oldItem: Store, newItem: Store): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Store, newItem: Store): Boolean {
            return oldItem.id == newItem.id
        }

    }
    val differ = AsyncListDiffer(this, diffcallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.test, parent, false)
        return vh(view)
    }

    override fun onBindViewHolder(holder: vh, position: Int) {
        val image = differ.currentList[position]
        holder.itemView.apply {
            findViewById<LinearProgressIndicator>(R.id.readprogress).progress = image.progress
            Glide.with(this).load(image.Image).into(holder.itemView.findViewById(R.id.imgview))
            setOnClickListener {
                onItemClickListener.let { x ->
                    if (x != null) {
                        x(image)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    private var onItemClickListener: ((Store) -> Unit)? = null

    fun setOnItemClickListner(listener: (Store) -> Unit) {
        onItemClickListener = listener
    }
}