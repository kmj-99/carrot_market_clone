package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1

import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.ProductChangeFinishResponse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.SalesIngResonse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.TitleImageResponse

interface HistoryFragment1View {

    fun TryGetSalesIngSuccess(response:SalesIngResonse)
    fun TryGetSalesIngFailue(message:String)

    fun TryGetSalesImageSuccess(response:TitleImageResponse,count:Int)
    fun TryGetSalesImageFaiue(message: String)

    fun TryPatchChangeFinishSuccess(response:ProductChangeFinishResponse)
    fun TryPatchChangeFinishFaiue(message:String)

}