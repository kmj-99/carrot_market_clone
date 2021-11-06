package com.riging_test.template.src.my_profile.Rv

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_activity_my_profile.view.*
import kotlinx.android.synthetic.main.rv_activity_my_profile.view.Rv_My_Profile_Image
import kotlinx.android.synthetic.main.rv_activity_my_profile.view.Rv_My_Profile_Text_Title
import kotlinx.android.synthetic.main.rv_activity_my_profile2.view.*

class MyProfileAdapter(val context: Context,var ItemList:ArrayList<MyProfileDataClass>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            MyProfileViewType().INFO->{
                val view=LayoutInflater.from(context).inflate(R.layout.rv_activity_my_profile,parent,false)
                return MyProfileViewHolder(view)
            }
            MyProfileViewType().INFO2->{
                val view=LayoutInflater.from(context).inflate(R.layout.rv_activity_my_profile2,parent,false)
                return MyProfile2ViewHolder(view)
            }

            else->{
                val view=LayoutInflater.from(context).inflate(R.layout.rv_activity_my_profile,parent,false)
                return MyProfileViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MyProfileViewHolder){
            holder.bind(context,ItemList[position])
        }else if(holder is MyProfile2ViewHolder){
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

    inner class MyProfileViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_My_Profile_Image
        private var Title=ItemView.Rv_My_Profile_Text_Title

        fun bind(context:Context,Item:MyProfileDataClass){
            Glide.with(context).load(Item.Image).into(Image)
            Title.text=Item.Title

        }

    }

    inner class MyProfile2ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        private var Image=ItemView.Rv_My_Profile_Image
        private var Title=ItemView.Rv_My_Profile_Text_Title
        private var SubTitle=ItemView.Rv_My_Profile_Text_Sub

        fun bind(context:Context,Item:MyProfileDataClass){
            Glide.with(context).load(Item.Image).into(Image)
            Title.text=Item.Title
            SubTitle.text=Item.SupTitle

        }

    }


}