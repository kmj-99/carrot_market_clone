package com.riging_test.template.src.main._3around.Rv4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_fragment_around4.view.*

class AroundRv4Adapter(val context: Context, val ItemList:ArrayList<AroundRv4DataClass>):RecyclerView.Adapter<AroundRv4Adapter.AroundRv4ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AroundRv4ViewHolder {
        return AroundRv4ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_fragment_around4,parent,false))
    }

    override fun onBindViewHolder(holder: AroundRv4ViewHolder, position: Int) {
        holder.bind(context,ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }

    inner class AroundRv4ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Image1=ItemView.Around_Rv4_ProductImage1
        private var Image2=ItemView.Around_Rv4_ProductImage2
        private var Name=ItemView.Around_Rv4_Text_Name
        private var Content=ItemView.Around_Rv4_Text_Content
        private var CommentNumber=ItemView.Around_Rv4_Text_Comment_Number
        private var CustomNumber=ItemView.Around_Rv4_Text_Custom_Number
        private var OtherComment=ItemView.Around_Rv4_Text_Other_Comment


        fun bind(context:Context,Item:AroundRv4DataClass){
            Glide.with(context).load(Item.ProductImage1).into(Image1)
            Glide.with(context).load(Item.ProductImage2).into(Image2)

            Name.text=Item.Name
            Content.text=Item.Content
            CommentNumber.text=Item.CommentNumber
            CustomNumber.text=Item.Custom_Number
            OtherComment.text=Item.OtherContent
        }
    }
}