package com.example.retrofittesting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide


class ProductDetailsFragment : Fragment() {
var myProduct=ArrayList<Product>()
//
lateinit var catageyViewModel: PrudectViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catageyViewModel= ViewModelProvider(this).get(PrudectViewModel::class.java)
//        val data = requireArguments().getString("data")
//        if(data!=null){
//            Log.d("ttt",data)
//        }
        if(!myProduct.isEmpty()){
        catageyViewModel.myProductDetials=myProduct
        Log.d("ttt",catageyViewModel.myProductDetials.toString())}
        var detailsImg=view.findViewById<ImageView>(R.id.productDetailsImg)
        var detailsTitle=view.findViewById<TextView>(R.id.productDetailsTitle)
        var detailsPrice=view.findViewById<TextView>(R.id.PrudoctDetailsPrice)
        var detailsCatagory=view.findViewById<TextView>(R.id.PrudoctDetailsCatagory)
        var detailsDescription=view.findViewById<TextView>(R.id.productDetailsDescription)
        Glide.with(view.context).load(catageyViewModel.myProductDetials[0].image!!).into(detailsImg)
        detailsTitle.text=catageyViewModel.myProductDetials[0].title
        detailsPrice.text="${catageyViewModel.myProductDetials[0].price.toString()}$"
        detailsCatagory.text="Catagory: ${catageyViewModel.myProductDetials[0].category}"
        detailsDescription.text=catageyViewModel.myProductDetials[0].description




    }




//    override fun itemClicked(item: Product) {
//        PrudectViewModel().myProductDetials.add(item)
//
//    }


}