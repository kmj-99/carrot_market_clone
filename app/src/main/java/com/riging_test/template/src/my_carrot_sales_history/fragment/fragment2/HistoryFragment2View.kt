package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2

import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.SalesIngResonse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2.models.SalesFinishResponse

interface HistoryFragment2View {

    fun TryGetSalesFinishSuccess(response:SalesFinishResponse)
    fun TryGetSalesFinishFailue(message:String)

}