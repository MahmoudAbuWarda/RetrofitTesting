package com.example.retrofittesting

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PrudectViewModel: ViewModel() {
    public var catagories=ArrayList<String>()
    public var storeOperations=StoreOperations("https://fakestoreapi.com/")
 public var myProductDetials=ArrayList<Product>()
    public fun getCatagories():LiveData<StoreResponse<List<String>>>{
        return storeOperations.getCatagories()
    }

    public fun getCatagory(catagoryname:String):LiveData<StoreResponse<List<Product>>>{
        return storeOperations.getCatagory(catagoryname)
    }
}