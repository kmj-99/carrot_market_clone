package com.riging_test.template.src.home_category.Rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_activity_home_category.view.*

class HomeCategoryAdpater(val context: Context, var ItemList:ArrayList<HomeCategoryDataClass>):RecyclerView.Adapter<HomeCategoryAdpater.HomeCategoryViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        return HomeCategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_activity_home_category,parent,false))
    }

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int) {
        holder.bind(context,ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }

    inner class HomeCategoryViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Icon=ItemView.Rv_Home_Category_Icon
        private var Title=ItemView.Rv_Home_Category_Title

        fun bind(context:Context,Item:HomeCategoryDataClass){
            Glide.with(context).load(Item.Icon).into(Icon)
            Title.text=Item.Category
        }


    }
}