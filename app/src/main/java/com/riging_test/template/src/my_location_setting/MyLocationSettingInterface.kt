package com.riging_test.template.src.my_location_setting

import com.riging_test.template.src.my_location_setting.models.AroundTownResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyLocationSettingInterface {

    @GET("address/near")
    fun getAroundTown(@Query("townId")townId:Int
    ):Call<AroundTownResponse>

}