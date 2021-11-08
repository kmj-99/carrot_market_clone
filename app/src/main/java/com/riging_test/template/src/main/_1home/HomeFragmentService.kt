package com.riging_test.template.src.main._1home

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.main._1home.models.HomePostListDataClass
import com.riging_test.template.src.main._1home.models.RangeResponse
import com.riging_test.template.src.sign_up.second.SignupSecondLocationInterace
import com.riging_test.template.src.sign_up.second.models.LocationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragmentService(val view:HomeFragmentView) {


    fun TryGetPostList(jwt:String,townId:Int,range:Int){
        val postListRetrofitInterface= ApplicationClass.sRetrofit.create(
            HomeFragmentInterface::class.java)
        postListRetrofitInterface.getPostList(jwt,townId,range).enqueue(object:
            Callback<HomePostListDataClass> {
            override fun onResponse(
                call: Call<HomePostListDataClass>,
                response: Response<HomePostListDataClass>
            ) {
                if(response.body()!=null){
                    view.TryGetPostListSuccess(response.body() as HomePostListDataClass)
                }

            }

            override fun onFailure(call: Call<HomePostListDataClass>, t: Throwable) {
                view.TryGetPostFailure(t.message?:"통신오류")

            }

        })

    }


    fun TryGetRange(jwt:String){
        val getRangeRetrofitInterface= ApplicationClass.sRetrofit.create(
            HomeFragmentRangeInterface::class.java)
        getRangeRetrofitInterface.getRange(jwt).enqueue(object:
            Callback<RangeResponse> {
            override fun onResponse(
                call: Call<RangeResponse>,
                response: Response<RangeResponse>
            ) {
                if(response.body()!=null){
                    view.TryGetRangeSuccess(response.body() as RangeResponse)
                }

            }

            override fun onFailure(call: Call<RangeResponse>, t: Throwable) {
                view.TryGetRangeFailure(t.message?:"통신오류")

            }

        })

    }
}