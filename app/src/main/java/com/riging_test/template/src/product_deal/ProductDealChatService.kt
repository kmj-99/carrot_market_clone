package com.riging_test.template.src.product_deal

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.main._1home.HomeGetPostIdInterface
import com.riging_test.template.src.main._1home.models.PostIdRresponse
import com.riging_test.template.src.product.models.request.AddRequest
import com.riging_test.template.src.product_deal.models.request.ChatAddRequest
import com.riging_test.template.src.product_deal.models.response.ChatAddResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDealChatService(val view:ProductDealChatView) {


    fun TryPostAdd(addRequest: ChatAddRequest, sellerUserId:Int){

        val postAddChatRetrofitInterface= ApplicationClass.sRetrofit.create(
            ProductDealChatAddInterface::class.java)

        postAddChatRetrofitInterface.postAddChat(addRequest,sellerUserId).enqueue(object:
            Callback<ChatAddResponse> {
            override fun onResponse(
                call: Call<ChatAddResponse>,
                response: Response<ChatAddResponse>
            ) {
                if(response.body()!=null){
                    view.postAddSuccess(response.body() as ChatAddResponse)
                }

            }

            override fun onFailure(call: Call<ChatAddResponse>, t: Throwable) {
                view.postAddFailure(t.message?:"통신오류")

            }

        })

    }
}