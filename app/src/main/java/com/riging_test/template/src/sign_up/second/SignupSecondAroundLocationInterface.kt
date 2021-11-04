package com.riging_test.template.src.sign_up.second

import com.riging_test.template.src.sign_up.second.models.AroundLocationResponse
import com.riging_test.template.src.sign_up.second.models.ArroundLocationTownId
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SignupSecondAroundLocationInterface {


    @GET("address/location")
    fun getAroundLocation(@Query("townId")townId:Int
    ): Call<AroundLocationResponse>
}