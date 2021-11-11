package com.riging_test.template.src.my_favorite.fragment.fragment1

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.main._1home.HomeFragmentInterface
import com.riging_test.template.src.main._1home.models.FavoriteImageResponse
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





    fun TryGetFavoriteImage(postId:Int){
        val favoriteImageRetrofitInterface= ApplicationClass.sRetrofit.create(
            MyFavoriteImageInterface::class.java)
        favoriteImageRetrofitInterface.getFavoriteImage(postId).enqueue(object:
            Callback<FavoriteImageResponse> {
            override fun onResponse(
                call: Call<FavoriteImageResponse>,
                response: Response<FavoriteImageResponse>
            ) {
                if(response.body()!=null){
                    view.getFavoriteImageSuccess(response.body() as FavoriteImageResponse)
                }


            }

            override fun onFailure(call: Call<FavoriteImageResponse>, t: Throwable) {
                view.getFavoriteImageFailure(t.message?:"통신오류")

            }

        })

    }
}