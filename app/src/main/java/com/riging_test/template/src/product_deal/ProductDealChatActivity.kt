package com.riging_test.template.src.product_deal

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MenuInflater
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityProductDealBinding
import com.riging_test.template.src.product_deal.Rv.ProductDealAdapter
import com.riging_test.template.src.product_deal.Rv.ProductDealDataClass
import com.riging_test.template.src.product_deal.Rv.ViewType
import com.riging_test.template.src.product_deal.models.request.ChatAddRequest
import com.riging_test.template.src.product_deal.models.request.ChatSendRequest
import com.riging_test.template.src.product_deal.models.response.ChatAddResponse
import com.riging_test.template.src.product_deal.models.response.ChatSendResponse
import com.riging_test.template.src.product_deal_time_setting.TimeSettingActivity
import kotlinx.android.synthetic.main.rv_activity_product_deal_left_chat.view.*
import kotlinx.android.synthetic.main.rv_activity_product_deal_right_chat.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class ProductDealChatActivity: BaseActivity<ActivityProductDealBinding>(ActivityProductDealBinding::inflate),ChatView {
    private var Test_Chat=ViewType().CLIENT_JOIN

    private var Test_List=ArrayList<ProductDealDataClass>()

    private val jwt= sSharedPreferences.getString("jwt","1")!!
    private val userId= sSharedPreferences.getInt("userId",1)


    private var ChatRoomId=0
    private var Count=true
    private var ChatContent="d"

    override fun onStart() {
        super.onStart()
        window.statusBarColor = Color.TRANSPARENT


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //AndroidBug5497Workaround().assistActivity(this)

        val NickName=intent.getStringExtra("NickName")
        val Price=intent.getStringExtra("Price")
        val Title=intent.getStringExtra("Title")
        val postId=intent.getIntExtra("PostId",1)

        binding.productDealTextNickname.text=NickName
        binding.productDealTextPrice.text=Price
        binding.productDealTextTitle.text=Title



        var calender=Calendar.getInstance()
        var Am_Pm=""
        if(calender.get(Calendar.AM_PM)==Calendar.AM){
            Am_Pm="오전"
        }else{
            Am_Pm="오후"
        }
        var multOption= MultiTransformation(CenterCrop(), RoundedCorners(15))
        Glide.with(this).load(R.drawable.test_image).apply(RequestOptions.bitmapTransform(multOption))
            .into(binding.productDealImageProduct)

        var view=this
        binding.productDealChatEdit.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("Edit_Text",count.toString())
                if(count<1){
                    Glide.with(view).load(R.drawable.select_no_send).into(binding.productDealChatImageSend)
                    //binding.productDealChatImageSend.setBackgroundResource(R.drawable.select_no_send)
                }else{
                    Glide.with(view).load(R.drawable.select_send_icon).into(binding.productDealChatImageSend)

                    //binding.productDealChatImageSend.setBackgroundResource(R.drawable.select_send_icon)

                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })


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

                ChatService(this).TryPostAdd(ChatAddRequest(buyerUserId = userId,postId = postId),22)
                Test_List.add(ProductDealDataClass(null, CurrentData(), null, ViewType().CLIENT_JOIN))
                Test_Chat=ViewType().RIGHT_CHAT
            }

            when(Test_Chat){
                ViewType().RIGHT_CHAT -> {
                    ChatContent=binding.productDealChatEdit.text.toString()
                    binding.productDealChatEdit.text.clear()
                    Test_List.add(ProductDealDataClass(content,Am_Pm+" "+CurrentTime(),null,ViewType().RIGHT_CHAT))
                    if(!Count) {
                        ChatService(this).TryPostSend(
                            jwt,
                            ChatRoomId,
                            ChatSendRequest(content = ChatContent)
                        )
                    }
                    Test_Chat=ViewType().LEFT_CHAT
                }


                ViewType().LEFT_CHAT -> {
                    ChatContent=binding.productDealChatEdit.text.toString()
                    binding.productDealChatEdit.text.clear()
                    Test_List.add(ProductDealDataClass(content,Am_Pm+" "+CurrentTime(),R.drawable.test_image,ViewType().LEFT_CHAT))
                    ChatService(this).TryPostSend(jwt,ChatRoomId, ChatSendRequest(content=ChatContent))

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

    override fun postAddSuccess(response: ChatAddResponse) {
        if(response.code==1000){

            ChatRoomId=response.result.chattingRoomId
            if(Count){
                ChatService(this).TryPostSend(jwt,ChatRoomId, ChatSendRequest(content="안녕하세요"))
                Count=false
            }
            showCustomToast("채팅방이 추가되었습니다.")
        }else{
            showCustomToast(response.message+"postAddSuccess")
        }

    }

    override fun postAddFailure(message: String) {
        showCustomToast(message+"postAddFailure")
    }

    override fun postSendSuccess(response: ChatSendResponse) {
        if(response.code==1000){
            showCustomToast("전송되었습니다.")
        }else{
            showCustomToast(response.message+"postSendSuccess")
        }
    }

    override fun postSendFailure(message: String) {
        showCustomToast(message+"postSendFailure")
    }


}