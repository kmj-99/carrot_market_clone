package com.riging_test.template.src.product

import com.riging_test.template.src.product.models.request.AddRequest
import com.riging_test.template.src.product.models.response.AddResponse
import com.riging_test.template.src.sign_up.zfourth.models.PostNewSignupRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ProductFavoriteAddInterface {

    @POST("wish-list")
    fun postAdd(@Header("X-ACCESS-TOKEN")Jwt:String,
                @Body parms: AddRequest): Call<AddResponse>
}