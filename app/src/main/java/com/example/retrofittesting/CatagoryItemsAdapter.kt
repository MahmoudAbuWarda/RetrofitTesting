package com.example.retrofittesting

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CatagoryItemsAdapter(var product:List<Product>): RecyclerView.Adapter<CatagoryItemsAdapter.CatagoryItemsViewHolder>() {
   lateinit var catagoryItemListener:ICatListener
    class CatagoryItemsViewHolder(view:View):RecyclerView.ViewHolder(view){
        var catImg=view.findViewById<ImageView>(R.id.catPrudectImg)
        var catTxt=view.findViewById<TextView>(R.id.catPrudectTxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatagoryItemsViewHolder {
        return CatagoryItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.catagoryitem,parent,false))
    }

    override fun onBindViewHolder(holder: CatagoryItemsViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(product.get(position).image).into(holder.catImg)
        holder.catTxt.text=product.get(position).title
      holder.itemView.setOnClickListener {
          catagoryItemListener.itemViewListener(position)

      }

    }

    override fun getItemCount(): Int {
        return product.size
    }
    interface ICatListener{
        public fun itemViewListener(position: Int)
    }
}