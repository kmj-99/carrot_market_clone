package com.riging_test.template.src.life_posting_topics.Rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.riging_test.template.R
import com.riging_test.template.src.life_posting.Rv.LifePostingDataClass
import kotlinx.android.synthetic.main.rv_activity_life_posting_topics.view.*

class LifePostingTopicAdapter(var ItemList:ArrayList<LifePostingTopicDataClass>):RecyclerView.Adapter<LifePostingTopicAdapter.LifePostingTopicViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifePostingTopicViewHolder {
            return LifePostingTopicViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_activity_life_posting_topics,parent,false))
    }

    override fun onBindViewHolder(holder: LifePostingTopicViewHolder, position: Int) {
        holder.bind(ItemList[position])
    }

    override fun getItemCount(): Int {
            return ItemList.size
    }

    inner class LifePostingTopicViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Topic=ItemView.Rv_Life_Posting_Topic_Text_Topic

        fun bind(Item:LifePostingTopicDataClass){
            Topic.text=Item.Topic
        }

    }
}