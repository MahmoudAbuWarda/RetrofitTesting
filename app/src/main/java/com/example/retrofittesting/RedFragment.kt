package com.example.retrofittesting

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RedFragment : Fragment() {

    lateinit var adapter: CatagoryItemsAdapter
    lateinit var catageyViewModel: PrudectViewModel
    var product=ArrayList<Product>()

    var listener: mensFragmentListener?=null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MyListFragment.ListFragmentListener){
            listener=context as mensFragmentListener
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



        catageyViewModel.getCatagory("men's clothing").observe(viewLifecycleOwner,{
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


    }
    public interface mensFragmentListener{
        public fun itemClicked(item:Product)
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        menu.clear()
//        inflater.inflate(R.menu.menu_search,menu)
//        var items=menu.findItem(R.id.action_search)
//        var searchView= SearchView((context as MainActivity).supportActionBar!!.themedContext)
//        items.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW or MenuItem.SHOW_AS_ACTION_IF_ROOM)
//        items.setActionView(searchView)
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//               return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                Toast.makeText(context,newText,Toast.LENGTH_LONG).show()
//                return true
//            }
//
//        })
//
//    }

}