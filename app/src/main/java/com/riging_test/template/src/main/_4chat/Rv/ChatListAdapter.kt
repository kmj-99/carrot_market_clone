package com.riging_test.template.src.main._4chat.Rv

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_fragment_chat.view.*
import kotlinx.android.synthetic.main.rv_fragment_life2.view.*
import java.util.concurrent.atomic.AtomicBoolean

class ChatListAdapter(val context: Context,val ItemList:ArrayList<ChatListDataClass>):RecyclerView.Adapter<ChatListAdapter.ChatListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder {
        return ChatListViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_fragment_chat,parent,false))
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }



    inner class ChatListViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var User_Image=ItemView.Rv_Chat_Image_User
        private var Product_Image=ItemView.Rv_Chat_Image_Product
        private var NickName=ItemView.Rv_life_nickname
        private var Content=ItemView.Rv_Chat_Text_Content
        private var Current_Location=ItemView.Rv_Chat_Text_Location
        private var Date=ItemView.Rv_Chat_Text_Date


        fun bind(context:Context,Item:ChatListDataClass){
            Glide.with(context).load(Item.UserImage).into(User_Image)
            Glide.with(context).load(Item.ProductImage).centerCrop().into(Product_Image)

            NickName.text=Item.NickName
            Content.text=Item.Content
            Current_Location.text=Item.Location
            Date.text=Item.Date



        }


    }
}