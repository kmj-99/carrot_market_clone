package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment3

import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.SalesIngResonse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2.models.SalesFinishResponse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment3.models.SalesHideResponse

interface HistoryFragment3View {

    fun TryGetSalesHideSuccess(response: SalesHideResponse)
    fun TryGetSalesHideFailue(message:String)

}