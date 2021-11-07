package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.SalesIngResonse
import com.riging_test.template.src.posting.PostingInterface
import com.riging_test.template.src.posting.models.PostingRequest
import com.riging_test.template.src.posting.models.PostingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryFragment1Service(val view:HistoryFragment1View) {

    fun TryGetSalesIng(UserId: Int){
        val salesIngRetrofitInterface= ApplicationClass.sRetrofit.create(
            HistoryFragment1Interface::class.java)
        salesIngRetrofitInterface.getSalesIng(UserId).enqueue(object:
            Callback<SalesIngResonse> {
            override fun onResponse(
                call: Call<SalesIngResonse>,
                response: Response<SalesIngResonse>
            ) {
                if(response.body()!=null){
                    view.TryGetSalesIngSuccess(response.body() as SalesIngResonse)
                }

            }

            override fun onFailure(call: Call<SalesIngResonse>, t: Throwable) {
                view.TryGetSalesIngFailue(t.message?:"통신오류")

            }

        })

    }
}