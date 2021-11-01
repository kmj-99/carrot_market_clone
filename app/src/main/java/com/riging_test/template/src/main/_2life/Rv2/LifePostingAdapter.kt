package com.riging_test.template.src.main._2life.Rv2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleRegistryOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_fragment_life2.view.*

class LifePostingAdapter(val context: Context, val ItemList:ArrayList<LifePostingDataClass> ):RecyclerView.Adapter<LifePostingAdapter.LifePostingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifePostingViewHolder {
        return LifePostingViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_fragment_life2,parent,false))
    }

    override fun onBindViewHolder(holder: LifePostingViewHolder, position: Int) {
        holder.bind(context,ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }




    inner class LifePostingViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Category=ItemView.Rv_life_Text_category
        private var Title=ItemView.Rv_life_Text_Title
        private var Image=ItemView.Rv_life_Image
        private var Nickname=ItemView.Rv_life_nickname
        private var Location=ItemView.Rv_life_location
        private var Time=ItemView.Rv_life_time

        fun bind(context:Context,Item:LifePostingDataClass){
            Category.text=Item.Category
            Title.text=Item.Title
            Glide.with(context).load(Item.TestImage).into(Image)
            Nickname.text=Item.Nickname
            Location.text=Item.Location
            Time.text=Item.Time.toString()+"분전"

        }

    }
}