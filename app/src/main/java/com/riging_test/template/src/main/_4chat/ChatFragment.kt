package com.riging_test.template.src.main._4chat

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentChatBinding
import com.riging_test.template.databinding.FragmentHomeBinding
import com.riging_test.template.src.main._4chat.Rv.ChatListAdapter
import com.riging_test.template.src.main._4chat.Rv.ChatListDataClass
import com.riging_test.template.src.main._4chat.models.ChatListResponse
import com.riging_test.template.src.main._4chat.models.LastChatResponse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.TitleImageResponse
import java.sql.Time

class ChatFragment : BaseFragment<FragmentChatBinding>(FragmentChatBinding::bind, R.layout.fragment_chat),ChatFragmentView{
    private var TestList=ArrayList<ChatListDataClass>()

    private var postIdList=ArrayList<Int>()
    private var chatRoomList=ArrayList<Int>()
    private var lastChat=ArrayList<String>()
    private var TimeList=ArrayList<String>()


    private var jwt=sSharedPreferences.getString("jwt","1")!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showCustomToast("chat_fragment")
        ChatService(this).TryGetChatList(jwt)


    }

    override fun TryGetChatListSuccess(response: ChatListResponse) {
        if(response.code==1000){
                for(i in 0 until response.result.size){
                    postIdList.add(response.result[i].postId)
                    chatRoomList.add(response.result[i].chattingRoomId)
                }
            ChatService(this).TryGetLastChat(chatRoomList[0])

        }else{
            showCustomToast(response.message+"TryGetChatListSuccess")
        }
    }


    override fun TryGetChatListFailure(message: String) {
        showCustomToast(message+"TryGetChatListFailure")
    }


    override fun TryGetLastChatSuccess(response: LastChatResponse) {
        if(response.code==1000){
            lastChat.add(response.result.content)
            TimeList.add(response.result.time)
            ChatService(this).TryGetTitleImage(postIdList[0])
        }else{
                showCustomToast(response.message+"TryGetLastChatSuccess")
        }
    }


    override fun TryGetLastChatFailure(message: String) {
        showCustomToast(message+"TryGetLastChatFailure")
    }



    override fun TryGetTitleImageSuccess(response: TitleImageResponse) {
        if(response.code==1000){
            TestList.add(ChatListDataClass(R.drawable.test_image
                ,response.result.image,"전복비빔밥",
                "소흘읍",TimeList[0],lastChat[0]))

            binding.chatRv.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            binding.chatRv.adapter=ChatListAdapter(requireContext(),TestList)
        }else{
            showCustomToast(response.message+"TryGetTitleImageSuccess")
        }


    }

    override fun TryGetTitleImageFailure(message: String) {
        showCustomToast(message)
    }







}