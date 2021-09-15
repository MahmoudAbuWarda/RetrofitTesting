package com.example.retrofittesting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class StoreOperations (baseUrl:String){
     lateinit var client:FakeStoreApi
    init {
        var moshi= Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        var retrofit= Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
            MoshiConverterFactory.create(moshi)).build()
        client= retrofit.create(FakeStoreApi::class.java)

    }


    public fun getPrudects():LiveData<StoreResponse<List<Product>>>{
        var prudectLiveData=MutableLiveData<StoreResponse<List<Product>>>()
        client.getPrudects().enqueue(object :Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
              if(response.isSuccessful){
                var storeResponse=StoreResponse<List<Product>>().apply {
                    this.response=response.body()
                    this.result=StoreResponse.SUCCESS

                }
                  prudectLiveData.value=storeResponse

              }
            }


            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                var storeResponse=StoreResponse<List<Product>>().apply {
                    this.result=StoreResponse.FAIL
                    this.errorMessage=t.message
                }
                prudectLiveData.value=storeResponse
            }

        })



        return  prudectLiveData
    }

    public fun getPrudect(id:Int):LiveData<StoreResponse<Product>>{
        var prudectLiveData=MutableLiveData<StoreResponse<Product>>()
        client.getPrudect(id).enqueue(object :Callback<Product>{
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if(response.isSuccessful){
                    var storeResponse=StoreResponse<Product>().apply {
                        this.response=response.body()
                        this.result=StoreResponse.SUCCESS

                    }
                    prudectLiveData.value=storeResponse

                }
            }


            override fun onFailure(call: Call<Product>, t: Throwable) {
                var storeResponse=StoreResponse<Product>().apply {
                    this.result=StoreResponse.FAIL
                    this.errorMessage=t.message
                }
                prudectLiveData.value=storeResponse
            }

        })



        return  prudectLiveData
    }

   public fun getCatagories():LiveData<StoreResponse<List<String>>>{
       var prudectLiveData=MutableLiveData<StoreResponse<List<String>>>()
       client.getCatogories().enqueue(object :Callback<List<String>>{
           override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
               if(response.isSuccessful){
                   var storeResponse=StoreResponse<List<String>>().apply {
                       this.response=response.body()
                       this.result=StoreResponse.SUCCESS

                   }
                   prudectLiveData.value=storeResponse

               }
           }

           override fun onFailure(call: Call<List<String>>, t: Throwable) {
               var storeResponse=StoreResponse<List<String>>().apply {
                   this.result=StoreResponse.FAIL
                   this.errorMessage=t.message
               }
               prudectLiveData.value=storeResponse
           }


       })
       return prudectLiveData
   }
    public fun getCatagory(catagoryname:String):LiveData<StoreResponse<List<Product>>>{
        var prudectLiveData=MutableLiveData<StoreResponse<List<Product>>>()
        client.getCaltogetory(catagoryname).enqueue(object :Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if(response.isSuccessful){
                    var storeResponse=StoreResponse<List<Product>>().apply {
                        this.response=response.body()
                        this.result=StoreResponse.SUCCESS

                    }
                    prudectLiveData.value=storeResponse

                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                var storeResponse=StoreResponse<List<Product>>().apply {
                    this.result=StoreResponse.FAIL
                    this.errorMessage=t.message
                }
                prudectLiveData.value=storeResponse
            }
        })

        return prudectLiveData
    }



}