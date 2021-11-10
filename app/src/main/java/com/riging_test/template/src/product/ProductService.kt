package com.riging_test.template.src.product

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.product.models.request.AddRequest
import com.riging_test.template.src.product.models.request.DeleteRequest
import com.riging_test.template.src.product.models.response.AddResponse
import com.riging_test.template.src.product.models.response.DeleteResponse
import com.riging_test.template.src.product.models.response.FavoriteListResponse
import com.riging_test.template.src.product.models.response.ImageListResponse
import com.riging_test.template.src.sign_up.second.SignupSecondLocationInterace
import com.riging_test.template.src.sign_up.second.models.LocationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductService(val view:ProductActivityView){


    fun TryPostAdd(Info:AddRequest,jwt:String){
        val addRetrofitInterface= ApplicationClass.sRetrofit.create(
            ProductFavoriteAddInterface::class.java)
        addRetrofitInterface.postAdd(jwt,Info).enqueue(object:
            Callback<AddResponse> {
            override fun onResponse(
                call: Call<AddResponse>,
                response: Response<AddResponse>
            ) {
                if(response.body()!=null){
                    view.TryPostAddSuccess(response.body() as AddResponse)
                }

            }

            override fun onFailure(call: Call<AddResponse>, t: Throwable) {
                view.TryPostAddFailue(t.message?:"통신오류")

            }

        })

    }


    fun TryPatchDelete(jwt:String,deleteRequest:DeleteRequest,wishId:Int){
        val deleteRetrofitInterface= ApplicationClass.sRetrofit.create(
            ProductFavoriteDeleteInterface::class.java)
        deleteRetrofitInterface.patchDelete(jwt,deleteRequest,wishId).enqueue(object:
            Callback<DeleteResponse> {
            override fun onResponse(
                call: Call<DeleteResponse>,
                response: Response<DeleteResponse>
            ) {
                if(response.body()!=null){
                    view.TryDeleteSuccess(response.body() as DeleteResponse)
                }

            }

            override fun onFailure(call: Call<DeleteResponse>, t: Throwable) {
                view.TryDeleteFailue(t.message?:"통신오류")

            }

        })

    }



    fun TryGetFavoriteList(jwt:String){
        val listRetrofitInterface= ApplicationClass.sRetrofit.create(
            ProductFavoriteListInterface::class.java)
        listRetrofitInterface.getFavoriteList(jwt).enqueue(object:
            Callback<FavoriteListResponse> {
            override fun onResponse(
                call: Call<FavoriteListResponse>,
                response: Response<FavoriteListResponse>
            ) {
                if(response.body()!=null){
                    view.TryGetFavoriteSuccess(response.body() as FavoriteListResponse)
                }

            }

            override fun onFailure(call: Call<FavoriteListResponse>, t: Throwable) {
                view.TryGetFavoriteFailue(t.message?:"통신오류")

            }

        })

    }



    fun GetImageList(postId:Int){
        val getImageListInterface= ApplicationClass.sRetrofit.create(
            ProductImageListInterface::class.java)
        getImageListInterface.getImageList(postId).enqueue(object:
            Callback<ImageListResponse> {
            override fun onResponse(
                call: Call<ImageListResponse>,
                response: Response<ImageListResponse>
            ) {
                if(response.body()!=null){
                    view.TryGetImageListSuccess(response.body() as ImageListResponse)
                }

            }

            override fun onFailure(call: Call<ImageListResponse>, t: Throwable) {
                view.TryGetImageListFailue(t.message?:"통신오류")

            }

        })

    }


}