package com.riging_test.template.src.main._4chat

import com.riging_test.template.src.main._4chat.models.ChatListResponse
import com.riging_test.template.src.main._4chat.models.LastChatResponse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.TitleImageResponse

interface ChatFragmentView {
    fun TryGetTitleImageSuccess(response:TitleImageResponse)
    fun TryGetTitleImageFailure(message:String)

    fun TryGetLastChatSuccess(response:LastChatResponse)
    fun TryGetLastChatFailure(message: String)

    fun TryGetChatListSuccess(response:ChatListResponse)
    fun TryGetChatListFailure(message:String)

}