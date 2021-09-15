package com.example.retrofittesting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatagoriesAdapter(var catagories:List<String>) : RecyclerView.Adapter<CatagoriesAdapter.CatagoriesViewHelder>() {
    lateinit var catagoriesLestiner:IPersonListener
    class CatagoriesViewHelder(view:View):RecyclerView.ViewHolder(view){
        var catagoryText=view.findViewById<TextView>(R.id.catagoriesText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatagoriesViewHelder {
        return CatagoriesViewHelder(LayoutInflater.from(parent.context).inflate(R.layout.catagories_item,parent,false))
    }


    override fun onBindViewHolder(holder: CatagoriesViewHelder, position: Int) {
        holder.catagoryText.text=catagories.get(position)
        holder.itemView.setOnClickListener {
        catagoriesLestiner.itemViewListener(position)
        }
    }

    override fun getItemCount(): Int {
       return catagories.size
    }
    interface IPersonListener{
        public fun itemViewListener(position:Int)
    }
}