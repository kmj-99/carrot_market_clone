package com.riging_test.template.src.product_deal

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MenuInflater
import android.view.WindowManager
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityProductBinding
import com.riging_test.template.databinding.ActivityProductDealBinding
import com.riging_test.template.src.AndroidBug5497Workaround
import com.riging_test.template.src.product_deal.Rv.ProductDealAdapter
import com.riging_test.template.src.product_deal.Rv.ProductDealDataClass
import com.riging_test.template.src.product_deal.Rv.ViewType
import com.riging_test.template.src.product_deal_time_setting.TimeSettingActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class ProductDealChatActivity: BaseActivity<ActivityProductDealBinding>(ActivityProductDealBinding::inflate) {
    private var Test_Chat=ViewType().CLIENT_JOIN

    private var Test_List=ArrayList<ProductDealDataClass>()

    override fun onStart() {
        super.onStart()
        window.statusBarColor = Color.TRANSPARENT


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //AndroidBug5497Workaround().assistActivity(this)


        var calender=Calendar.getInstance()
        var Am_Pm=""
        if(calender.get(Calendar.AM_PM)==Calendar.AM){
            Am_Pm="오전"
        }else{
            Am_Pm="오후"
        }

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

        var Rv=binding.productDealRv
        var Rv_Adpater=ProductDealAdapter(this,Test_List)
        Rv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        Rv.adapter=Rv_Adpater


        binding.productDealChatImageSend.setOnClickListener {
            var content=binding.productDealChatEdit.text.toString()
            if(Test_Chat==ViewType().CLIENT_JOIN) {

                Test_List.add(ProductDealDataClass(null, CurrentData(), null, ViewType().CLIENT_JOIN))
                Test_Chat=ViewType().RIGHT_CHAT
            }


            when(Test_Chat){
                ViewType().RIGHT_CHAT -> {
                    binding.productDealChatEdit.text.clear()
                    Test_List.add(ProductDealDataClass(content,Am_Pm+" "+CurrentTime(),null,ViewType().RIGHT_CHAT))
                    Test_Chat=ViewType().LEFT_CHAT
                }

                ViewType().LEFT_CHAT -> {
                    binding.productDealChatEdit.text.clear()
                    Test_List.add(ProductDealDataClass(content,Am_Pm+" "+CurrentTime(),R.drawable.test_image,ViewType().LEFT_CHAT))
                    Test_Chat=ViewType().RIGHT_CHAT

                }


            }
            Rv_Adpater.notifyDataSetChanged()



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