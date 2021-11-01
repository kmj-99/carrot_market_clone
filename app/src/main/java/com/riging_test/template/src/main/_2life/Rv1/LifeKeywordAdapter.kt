package com.riging_test.template.src.main._2life.Rv1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_fragment_life1.view.*

class LifeKeywordAdapter(val context: Context,var ItemList:ArrayList<LifeKeywordDataClass>):RecyclerView.Adapter<LifeKeywordAdapter.LifeKeywordViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifeKeywordViewHolder {
        return LifeKeywordViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_fragment_life1,parent,false))
    }


    // 재활용되는 뷰가 호출하여 실행되는 메소드이며 뷰홀더를 전달하고 position의 데이터를 결합시킵니다.
    override fun onBindViewHolder(holder: LifeKeywordViewHolder, position: Int) {
        holder.bind(context,ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }


    //리사이클러뷰 데이터 꼬임을 방지하기 위한 메소드
    //뷰의 타입을 return
    override fun getItemViewType(position: Int): Int {
        return position
    }



    inner class LifeKeywordViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_life_image_share
        private var Keyword=ItemView.Rv_life_text_keyword

        fun bind(context:Context,Item:LifeKeywordDataClass){
            if(Item.Image!=null){
                Glide.with(context).load(Item.Image).into(Image)
                Image.visibility=View.VISIBLE
                Keyword.visibility=View.INVISIBLE
            }else if(Item.Keyword!=null){
                Keyword.text=Item.Keyword
            }


        }


    }
}