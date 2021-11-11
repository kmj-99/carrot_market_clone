package com.riging_test.template.src.chat_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.src.main._1home.Rv.HomeAdapter
import kotlinx.android.synthetic.main.rv_chat_list.view.*

class ChatListAdapter(val context: Context, val ItemList:ArrayList<ChatListDataClass>):RecyclerView.Adapter<ChatListAdapter.ChatListViewHolder>() {
    private lateinit var itemClickListener: ChatListAdapter.OnItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder {
        return ChatListViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_chat_list,parent,false))
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
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

    inner class ChatListViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_Chat_List_Image
        private var Title=ItemView.Rv_Chat_List_Title
        private var Location=ItemView.Rv_Chat_List_Location


        fun bind(context:Context,Item: ChatListDataClass){
            Glide.with(context).load(Item.Image).centerCrop().into(Image)
            Title.text=Item.Title
            Location.text=Item.Location

        }
    }
}