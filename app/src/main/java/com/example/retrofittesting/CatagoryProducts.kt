package com.example.retrofittesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CatagoryProducts : AppCompatActivity() {
    var p:String?=null
    lateinit var adapter: CatagoryItemsAdapter
    var product=ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catagory_products)
         p=intent.getStringExtra("catagoryname")

        var storeOperations=StoreOperations("https://fakestoreapi.com/")

        storeOperations.getCatagory(p!!).observe(this,{
            if(it.result==StoreResponse.SUCCESS){

                it.response?.forEach {

                    product.add(it)
                    adapter.notifyDataSetChanged()

                }
            }else{
                Toast.makeText(applicationContext,"Error!", Toast.LENGTH_LONG).show()

            }

        })
            var rv=findViewById<RecyclerView>(R.id.catagoryItemrv)
        adapter= CatagoryItemsAdapter(product)
//        adapter.catagoryItemListener=object :CatagoryItemsAdapter.ICatListener{
//            override fun itemViewListener(position: Int) {
//              var intent=Intent(applicationContext,ProductDetails::class.java)
//                var id=product.get(position).id
//                intent.putExtra("productid",id)
//                startActivity(intent)
//            }
//        }
        rv.adapter=adapter
        rv.layoutManager=GridLayoutManager(applicationContext,3,RecyclerView.VERTICAL,false)






    }
}