package com.riging_test.template.src.my_favorite.fragment.fragment1.Rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.src.my_carrot_sales_history.Rv.SalesHistoryDataClass
import kotlinx.android.synthetic.main.rv_activity_my_favorite.view.*
import kotlinx.android.synthetic.main.rv_activity_sales_hository.view.*

class MyFavoriteRvAdapter(val context:Context,val ItemList:ArrayList<MyFavoriteRvDataClass>):
    RecyclerView.Adapter<MyFavoriteRvAdapter.MyFavoriteRvViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFavoriteRvViewHolder {
        return MyFavoriteRvViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_activity_my_favorite,parent,false))
    }

    override fun onBindViewHolder(holder: MyFavoriteRvViewHolder, position: Int) {
        holder.bind(context,ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }

    inner class MyFavoriteRvViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_My_Favorite_Image
        private var Title=ItemView.Rv_My_Favorite_Name
        private var Location=ItemView.Rv_My_Favorite_Location
        private var Time=ItemView.Rv_My_Favorite_Time
        private var Price=ItemView.Rv_My_Favorite_Price
        private var ChatNumber=ItemView.Rv_My_Favorite_ChatNumber
        private var HeartNumber=ItemView.Rv_My_Favorite_HeartNumber

        fun bind(context: Context,Item: MyFavoriteRvDataClass){
            Glide.with(context).load(Item.Image).into(Image)
            Title.text=Item.Title
            Location.text=Item.Location
            Time.text=Item.Time
            Price.text=Item.Price
            ChatNumber.text=Item.ChatNumber.toString()
            HeartNumber.text=Item.HeartNumber.toString()

        }


    }
}