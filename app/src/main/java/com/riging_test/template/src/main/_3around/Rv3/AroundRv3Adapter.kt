package com.riging_test.template.src.main._3around.Rv3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_fragment_around3.view.*

class AroundRv3Adapter(val context: Context, val ItemList:ArrayList<AroundRv3DataClass>):
    RecyclerView.Adapter<AroundRv3Adapter.AroundRv3ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AroundRv3ViewHolder {
        return AroundRv3ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_fragment_around3,parent,false))
    }

    override fun onBindViewHolder(holder: AroundRv3ViewHolder, position: Int) {
        holder.bind(context,ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }


    inner class AroundRv3ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Product_Image=ItemView.Around_Rv3_Image
        private var Food_Name=ItemView.Around_Rv3_Text_FoodName
        private var Current_Location=ItemView.Around_Rv3_Text_Location
        private var Coupon=ItemView.Around_Rv3_Coupon_Name
        private var Profile_Image1=ItemView.Around_Rv3_Image_Profile1
        private var Profile_Image2=ItemView.Around_Rv3_Image_Profile2
        private var Profile_Image3=ItemView.Around_Rv3_Image_Profile3
        private var Receivers=ItemView.Around_Rv3_Text_Receivers
        private var Content=ItemView.Around_Rv3_Text_Content

        fun bind(context:Context,Item:AroundRv3DataClass){
            Glide.with(context).load(Item.ProductImage).override(1000,1000).centerCrop().load(Product_Image)
            Food_Name.text=Item.FoodName
            Current_Location.text=Item.Location
            Coupon.text=Item.Coupon
            Glide.with(context).load(Item.ProfileImage1).centerCrop().into(Profile_Image1)
            Glide.with(context).load(Item.ProfileImage2).centerCrop().into(Profile_Image2)
            Glide.with(context).load(Item.ProfileImage3).centerCrop().into(Profile_Image3)

            Receivers.text=Item.Receivers
            Content.text=Item.Coupon


        }

    }
}