package com.riging_test.template.src.product_deal

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.widget.PopupMenu
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityProductBinding
import com.riging_test.template.databinding.ActivityProductDealBinding
import com.riging_test.template.src.product_deal_time_setting.TimeSettingActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ProductDealChatActivity: BaseActivity<ActivityProductDealBinding>(ActivityProductDealBinding::inflate) {

    override fun onStart() {
        super.onStart()
        StatusColor()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Glide.with(this).load(R.drawable.test_image).centerCrop()
            .into(binding.productDealImageProduct)


        binding.productDealButtonListAction.setOnClickListener {
            var popupMenu = PopupMenu(this, it)
            MenuInflater(this).inflate(R.menu.popup_product_deal_list, popupMenu.menu)
            popupMenu.menu.findItem(R.id.product_deal_popup_alarm).title = "알림끄기"
            popupMenu.menu.findItem(R.id.product_deal_popup_block).title = "차단하기"
            popupMenu.menu.findItem(R.id.product_deal_popup_report).title="신고하기"
            popupMenu.menu.findItem(R.id.product_deal_popup_exit).title="채팅방 나가기"


            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.product_deal_popup_alarm -> {

                        showCustomToast("알림끄기")
                    }
                    R.id.product_deal_popup_block -> {
                        showCustomToast("차단하기")

                    }
                    R.id.product_deal_popup_report -> {
                        showCustomToast("신고하기")
                    }

                    R.id.product_deal_popup_exit -> {
                        showCustomToast("채팅방 나가기")
                    }

                }
                false
            }
            popupMenu.show()




        }

        binding.productDealButtonTimeSetting.setOnClickListener {

            startActivity(Intent(this,TimeSettingActivity::class.java))
        }
    }
    //현재 날짜 반환
    fun CurrentData():String{
        val current = LocalDateTime.now()
        val Date = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")
        val Current_Date=current.format(Date)

        return Current_Date
    }

    //현재 시간 반환
    fun CurrentTime():String{
        val current = LocalDateTime.now()
        val Time=DateTimeFormatter.ofPattern("HH시 mm분")
        val Current_Time = current.format(Time)

        return Current_Time

    }




}