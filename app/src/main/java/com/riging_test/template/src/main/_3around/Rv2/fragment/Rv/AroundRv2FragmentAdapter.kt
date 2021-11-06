package com.riging_test.template.src.main._3around.Rv2.fragment.Rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_fragment_viewpager.view.*

class AroundRv2FragmentAdapter(val context: Context,val ItemList:ArrayList<AroundRv2FragmentDataClass>):
RecyclerView.Adapter<AroundRv2FragmentAdapter.AroundRv2FragmentViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AroundRv2FragmentViewHolder {
        return AroundRv2FragmentViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_fragment_viewpager,parent,false))
    }

    override fun onBindViewHolder(holder: AroundRv2FragmentViewHolder, position: Int) {
        holder.bind(context,ItemList[position])
    }

    override fun getItemCount(): Int {
            return ItemList.size
    }


    inner class AroundRv2FragmentViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_ViewPager_Image
        private var Title=ItemView.Rv_ViewPager_Text_Tile
        private var Content=ItemView.Rv_ViewPager_Text_Content
        private var Name=ItemView.Rv_ViewPager_Text_Name
        private var Current_Location=ItemView.Rv_ViewPager_Text_Location

        fun bind(context:Context,Item:AroundRv2FragmentDataClass){
            Glide.with(context).load(Item.Image).into(Image)
            Title.text=Item.Title
            Content.text=Item.Content
            Name.text=Item.Name
            Current_Location.text=Item.Locatoin
        }

    }
}
