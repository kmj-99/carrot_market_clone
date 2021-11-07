package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.SalesIngResonse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2.models.SalesFinishResponse
import com.riging_test.template.src.posting.PostingInterface
import com.riging_test.template.src.posting.models.PostingRequest
import com.riging_test.template.src.posting.models.PostingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryFragment2Service(val view:HistoryFragment2View) {

    fun TryGetSalesFinish(UserId: Int){
        val salesFinishRetrofitInterface= ApplicationClass.sRetrofit.create(
            HistoryFragment2Interface::class.java)
        salesFinishRetrofitInterface.getSalesFinish(UserId).enqueue(object:
            Callback<SalesFinishResponse> {
            override fun onResponse(
                call: Call<SalesFinishResponse>,
                response: Response<SalesFinishResponse>
            ) {
                if(response.body()!=null){
                    view.TryGetSalesFinishSuccess(response.body() as SalesFinishResponse)
                }

            }

            override fun onFailure(call: Call<SalesFinishResponse>, t: Throwable) {
                view.TryGetSalesFinishFailue(t.message?:"통신오류")

            }

        })

    }
}