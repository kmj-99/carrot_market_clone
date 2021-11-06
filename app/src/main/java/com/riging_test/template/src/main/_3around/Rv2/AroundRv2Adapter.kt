package com.riging_test.template.src.main._3around.Rv2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_activity_home_category.view.*
import kotlinx.android.synthetic.main.rv_fragment_around2.view.*

class AroundRv2Adapter(val context: Context, var ItemList:ArrayList<AroundRv2Dataclass>):
    RecyclerView.Adapter<AroundRv2Adapter.AroundRv2ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AroundRv2ViewHolder {
        return AroundRv2ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_fragment_around2,parent,false))
    }

    override fun onBindViewHolder(holder: AroundRv2ViewHolder, position: Int) {
        holder.bind(context,ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }

    inner class AroundRv2ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Icon=ItemView.Rv_Around_Category_Icon2
        private var Title=ItemView.Rv_Around_Category_Title2

        fun bind(context:Context,Item:AroundRv2Dataclass){
            Glide.with(context).load(Item.Icon).into(Icon)
            Title.text=Item.Category
        }


    }
}