package com.riging_test.template.src.my_favorite.fragment.fragment1

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.main._1home.HomeFragmentInterface
import com.riging_test.template.src.main._1home.models.HomePostListDataClass
import com.riging_test.template.src.my_favorite.fragment.fragment1.models.MyFavoriteListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyFavoriteService(val view:MyFavoriteFragment1View) {


    fun TryGetFavoriteList(jwt:String){
        val favoriteListRetrofitInterface= ApplicationClass.sRetrofit.create(
            MyFavoriteInterface::class.java)
        favoriteListRetrofitInterface.getFavoriteList(jwt).enqueue(object:
            Callback<MyFavoriteListResponse> {
            override fun onResponse(
                call: Call<MyFavoriteListResponse>,
                response: Response<MyFavoriteListResponse>
            ) {
                if(response.body()!=null){
                    view.getFavoriteListSuccess(response.body() as MyFavoriteListResponse)
                }


            }

            override fun onFailure(call: Call<MyFavoriteListResponse>, t: Throwable) {
                view.getFavoriteListFailure(t.message?:"통신오류")

            }

        })

    }
}