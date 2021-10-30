package com.riging_test.template.src.sign_up.second

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.riging_test.template.R
import kotlinx.android.synthetic.main.rv_fragment_signup_second.view.*

class SignupRvAdapter(val ItemList:ArrayList<SignupRvDataClass>) : RecyclerView.Adapter<SignupRvAdapter.SignupRvViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SignupRvViewHolder {
        return SignupRvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_fragment_signup_second,parent,false))
    }

    override fun onBindViewHolder(holder: SignupRvViewHolder, position: Int) {
        holder.bind(ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }



    inner class SignupRvViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        private var Location=ItemView.Rv_Location


        fun bind(Item:SignupRvDataClass){
            Location.text=Item.Location
        }
    }
}