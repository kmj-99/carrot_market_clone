package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment3

import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.SalesIngResonse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2.models.SalesFinishResponse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment3.models.SalesHideResponse
import com.riging_test.template.src.sign_up.second.models.LocationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface HistoryFragment3Interface {

    @GET("post/hide/{userId}")
    fun getSalesHide(@Path("userId")userId:Int
    ): Call<SalesHideResponse>
}