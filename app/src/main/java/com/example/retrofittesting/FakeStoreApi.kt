package com.example.retrofittesting

import retrofit2.Call
import retrofit2.http.*

interface FakeStoreApi {
    @GET("products")
    public fun getPrudects(): Call<List<Product>>

    @GET("products/categories")
    public fun getCatogories():Call<List<String>>

    @GET("products/category/{categoriesname}")
    public fun getCaltogetory(@Path("categoriesname") catagoryName:String):Call<List<Product>>

    @GET("products/{productid}")
    public fun getPrudect(@Path("productid") id:Int):Call<Product>

    @GET("products")
    public fun getPrudects(@Query("limit") limit:Int,@Query("sort") sort:String):Call<List<Product>>

    @POST("products")
    public fun addPrudoct(@Body product:Product) :Call<Product>

    @PUT("products/{productID}")
    public fun updateProduct(@Path("productID") productID:Int,product: Product):Call<Product>

    @DELETE("products/{id}")
    public fun deleteProduct(@Path("id") id:Int):Call<Product>

}