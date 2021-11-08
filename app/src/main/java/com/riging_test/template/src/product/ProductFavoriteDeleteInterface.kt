package com.riging_test.template.src.product

import com.riging_test.template.src.product.models.request.AddRequest
import com.riging_test.template.src.product.models.request.DeleteRequest
import com.riging_test.template.src.product.models.response.AddResponse
import com.riging_test.template.src.product.models.response.DeleteResponse
import retrofit2.Call
import retrofit2.http.*

interface ProductFavoriteDeleteInterface {

    @PATCH("wish-list/status/{wishListId}")
    fun patchDelete(@Header("X-ACCESS-TOKEN")Jwt:String,
                    @Body parms: DeleteRequest,
                    @Path("wishListId") wishListId:Int
    ): Call<DeleteResponse>
}