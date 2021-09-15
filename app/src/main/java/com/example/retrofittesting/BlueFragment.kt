package com.example.retrofittesting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BlueFragment : Fragment() {
    lateinit var adapter: CatagoryItemsAdapter
    lateinit var catageyViewModel: PrudectViewModel
    var catagory=""
    var product=ArrayList<Product>()
    var listener: ElectronicFragmentListener?=null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MyListFragment.ListFragmentListener){
            listener=context as ElectronicFragmentListener
        }

    }

    override fun onDetach() {
        super.onDetach()
        listener=null
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_woman, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catageyViewModel= ViewModelProvider(this).get(PrudectViewModel::class.java)

        var rv=view.findViewById<RecyclerView>(R.id.womensRecyclerView)





        catageyViewModel.getCatagory("electronics").observe(viewLifecycleOwner,{
            if(it.result==StoreResponse.SUCCESS){
                product.clear()
                it.response?.forEach {
                    //  Log.d("ttt",it.title)
                    product.add(it)
                    adapter.notifyDataSetChanged()

                }

            }else{
                Toast.makeText(view.context,"Error!", Toast.LENGTH_LONG).show()

            }

        })

        adapter= CatagoryItemsAdapter(product)
        adapter.catagoryItemListener=object :CatagoryItemsAdapter.ICatListener{
            override fun itemViewListener(position: Int) {
                listener?.itemClicked(product.get(position))



//                var intent= Intent(view.context,ProductDetails::class.java)
//                var id=product.get(position).id
//                intent.putExtra("productid",id)
//                startActivity(intent)
            }
        }
//        for(i in product){
//            Log.d("ttt",i.toString())
//        }
        //  Log.d("ttt",product[0]?.title.toString())
        rv.adapter=adapter
        rv.layoutManager= GridLayoutManager(view.context,2, RecyclerView.VERTICAL,false)

    }
    public interface ElectronicFragmentListener{
        public fun itemClicked(item:Product)
    }
}