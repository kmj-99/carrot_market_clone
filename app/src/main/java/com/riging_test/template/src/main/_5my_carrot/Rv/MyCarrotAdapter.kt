package com.riging_test.template.src.main._5my_carrot.Rv

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.src.product_deal.Rv.ProductDealDataClass
import com.riging_test.template.src.product_deal.Rv.ViewType
import kotlinx.android.synthetic.main.rv_activity_my_carrot.view.*
import kotlinx.android.synthetic.main.rv_activity_product_deal_join.view.*
import kotlinx.android.synthetic.main.rv_activity_product_deal_left_chat.view.*
import kotlinx.android.synthetic.main.rv_activity_product_deal_right_chat.view.*

class MyCarrotAdapter(val context: Context,val ItemList:ArrayList<MyCarrotDataClass>):RecyclerView.Adapter<MyCarrotAdapter.MyCarrotAdapterViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCarrotAdapterViewHolder {
        return MyCarrotAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_activity_my_carrot,parent,false))
    }

    override fun onBindViewHolder(holder: MyCarrotAdapterViewHolder, position: Int) {
        holder.bind(context,ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }


    inner class MyCarrotAdapterViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_My_Carrot_Image
        private var Title=ItemView.Rv_My_Carrot_Text_Title

        fun bind(context:Context,Item:MyCarrotDataClass){
            Glide.with(context).load(Item.Image).into(Image)
            Title.text=Item.Title

        }

    }

}