package com.riging_test.template.src.sign_up.second

import com.riging_test.template.src.sign_up.second.models.ArroundLocationTownId
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SignupSecondTownIdInterface {


    @GET("address/townId")
    fun getTownId(@Query("city")city:String,
                         @Query("district")district:String,
                          @Query("townName")townName:String
    ): Call<ArroundLocationTownId>
}