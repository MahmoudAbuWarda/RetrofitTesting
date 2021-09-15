package com.example.retrofittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class ProductDetails : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        var detailsImg=findViewById<ImageView>(R.id.productDetailsImg)
        var detailsTitle=findViewById<TextView>(R.id.productDetailsTitle)
        var detailsPrice=findViewById<TextView>(R.id.PrudoctDetailsPrice)
        var detailsCatagory=findViewById<TextView>(R.id.PrudoctDetailsCatagory)
        var detailsDescription=findViewById<TextView>(R.id.productDetailsDescription)

       var i=intent.getIntExtra("productid",-1)
        var storeOperations=StoreOperations("https://fakestoreapi.com/")
        storeOperations.getPrudect(i).observe(this,{
            if(it.result==StoreResponse.SUCCESS){
                Glide.with(applicationContext).load(it.response?.image!!).into(detailsImg)
               detailsTitle.text=it.response?.title
                detailsPrice.text="${it.response?.price.toString()}$"
                detailsCatagory.text="Catagory: ${it.response?.category}"
                detailsDescription.text=it.response?.description
                //it.response.image

            }else{
               Toast.makeText(applicationContext,"Error!",Toast.LENGTH_LONG).show()

            }

        })


    }
}