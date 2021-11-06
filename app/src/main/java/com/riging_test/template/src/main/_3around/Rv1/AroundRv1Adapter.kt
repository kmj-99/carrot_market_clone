package com.riging_test.template.src.main._3around.Rv1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_fragment_around1.view.*

class AroundRv1Adapter(var ItemList:ArrayList<AroundRv1Dataclass>):RecyclerView.Adapter<AroundRv1Adapter.AroundRv1ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AroundRv1ViewHolder {
            return AroundRv1ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_fragment_around1,parent,false))
    }

    override fun onBindViewHolder(holder: AroundRv1ViewHolder, position: Int) {
        holder.bind(ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }


    inner class AroundRv1ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
        private var Category=ItemView.Rv_Around_Text_Category1

        fun bind(Item:AroundRv1Dataclass){
            Category.text=Item.Category

        }

    }
}