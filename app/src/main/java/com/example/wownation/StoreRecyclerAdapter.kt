package com.example.wownation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StoreRecyclerAdapter : RecyclerView.Adapter<StoreRecyclerAdapter.vh>() {
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
            LayoutInflater.from(parent.context).inflate(R.layout.storerecycleitem, parent, false)
        return vh(view)
    }

    override fun onBindViewHolder(holder: vh, position: Int) {
        val image = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(image.Image).into(holder.itemView.findViewById(R.id.imgview))
            holder.itemView.setOnClickListener {
                val extras = FragmentNavigatorExtras(holder.itemView.findViewById<ImageView>(R.id.imgview) to "imageitem")
                findNavController().navigate(
                    R.id.action_homeFragment_to_storeItemFragment,
                    null,
                    null,
                    extras
                )
            }

//            setOnClickListener {
//                onItemClickListener.let { x ->
//                    if (x != null) {
//                        x(image,findViewById(R.id.imgview))
//                    }
//                }
//            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    private var onItemClickListener: ((Store,ImageView) -> Unit)? = null

    fun setOnItemClickListner(listener: (Store, ImageView) -> Unit) {
        onItemClickListener = listener
    }
}