package com.riging_test.template.src.product.rv

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_activity_product.view.*

class ProductRvAdapter(val context: Context, val ItemList:ArrayList<ProductRvDataClass>):RecyclerView.Adapter<ProductRvAdapter.ProductRvViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductRvViewHolder {
        return ProductRvViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_activity_product,parent,false))
    }

    override fun onBindViewHolder(holder: ProductRvViewHolder, position: Int) {
        holder.bind(context,ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }




    inner class ProductRvViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_Product_Image
        private var Name=ItemView.Rv_Product_Name
        private var Price=ItemView.Rv_Product_Price

        fun bind(context:Context,Item:ProductRvDataClass){
            var multOption= MultiTransformation(CenterCrop(), RoundedCorners(15))

            Glide.with(context).load(Item.Image).apply(RequestOptions.bitmapTransform(multOption)).into(Image)
            Name.text=Item.Name
            Price.text=Item.Price
        }

    }
}
