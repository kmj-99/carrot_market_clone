package com.riging_test.template.src.main._4chat

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentChatBinding
import com.riging_test.template.databinding.FragmentHomeBinding
import com.riging_test.template.src.main._4chat.Rv.ChatListAdapter
import com.riging_test.template.src.main._4chat.Rv.ChatListDataClass

class ChatFragment : BaseFragment<FragmentChatBinding>(FragmentChatBinding::bind, R.layout.fragment_chat){
    private var TestList=ArrayList<ChatListDataClass>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for(i in 0 .. 1){
            TestList.add(ChatListDataClass(R.drawable.test_image,R.drawable.carrot_image,"전복비빔밥",
                                            "옥정동","11월 3일","구매해보시는 건 어떠세요?"))
        }

        binding.chatRv.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.chatRv.adapter=ChatListAdapter(requireContext(),TestList)


    }
}