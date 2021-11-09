package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.RvActivitySalesHostoryFragment1Binding
import com.riging_test.template.src.deal_finish.DealFinish
import com.riging_test.template.src.main._1home.Rv.HomeAdapter
import com.riging_test.template.src.my_carrot_sales_history.Rv.SalesHistoryAdapter
import com.riging_test.template.src.my_carrot_sales_history.Rv.SalesHistoryDataClass
import com.riging_test.template.src.my_carrot_sales_history.Rv.SalesHistoryViewType
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.SalesIngResonse
import com.riging_test.template.src.product.ProductActivity

class HistoryFragment1: BaseFragment<RvActivitySalesHostoryFragment1Binding>
    (RvActivitySalesHostoryFragment1Binding::bind, R.layout.rv_activity_sales_hostory_fragment1),HistoryFragment1View {


    private var RvList=ArrayList<SalesHistoryDataClass>()

    private lateinit var Rv:RecyclerView
    private lateinit var Rv_Adapter:SalesHistoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        HistoryFragment1Service(this).TryGetSalesIng(32)
        Rv=binding.salesHistoryFragment1Rv





    }

    override fun TryGetSalesIngSuccess(response: SalesIngResonse) {
        if(response.code==1000){
            showCustomToast(response.result[0].status)
            for(i in 0 until response.result.size){
                RvList.add(SalesHistoryDataClass(R.drawable.test_image,response.result[i].title,"소흘읍","2초전","${response.result[i].cost}",
                    3,2,SalesHistoryViewType().RV1))
            }

            Rv_Adapter=SalesHistoryAdapter(requireContext(),RvList)
            Rv.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            Rv.adapter=Rv_Adapter

            Rv_Adapter.setItemClickListener(object : SalesHistoryAdapter.OnItemClickListener {
                override fun onClick(v: View, position: Int) {

                    startActivity(Intent(requireContext(),DealFinish::class.java))

                }

            })






        }else{
            showCustomToast("데이터를 가져오지 못했음")
        }

    }

    override fun TryGetSalesIngFailue(message: String) {
        showCustomToast(message)

    }
}