package com.riging_test.template.src.main._1home.Rv

import android.content.Context
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
import com.riging_test.template.src.sign_up.second.SignupRvAdapter
import kotlinx.android.synthetic.main.rv_fragment_home.view.*

class HomeAdapter(val context: Context,val ItemList:ArrayList<HomeDataClass>): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private lateinit var itemClickListener: HomeAdapter.OnItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_fragment_home,parent,false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(context,ItemList[position])

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it,position)
        }
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }

    interface OnItemClickListener {
        fun onClick(v: View, position:Int)
    }

    fun setItemClickListener(onItemClickListener:OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }



        inner class HomeViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_Home_Image
        private var Name=ItemView.Rv_Home_Name
        private var Location=ItemView.Rv_Home_Location
        private var Time=ItemView.Rv_Home_Time
        private var Price=ItemView.Rv_Home_Price
        private var ChatNumber=ItemView.Rv_Home_ChatNumber
        private var HeartNumber=ItemView.Rv_Home_HeartNumber

        private var ChatLayout=ItemView.Rv_Home_ChatLayout
        private var HeartLayout=ItemView.Rv_Home_HeartLayout

        fun bind(context:Context,Item:HomeDataClass){
            var multOption= MultiTransformation(CenterCrop(),RoundedCorners(15))

            Glide.with(context).load(Item.ImageUrl).apply(RequestOptions.bitmapTransform(multOption)).into(Image)
            Name.text=Item.Title
            Location.text=Item.Location
            Time.text=Item.Time.toString()
            Price.text=Item.Price

            if(Item.ChatNumber==0){
                ChatLayout.visibility=View.INVISIBLE
            }else{
                ChatNumber.text=Item.ChatNumber.toString()
            }

            if(Item.HeartNumber==0){
                HeartLayout.visibility=View.INVISIBLE
            }else {
                HeartNumber.text = Item.HeartNumber.toString()
            }
        }

    }
}
