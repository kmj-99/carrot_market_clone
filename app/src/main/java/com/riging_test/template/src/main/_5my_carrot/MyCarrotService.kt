package com.riging_test.template.src.main._5my_carrot

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.main._1home.HomeFragmentInterface
import com.riging_test.template.src.main._1home.models.HomePostListDataClass
import com.riging_test.template.src.main._5my_carrot.model.UserInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyCarrotService (val view:MyCarrotFragmentView){

    fun TryGetUserInfo(userId:Int){
        val getUserInfoRetrofitInterface= ApplicationClass.sRetrofit.create(
            MyCarrotInterface::class.java)
        getUserInfoRetrofitInterface.getUserInfo(userId).enqueue(object:
            Callback<UserInfoResponse> {
            override fun onResponse(
                call: Call<UserInfoResponse>,
                response: Response<UserInfoResponse>
            ) {
                if(response.body()!=null){
                    view.getUserInfoSuccess(response.body() as UserInfoResponse)
                }


            }

            override fun onFailure(call: Call<UserInfoResponse>, t: Throwable) {
                view.getUserInfoFailure(t.message?:"통신오류")

            }

        })

    }
}