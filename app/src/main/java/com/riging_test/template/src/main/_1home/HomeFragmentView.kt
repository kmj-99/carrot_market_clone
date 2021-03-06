package com.riging_test.template.src.main._1home

import com.riging_test.template.src.main._1home.models.HomePostListDataClass
import com.riging_test.template.src.main._1home.models.HomeTitleImageResponse
import com.riging_test.template.src.main._1home.models.PostIdRresponse
import com.riging_test.template.src.main._1home.models.RangeResponse

interface HomeFragmentView {

    fun TryGetPostListSuccess(response:HomePostListDataClass)
    fun TryGetPostFailure(message:String)

    fun TryGetRangeSuccess(response: RangeResponse)
    fun TryGetRangeFailure(message:String)

    fun TryGetTitleImageSuccess(response:HomeTitleImageResponse,count:Int)
    fun TryGetTitleImageFailure(message:String)

    fun TryGetPostIdSucess(response:PostIdRresponse)
    fun TryGetPostIdFailure(message :String)

}