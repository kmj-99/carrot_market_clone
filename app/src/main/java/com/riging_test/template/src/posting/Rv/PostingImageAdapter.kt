package com.riging_test.template.src.posting.Rv

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.src.sign_up.second.SignupRvAdapter
import kotlinx.android.synthetic.main.rv_activity_posting.view.*

class PostingImageAdapter(val context: Context,val ItemList:ArrayList<PostingImageDataClass>):RecyclerView.Adapter<PostingImageAdapter.PostingImageViewHolder>() {
    private lateinit var itemClickListener: PostingImageAdapter.OnItemClickListener



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostingImageViewHolder {
            return PostingImageViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_activity_posting,parent,false))
    }

    override fun onBindViewHolder(holder: PostingImageViewHolder, position: Int) {
        holder.bind(context,ItemList[position])


        holder.itemView.Rv_Posting_Delete.setOnClickListener {
            itemClickListener.onClick(it,position)
        }
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }

    interface OnItemClickListener {
        fun onClick(v: View, position:Int)
    }

    fun setItemClickListener(onItemClickListener:OnItemClickListener){
        this.itemClickListener=onItemClickListener

    }


    inner class PostingImageViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_Posting_Image

        fun bind(context:Context,Item:PostingImageDataClass){

            Glide.with(context).load(Item.Image).centerCrop().into(Image)
        }



    }
}