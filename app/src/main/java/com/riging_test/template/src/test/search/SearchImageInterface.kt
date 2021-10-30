package com.riging_test.template.src.test.search

import com.riging_test.template.src.test.search.models.SearchImageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SearchImageInterface {

    @GET("v1/search/image")
    fun getSearchImage(@Header("X-Naver-Client-Id")Client_Id:String,
                       @Header("X-Naver-Client-Secret")Client_Pw:String,
                       @Query("query")Query:String,
                       @Query("display")Display:Int,
                       @Query("start")Start:Int
    ):Call<SearchImageResponse>
}