package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1

import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.SalesIngResonse

interface HistoryFragment1View {

    fun TryGetSalesIngSuccess(response:SalesIngResonse)
    fun TryGetSalesIngFailue(message:String)

}