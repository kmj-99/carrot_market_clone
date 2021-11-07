package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment3

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.SalesIngResonse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2.models.SalesFinishResponse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment3.models.SalesHideResponse
import com.riging_test.template.src.posting.PostingInterface
import com.riging_test.template.src.posting.models.PostingRequest
import com.riging_test.template.src.posting.models.PostingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryFragment3Service(val view:HistoryFragment3View) {

    fun TryGetSalesHide(UserId: Int){
        val salesHideRetrofitInterface= ApplicationClass.sRetrofit.create(
            HistoryFragment3Interface::class.java)
        salesHideRetrofitInterface.getSalesHide(UserId).enqueue(object:
            Callback<SalesHideResponse> {
            override fun onResponse(
                call: Call<SalesHideResponse>,
                response: Response<SalesHideResponse>
            ) {
                if(response.body()!=null){
                    view.TryGetSalesHideSuccess(response.body() as SalesHideResponse)
                }

            }

            override fun onFailure(call: Call<SalesHideResponse>, t: Throwable) {
                view.TryGetSalesHideFailue(t.message?:"통신오류")

            }

        })

    }
}