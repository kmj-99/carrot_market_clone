package com.riging_test.template.src.product

import com.riging_test.template.src.product.models.response.AddResponse
import com.riging_test.template.src.product.models.response.DeleteResponse
import com.riging_test.template.src.product.models.response.FavoriteListResponse
import com.riging_test.template.src.product.models.response.ImageListResponse

interface ProductActivityView {

    fun TryPostAddSuccess(response: AddResponse)
    fun TryPostAddFailue(message:String)


    fun TryDeleteSuccess(response: DeleteResponse)
    fun TryDeleteFailue(message:String)

    fun TryGetFavoriteSuccess(response:FavoriteListResponse)
    fun TryGetFavoriteFailue(message :String)

    fun TryGetImageListSuccess(response: ImageListResponse)
    fun TryGetImageListFailue(message:String)


}