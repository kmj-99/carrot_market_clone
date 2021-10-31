package com.riging_test.template.src.main._4chat

import android.os.Bundle
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentChatBinding
import com.riging_test.template.databinding.FragmentHomeBinding

class ChatFragment : BaseFragment<FragmentChatBinding>(FragmentChatBinding::bind, R.layout.fragment_chat){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}