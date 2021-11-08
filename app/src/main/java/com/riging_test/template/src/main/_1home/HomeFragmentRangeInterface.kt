package com.riging_test.template.src.main._1home

import com.riging_test.template.src.main._1home.models.HomePostListDataClass
import com.riging_test.template.src.main._1home.models.RangeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HomeFragmentRangeInterface {

    @GET("address/info")
    fun getRange(@Header("X-ACCESS-TOKEN")Jwt:String
    ): Call<RangeResponse>

}