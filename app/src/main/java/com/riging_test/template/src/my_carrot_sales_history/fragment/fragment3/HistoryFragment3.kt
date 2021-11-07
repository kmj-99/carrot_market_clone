package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment3

import android.os.Bundle
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.RvActivitySalesHostoryFragment3Binding
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment3.models.SalesHideResponse

class HistoryFragment3: BaseFragment<RvActivitySalesHostoryFragment3Binding>(
    RvActivitySalesHostoryFragment3Binding::bind, R.layout.rv_activity_sales_hostory_fragment3),HistoryFragment3View {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        HistoryFragment3Service(this).TryGetSalesHide(20)

    }

    override fun TryGetSalesHideSuccess(response: SalesHideResponse) {
        if(response.code==1000){
            showCustomToast(response.message)
        }else{
            showCustomToast("데이터를 받아오지 못했습니다.")
        }
    }

    override fun TryGetSalesHideFailue(message: String) {
        showCustomToast(message)
    }
}