package com.riging_test.template.src.product.view_pager

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import kotlinx.android.synthetic.main.view_pager_product.view.*

class ProductViewPagerAdapter(val context: Context, val ItemList:ArrayList<Int>):RecyclerView.Adapter<ProductViewPagerAdapter.ProductViewPagerViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=ProductViewPagerViewHolder((parent))

    override fun onBindViewHolder(holder: ProductViewPagerViewHolder, position: Int) {
        Glide.with(context).load(ItemList[position]).centerCrop().into(holder.Image)
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }

    inner class ProductViewPagerViewHolder(parent: ViewGroup):RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.view_pager_product, parent, false)){

        val Image=itemView.ViewPager_Image

    }
}