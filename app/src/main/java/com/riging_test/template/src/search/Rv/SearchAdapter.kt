package com.riging_test.template.src.search.Rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_activity_search.view.*

class SearchAdapter(var ItemList:ArrayList<SearchDataClass>):RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_activity_search,parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }



    inner class SearchViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Category=ItemView.Rv_Search_Category

        fun bind(Item:SearchDataClass){
            Category.text=Item.Category
        }

    }
}