package com.riging_test.template.src.my_location_setting

import com.riging_test.template.src.my_location_setting.models.ChangeResponse
import com.riging_test.template.src.product.models.request.DeleteRequest
import com.riging_test.template.src.product.models.response.DeleteResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Path

interface MyLocationSettingRangeChangeInterface {

    @PATCH("address/{townId}/{range}")
    fun patchRange(@Header("X-ACCESS-TOKEN")Jwt:String,
                   @Path("townId") townId:Int,
                   @Path("range")range:Int
    ):Call<ChangeResponse>



}