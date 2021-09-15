package com.example.retrofittesting

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import retrofit2.*

class MainActivity : AppCompatActivity(),MyListFragment.ListFragmentListener,WomanFragment.WomensFragmentListener,BlueFragment.ElectronicFragmentListener,GreenFragment.JeweleryFragmentListener,RedFragment.mensFragmentListener {
    lateinit var elecronicFragment:BlueFragment
    lateinit var jeweleryFragment:GreenFragment
    lateinit var mensFragment:RedFragment
    lateinit var womenFragment: WomanFragment
    lateinit var drawerLayout: DrawerLayout
    lateinit var productDetailsFragment: ProductDetailsFragment
    lateinit var catageyViewModel: PrudectViewModel
//    lateinit var catagoryPrudoctsFragment: CatagoryPrudoctsFragment
//
    //lateinit var adapter: CatagoriesAdapter
   var product=ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        catageyViewModel= ViewModelProvider(this).get(PrudectViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout=findViewById(R.id.drawerLayout)

        var toolBar=findViewById<Toolbar>(R.id.myToolbar)
        setSupportActionBar(toolBar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

       elecronicFragment= BlueFragment()
        jeweleryFragment= GreenFragment()
        mensFragment= RedFragment()
        womenFragment= WomanFragment()
       productDetailsFragment= ProductDetailsFragment()
//        catagoryPrudoctsFragment= CatagoryPrudoctsFragment()

//        var storeOperations=StoreOperations("https://fakestoreapi.com/")
//
//        storeOperations.getCatagories().observe(this,{
//            if(it.result==StoreResponse.SUCCESS){
//
//                catagories.addAll(it.response!!)
//                adapter.notifyDataSetChanged()
//
//            }else{
//                Toast.makeText(applicationContext,"Error!",Toast.LENGTH_LONG).show()
//            }
//        })
//
//
//
//        var rv=findViewById<RecyclerView>(R.id.catagoriesrv)
//        adapter= CatagoriesAdapter(catagories)
//        adapter.catagoriesLestiner= object : CatagoriesAdapter.IPersonListener {
//            override fun itemViewListener(position: Int) {
//            var intent= Intent(applicationContext,CatagoryProducts::class.java)
//                intent.putExtra("catagoryname",catagories[position])
//                startActivity(intent)
//            }
//
//        }
//        rv.adapter=adapter
//        rv.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)



//        storeOperations.getPrudects().observe(this ,{
//
//
//            if(it.result==StoreResponse.SUCCESS){
//                if(it.response!=null){
//                catagories.addAll(it.response!!)
//                adapter.notifyDataSetChanged()
//                }
////                it.response?.forEach {
////
////                Log.d("ttt",it.category)}
//            }else{
//                Log.d("ttt",it.errorMessage!!)
//            }
//        })

    //    adapter.notifyDataSetChanged()

//        storeOperations.getCatagory("electronics").observe(this,{
//            if(it.result==StoreResponse.SUCCESS){
//                Log.d("ttt","success")
//                for(i in it.response!!){
//                    Log.d("ttt","for loop ${i.toString()}")
//                }
//                it.response?.forEach {
//                    Log.d("ttt",it.id.toString())
//                }
//            }else{
//                Log.d("ttt",it.errorMessage!!)
//            }
//        })








//        var moshi= Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
//        var retrofit=Retrofit.Builder().baseUrl("https://fakestoreapi.com/").addConverterFactory(MoshiConverterFactory.create(moshi)).build()
//        var client= retrofit.create(FakeStoreApi::class.java)
//        var getPruductBtn= findViewById<Button>(R.id.getProdeuctBtn)
////        getPruductBtn.setOnClickListener {
//            client.getPrudects(5,"desc").enqueue(object:Callback<List<Product>>{
//                override fun onResponse(
//                    call: Call<List<Product>>,
//                    response: Response<List<Product>>
//                ) {
//                    if(response.isSuccessful){
//                       var prudocts= response.body()
//                        if(prudocts!=null){
//                        for(p in prudocts){
//                            Log.d("ttt",p.title)
//                           // Toast.makeText(applicationContext,p.title,Toast.LENGTH_LONG).show()
//                        }}
//
//                    }
//                }
//
//                override fun onFailure(call: Call<List<Product>>, t: Throwable) {
//                    Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
//                }
//            })
      //  }
//
//        var categoriesBtn=findViewById<Button>(R.id.getCatogeryBtn)
//        categoriesBtn.setOnClickListener {
//            client.getCatogories().enqueue(object:Callback<List<String>>{
//                override fun onResponse(
//                    call: Call<List<String>>,
//                    response: Response<List<String>>
//                ) {
//                    if(response.isSuccessful){
//                        response.body()?.forEach {
//                            Log.d("ttt",it.toString())
//                        }
//
//                    }
//                }
//
//                override fun onFailure(call: Call<List<String>>, t: Throwable) {
//                    Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
//                }
//
//
//            })
//        }
//        var getPBtn=findViewById<Button>(R.id.getPBtn)
//        getPBtn.setOnClickListener {
//            client.getPrudect(4).enqueue(object:Callback<Product>{
//                override fun onResponse(call: Call<Product>, response: Response<Product>) {
//                    if(response.isSuccessful){
//                        Log.d("ttt",response.body()?.title.toString())
//                    }
//                }
//
//                override fun onFailure(call: Call<Product>, t: Throwable) {
//                    Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
//                }
//
//            })
//        }
//        var addProductBtn=findViewById<Button>(R.id.addProductBtn)
//        addProductBtn.setOnClickListener {
//            var p=Product(title="dsdfsd",price = 1.5,description = "dsds",image = "dsdds",category = "dsd")
//            client.addPrudoct(p).enqueue(object:Callback<Product>{
//                override fun onResponse(call: Call<Product>, response: Response<Product>) {
//                    if(response.isSuccessful)
//                    {
//                        Log.d("ttt",response.body()?.id.toString())
//                    }
//                }
//
//                override fun onFailure(call: Call<Product>, t: Throwable) {
//                    Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
//                }
//            })
//
//        }
    }
    override fun itemClicked(item:String){
     //   CatagoryPrudectsRecyclerView
//        catagoryPrudoctsFragment.searchWord=item
//        supportFragmentManager.beginTransaction().replace(R.id.mainContainer,catagoryPrudoctsFragment).commit()


   if(item=="electronics"){

    //   elecronicFragment.catagory="electronics"
        supportFragmentManager.beginTransaction().replace(R.id.mainContainer,elecronicFragment).commit()
   }
    else if(item=="jewelery"){

        supportFragmentManager.beginTransaction().replace(R.id.mainContainer,jeweleryFragment).commit()
    }
    else if(item=="men's clothing"){

        supportFragmentManager.beginTransaction().replace(R.id.mainContainer,mensFragment).commit()
    }
   else if(item=="women's clothing"){
        supportFragmentManager.beginTransaction().replace(R.id.mainContainer,womenFragment).commit()

    }
        drawerLayout.closeDrawer(GravityCompat.START)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==android.R.id.home){
            if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            else{
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun itemClicked(item: Product) {

//
        if(item!=null){
            productDetailsFragment.myProduct.clear()
       // catageyViewModel.myProductDetials.clear()
        product.clear()}
     //   ProductDetailsFragment().myProduct.clear()
        if(item!=null){
            supportFragmentManager.beginTransaction().replace(R.id.mainContainer,productDetailsFragment).commit()
        product.add(item)
          //  PrudectViewModel().myProductDetials.add(item)
          productDetailsFragment.myProduct.add(item)
//            catageyViewModel.myProductDetials.add(item)
//



        }
        Log.d("ttt"," testing ${product.toString()}")

    }
    public interface MainActivityListener{
        public fun itemPassed(item:Product)

    }

//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        getMenuInflater().inflate(R.menu.menu_search, menu);
//        return super.onPrepareOptionsMenu(menu)
//    }
}