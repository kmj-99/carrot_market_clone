package com.riging_test.template.src.sign_up.second

import com.riging_test.template.src.sign_up.second.models.ArroundLocationResponse
import com.riging_test.template.src.sign_up.second.models.LocationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SignupSecondArroundLocationInterface {


    @GET("address")
    fun getAroundLocation(@Header("X-ACCESS-TOKEN")Jwt:String,
                         @Query("search")search:String,
                          @Query("townId")townId:Int
    ): Call<ArroundLocationResponse>
}