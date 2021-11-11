package com.riging_test.template.src.deal_finish

import android.content.Intent
import android.os.Bundle
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityDealFinishBinding
import com.riging_test.template.src.chat_list.ChatList
import com.riging_test.template.src.chat_list.ChatListDataClass

class DealFinish: BaseActivity<ActivityDealFinishBinding>(ActivityDealFinishBinding::inflate) {

    override fun onStart() {
        super.onStart()
        StatusColor()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding.dealFinishTextBuyerFind.setOnClickListener {
            startActivity(Intent(this, ChatList::class.java))
            finish()
        }

    }
}