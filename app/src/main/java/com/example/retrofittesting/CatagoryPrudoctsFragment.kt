package com.example.retrofittesting

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CatagoryPrudoctsFragment : Fragment() {

    lateinit var adapter: CatagoryItemsAdapter
    var product=ArrayList<Product>()
    var searchWord=""



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_woman, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        var storeOperations=StoreOperations("https://fakestoreapi.com/")
//        var rv=view.findViewById<RecyclerView>(R.id.mensRecyclerView)
//
//
//
//
//
//        storeOperations.getCatagory("women's clothing").observe(viewLifecycleOwner,{
//            if(it.result==StoreResponse.SUCCESS){
//                product.clear()
//                it.response?.forEach {
//                    //  Log.d("ttt",it.title)
//                    product.add(it)
//                    adapter.notifyDataSetChanged()
//
//                }
//
//            }else{
//                Toast.makeText(view.context,"Error!", Toast.LENGTH_LONG).show()
//
//            }
//
//        })


//        for(i in product){
//            Log.d("ttt",i.toString())
//        }
        //  Log.d("ttt",product[0]?.title.toString())
//        rv.adapter=adapter
//        rv.layoutManager= GridLayoutManager(view.context,3, RecyclerView.VERTICAL,false)

    }


}