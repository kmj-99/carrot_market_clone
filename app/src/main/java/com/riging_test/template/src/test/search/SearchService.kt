package com.riging_test.template.src.test.search

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.test.search.models.SearchImageResponse
import com.riging_test.template.src.test.search.models.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchService(val view:SearchFragmentView) {

    fun TryGetSearch(Client_Id:String,Client_Pw:String,Query:String,Display:Int,Start:Int){
        val searchRetrofitInterface=ApplicationClass.sRetrofit.create(SearchInterface::class.java)
        searchRetrofitInterface.getSearch(Client_Id,Client_Pw,Query,Display,Start).enqueue(object:Callback<SearchResponse>{
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                view.TryGetSearchSuccess(response.body() as SearchResponse)
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                view.TryGetSearchFaliue(t.message?:"통신오류")
            }

        })

    }

    fun TryGetImageSearch(Client_Id:String,Client_Pw:String,Query:String,Display:Int,Start:Int){
        val searchImageRetrofitInterface=ApplicationClass.sRetrofit.create(SearchImageInterface::class.java)
        searchImageRetrofitInterface.getSearchImage(Client_Id,Client_Pw,Query,Display,Start).enqueue(object:Callback<SearchImageResponse>{
            override fun onResponse(
                call: Call<SearchImageResponse>,
                response: Response<SearchImageResponse>
            ) {
                view.TryGetSearchImageSuccess(response.body() as SearchImageResponse)
            }

            override fun onFailure(call: Call<SearchImageResponse>, t: Throwable) {
                view.TryGetSearchImageFaliue(t.message?:"통신오류")
            }

        })


    }
}