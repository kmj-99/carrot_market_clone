package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.RvActivitySalesHostoryFragment2Binding
import com.riging_test.template.src.my_carrot_sales_history.Rv.SalesHistoryAdapter
import com.riging_test.template.src.my_carrot_sales_history.Rv.SalesHistoryDataClass
import com.riging_test.template.src.my_carrot_sales_history.Rv.SalesHistoryViewType
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2.models.ImageResponse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2.models.SalesFinishResponse

class HistoryFragment2: BaseFragment<RvActivitySalesHostoryFragment2Binding>(
    RvActivitySalesHostoryFragment2Binding::bind, R.layout.rv_activity_sales_hostory_fragment2),HistoryFragment2View {


    private var TitleList=ArrayList<String>()
    private var PriceList=ArrayList<Int>()
    private var ImageList=ArrayList<String>()
    private var PostIdList=ArrayList<Int>()

    private var RvList=ArrayList<SalesHistoryDataClass>()
    private var TestUrl="https://modo-phinf.pstatic.net/20170419_207/1492566661261LrFEa_PNG/mosaPDcXf5.png"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        HistoryFragment2Service(this).TryGetSalesFinish(sSharedPreferences.getInt("userId",1))

//        for(i in 0..2){
//            RvList.add(SalesHistoryDataClass(R.drawable.test_image,"난무","소흘읍","2초전","500",
//                3,2,
//                SalesHistoryViewType().RV2))
//        }
//        binding.salesHistoryFragment2Rv.layoutManager=
//            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
//        binding.salesHistoryFragment2Rv.adapter= SalesHistoryAdapter(requireContext(),RvList)
//



    }

    override fun TryGetSalesFinishSuccess(response: SalesFinishResponse) {
        if(response.code==1000){
            showCustomToast(response.result[0].postId.toString())

            for(i in 0 until response.result.size) {
                TitleList.add(response.result[i].title)
                PostIdList.add(response.result[i].postId)
                TitleList.add(response.result[i].title)
                PriceList.add(response.result[i].cost)


            }

            for(i in 0 until response.result.size){
                HistoryFragment2Service(this).TryGetSalesFinishImage(PostIdList[i])
            }


        }else{
            showCustomToast("데이터를 받아오지 못했습니다.")
        }
    }

    override fun TryGetSalesFinishFailue(message: String) {
        showCustomToast(message)
    }

    override fun TryGetSalesFinishImageSuccess(response: ImageResponse) {
        if(response.code==1000){

            RvList.add(SalesHistoryDataClass(response.result.image, TitleList[0],"소흘읍","10초전",
                PriceList[0].toString(),1,1,SalesHistoryViewType().RV2))

            binding.salesHistoryFragment2Rv.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            binding.salesHistoryFragment2Rv.adapter=SalesHistoryAdapter(requireContext(),RvList)
        }else{
            showCustomToast(response.message+"TryGetSalesFinishImageSuccess")
        }

    }

    override fun TryGetSalesFinishImageFauiue(message: String) {
        showCustomToast(message+"TryGetSalesFinishImageFauiue")
    }


}