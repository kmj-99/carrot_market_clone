package com.riging_test.template.src.main._4chat

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.main._1home.HomeGetPostIdInterface
import com.riging_test.template.src.main._1home.models.PostIdRresponse
import com.riging_test.template.src.main._4chat.models.ChatListResponse
import com.riging_test.template.src.main._4chat.models.LastChatResponse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.TitleImageResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatService(val view :ChatFragmentView) {

    fun TryGetTitleImage(postId:Int){
        val getTitleImageRetrofitInterface= ApplicationClass.sRetrofit.create(
            ChatProductIImageInterface::class.java)

        getTitleImageRetrofitInterface.getTitleImage(postId).enqueue(object:
            Callback<TitleImageResponse> {
            override fun onResponse(
                call: Call<TitleImageResponse>,
                response: Response<TitleImageResponse>
            ) {
                if(response.body()!=null){
                    view.TryGetTitleImageSuccess(response.body() as TitleImageResponse)
                }

            }

            override fun onFailure(call: Call<TitleImageResponse>, t: Throwable) {
                view.TryGetTitleImageFailure(t.message?:"통신오류")
            }

        })

    }




    fun TryGetLastChat(roomId:Int){
        val getLastChatImageRetrofitInterface= ApplicationClass.sRetrofit.create(
            ChatLastChatingInterface::class.java)

        getLastChatImageRetrofitInterface.getLastChat(roomId).enqueue(object:
            Callback<LastChatResponse> {
            override fun onResponse(
                call: Call<LastChatResponse>,
                response: Response<LastChatResponse>
            ) {
                if(response.body()!=null){
                    view.TryGetLastChatSuccess(response.body() as LastChatResponse)
                }

            }

            override fun onFailure(call: Call<LastChatResponse>, t: Throwable) {
                view.TryGetLastChatFailure(t.message?:"통신오류")
            }

        })

    }



    fun TryGetChatList(jwt:String){
        val getChatListImageRetrofitInterface= ApplicationClass.sRetrofit.create(
            ChatListInterface::class.java)
        getChatListImageRetrofitInterface.getChatList(jwt).enqueue(object:
            Callback<ChatListResponse> {
            override fun onResponse(
                call: Call<ChatListResponse>,
                response: Response<ChatListResponse>
            ) {
                if(response.body()!=null){
                    view.TryGetChatListSuccess(response.body() as ChatListResponse)
                }

            }

            override fun onFailure(call: Call<ChatListResponse>, t: Throwable) {
                view.TryGetChatListFailure(t.message?:"통신오류")
            }

        })

    }


}