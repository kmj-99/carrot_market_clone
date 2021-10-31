package com.riging_test.template.src.sign_up.second

import com.riging_test.template.src.sign_up.second.models.LocationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SignupSecondLocationInterace {


    @GET("map-reversegeocode/v2/gc")
    fun getLocation(@Header("X-NCP-APIGW-API-KEY-ID")Client_Id:String,
                  @Header("X-NCP-APIGW-API-KEY")Client_Pw:String,
                  @Query("request")request:String,
                  @Query("coords")coords:String,
                  @Query("sourcecrs")sourcecrs:String,
                  @Query("output")output:String,
                  @Query("orders")orders:String
    ): Call<LocationResponse>
}