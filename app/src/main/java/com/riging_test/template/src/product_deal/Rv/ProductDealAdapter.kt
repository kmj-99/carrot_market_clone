package com.riging_test.template.src.product_deal.Rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_activity_product_deal_join.view.*
import kotlinx.android.synthetic.main.rv_activity_product_deal_left_chat.view.*
import kotlinx.android.synthetic.main.rv_activity_product_deal_right_chat.view.*

class ProductDealAdapter(val context: Context,val ItemList:ArrayList<ProductDealDataClass>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        when(viewType){
            ViewType().CLIENT_JOIN ->{
                val view=LayoutInflater.from(context).inflate(R.layout.rv_activity_product_deal_join,parent,false)
                return JoinViweHolder(view)
            }
            ViewType().LEFT_CHAT -> {
                val view=LayoutInflater.from(context).inflate(R.layout.rv_activity_product_deal_left_chat,parent,false)
                return LeftChatViewHolder(view)
            }
            ViewType().RIGHT_CHAT -> {
                val view=LayoutInflater.from(context).inflate(R.layout.rv_activity_product_deal_right_chat,parent,false)
                return RightChatViewHolder(view)
            }

            else -> {
                val view=LayoutInflater.from(context).inflate(R.layout.rv_activity_product_deal_join,parent,false)
                return JoinViweHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is JoinViweHolder ){
            holder.bind(context,ItemList[position])
        }else if(holder is LeftChatViewHolder){
            holder.bind(context,ItemList[position])
        }else if(holder is RightChatViewHolder){
            holder.bind(context,ItemList[position])
        }
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(ItemList.isNotEmpty())
            ItemList[position].viewType!!
        else
            super.getItemViewType(position)
    }

    inner class JoinViweHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Time=ItemView.Rv_Product_Deal_Current_Time

        fun bind(context:Context,ItemView:ProductDealDataClass){
            Time.text=ItemView.CurrentTime
        }

    }
    inner class LeftChatViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Content=ItemView.Rv_Product_Deal_Left_Text_Content
        private var Image=ItemView.Rv_Product_Deal_Left_Image
        private var Time=ItemView.Rv_Product_Deal_Left_Text_Time

        fun bind(context:Context,Item:ProductDealDataClass){
            Glide.with(context).load(Item.Image).into(Image)
            Content.text=Item.content
            Time.text=Item.CurrentTime
        }

    }
    inner class RightChatViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Content=ItemView.Rv_Product_Deal_Right_Text_Content
        private var Image=ItemView.Rv_Product_Deal_Right_Image
        private var Time=ItemView.Rv_Product_Deal_Right_Text_Time

        fun bind(context:Context,Item:ProductDealDataClass){
            Glide.with(context).load(Item.Image).into(Image)
            Content.text=Item.content
            Time.text=Item.CurrentTime
        }



    }



}