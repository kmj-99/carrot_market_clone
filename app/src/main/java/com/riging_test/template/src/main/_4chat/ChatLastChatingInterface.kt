package com.riging_test.template.src.main._4chat

import com.riging_test.template.src.main._4chat.models.LastChatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChatLastChatingInterface {

    @GET("chatting/last-chat")
    fun getLastChat(@Query("chattingRoomId")chattingRoomId:Int
    ):Call<LastChatResponse>
}