package com.riging_test.template.src.life_posting.Rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.src.posting.Rv.PostingImageAdapter
import kotlinx.android.synthetic.main.rv_activity_life_posting.view.*
import kotlinx.android.synthetic.main.rv_activity_posting.view.*

class LifePostingAdapter(val context: Context, var ItemList:ArrayList<LifePostingDataClass>):RecyclerView.Adapter<LifePostingAdapter.LifePostingViewHolder>() {
    private lateinit var itemClickListener: LifePostingAdapter.OnItemClickListener



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifePostingViewHolder {
        return LifePostingViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_activity_life_posting,parent,false))
    }

    override fun onBindViewHolder(holder: LifePostingViewHolder, position: Int) {
        holder.bind(context,ItemList[position])

        holder.itemView.Rv_Life_Posting_Delete.setOnClickListener {
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

    inner class LifePostingViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_Life_Posting_Image_Product


        fun bind(context:Context,Item:LifePostingDataClass){
            Glide.with(context).load(Item.Image).into(Image)

        }
    }
}