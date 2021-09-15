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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MyListFragment : Fragment() {
     var listener: ListFragmentListener?=null
    lateinit var adapter: CatagoriesAdapter
   // var catagories=ArrayList<String>()
lateinit var catageyViewModel: PrudectViewModel
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ListFragmentListener){
            listener=context as ListFragmentListener
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
        return inflater.inflate(R.layout.fragment_my_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       catageyViewModel= ViewModelProvider(this).get(PrudectViewModel::class.java)
        var rv=view.findViewById<RecyclerView>(R.id.fragmentmainRecycleView)
        var adapter= CatagoriesAdapter(catageyViewModel.catagories)
        adapter.catagoriesLestiner= object : CatagoriesAdapter.IPersonListener {
            override fun itemViewListener(position: Int) {

                listener?.itemClicked(catageyViewModel.catagories[position])

//                if(activity is ListFragmentListener){
//                 listener=activity as ListFragmentListener
//                listener.itemClicked(catagories[position])}
//                var intent= Intent(view.context,CatagoryProducts::class.java)
//                intent.putExtra("catagoryname",catagories[position])
//                startActivity(intent)
            }

        }
        rv.adapter=adapter
        rv.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL,false)
 if(catageyViewModel.catagories.isEmpty()){

         catageyViewModel.getCatagories().observe(viewLifecycleOwner,{
            if(it.result==StoreResponse.SUCCESS){
//                it.response?.forEach {
//                    Log.d("ttt","dsds ${it.toString().capitalize() }")
//                    catageyViewModel.catagories.add(it.toString().capitalize())
//                    adapter.notifyDataSetChanged()
//                }
                catageyViewModel.catagories.addAll(it.response!!)
                adapter.notifyDataSetChanged()

            }else{
                Toast.makeText(view.context,"Error!", Toast.LENGTH_LONG).show()
            }
        })}else{
        adapter.notifyDataSetChanged()
        }




    }
    public interface ListFragmentListener{
        public fun itemClicked(item:String)
    }



}