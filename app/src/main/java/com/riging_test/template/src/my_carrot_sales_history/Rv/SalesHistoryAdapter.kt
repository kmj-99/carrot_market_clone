package com.riging_test.template.src.my_carrot_sales_history.Rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.src.main._1home.Rv.HomeAdapter
import kotlinx.android.synthetic.main.rv_activity_product_deal_join.view.*
import kotlinx.android.synthetic.main.rv_activity_product_deal_left_chat.view.*
import kotlinx.android.synthetic.main.rv_activity_product_deal_right_chat.view.*
import kotlinx.android.synthetic.main.rv_activity_sales_hository.view.*
import kotlinx.android.synthetic.main.rv_activity_sales_hository2.view.*
import kotlinx.android.synthetic.main.rv_activity_sales_hostory_fragment1.view.*

class SalesHistoryAdapter(val context: Context, val ItemList:ArrayList<SalesHistoryDataClass>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: SalesHistoryAdapter.OnItemClickListener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        when(viewType){
            SalesHistoryViewType().RV1 ->{
                val view= LayoutInflater.from(context).inflate(R.layout.rv_activity_sales_hository,parent,false)
                return Rv1ViewHolder(view)
            }
            SalesHistoryViewType().RV2 -> {
                val view= LayoutInflater.from(context).inflate(R.layout.rv_activity_sales_hository2,parent,false)
                return Rv2ViewHolder(view)
            }

            else -> {
                val view= LayoutInflater.from(context).inflate(R.layout.rv_activity_sales_hository2,parent,false)
                return Rv1ViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is Rv1ViewHolder ){
            holder.bind(context,ItemList[position])
            holder.itemView.sales_history_deal_finish.setOnClickListener {

                itemClickListener.onClick(it,position)

            }
        }else if(holder is Rv2ViewHolder){
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


    inner class Rv1ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_Sales_History_Image
        private var Title=ItemView.Rv_Sales_History_Name
        private var Location=ItemView.Rv_Sales_History_Location
        private var Time=ItemView.Rv_Sales_History_Time
        private var Price=ItemView.Rv_Sales_History_Price
        private var ChatNumber=ItemView.Rv_Sales_History_ChatNumber
        private var HeartNumber=ItemView.Rv_Sales_History_HeartNumber

        fun bind(context: Context,Item:SalesHistoryDataClass){
            Glide.with(context).load(Item.Image).into(Image)
            Title.text=Item.Title
            Location.text=Item.Location
            Time.text=Item.Time
            Price.text=Item.Price
            ChatNumber.text=Item.ChatNumber.toString()
            HeartNumber.text=Item.HeartNumber.toString()

        }



    }
    inner class Rv2ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_Sales_History_Image2
        private var Title=ItemView.Rv_Sales_History_Name2
        private var Location=ItemView.Rv_Sales_History_Location2
        private var Time=ItemView.Rv_Sales_History_Time2
        private var Price=ItemView.Rv_Sales_History_Price2
        private var ChatNumber=ItemView.Rv_Sales_History_ChatNumber2
        private var HeartNumber=ItemView.Rv_Sales_History_HeartNumber2


        fun bind(context: Context,Item:SalesHistoryDataClass){
            Glide.with(context).load(Item.Image).into(Image)
            Title.text=Item.Title
            Location.text=Item.Location
            Time.text=Item.Time
            Price.text=Item.Price
            ChatNumber.text=Item.ChatNumber.toString()
            HeartNumber.text=Item.HeartNumber.toString()

        }

    }

    interface OnItemClickListener {
        fun onClick(v: View, position:Int)
    }

    fun setItemClickListener(onItemClickListener:OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

}

