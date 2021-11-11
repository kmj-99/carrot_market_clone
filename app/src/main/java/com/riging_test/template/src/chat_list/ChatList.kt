package com.riging_test.template.src.chat_list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityChatListBinding
import com.riging_test.template.databinding.ActivityDealFinishBinding
import com.riging_test.template.src.main._1home.Rv.HomeAdapter
import com.riging_test.template.src.product.ProductActivity

class ChatList: BaseActivity<ActivityChatListBinding>(ActivityChatListBinding::inflate)  {
    private var RvList=ArrayList<ChatListDataClass>()

    override fun onStart() {
        super.onStart()
        StatusColor()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        RvList.add(ChatListDataClass(R.drawable.test_image,"전복비빔밥","소흘읍"))

        var chatListAdapter=ChatListAdapter(this,RvList)

        binding.chatListRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.chatListRv.adapter=chatListAdapter



        chatListAdapter.setItemClickListener(object : ChatListAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                showCustomToast("거래가 완료되었습니다.")
                finish()
            }

        })


    }
}