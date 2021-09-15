package com.example.retrofittesting

class StoreResponse <T>{
    var response:T?=null
    var errorMessage:String?=null
    var result:Int?=null
    companion object{
        public val SUCCESS=1
        public val FAIL=2
    }
}