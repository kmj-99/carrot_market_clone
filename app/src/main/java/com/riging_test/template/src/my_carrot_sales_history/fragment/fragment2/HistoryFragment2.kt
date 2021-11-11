package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2

import android.os.Bundle
import android.util.Log
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


    private val userId= sSharedPreferences.getInt("userId",1)

    private var TitleList=ArrayList<String>()
    private var PriceList=ArrayList<Int>()
    private var ImageList=ArrayList<String>()
    private var PostIdList=ArrayList<Int>()

    private var RvList=ArrayList<SalesHistoryDataClass>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        HistoryFragment2Service(this).TryGetSalesFinish(userId)

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
            if(response.result.size==0){
                binding.RvSalesHistoryText2.visibility=View.VISIBLE
                showCustomToast("거래완료 물품이 없습니다")
            }else {
                binding.RvSalesHistoryText2.visibility=View.INVISIBLE
                showCustomToast(response.result[0].postId.toString())

                for (i in 0 until response.result.size) {

                    TitleList.add(response.result[i].title)
                    PostIdList.add(response.result[i].postId)
                    PriceList.add(response.result[i].cost)


                }

                for (i in 0 until response.result.size) {
                    Thread.sleep(100)
                    HistoryFragment2Service(this).TryGetSalesFinishImage(PostIdList[i], i)
                }
            }

        }else{
            showCustomToast("데이터를 받아오지 못했습니다.")
        }
    }

    override fun TryGetSalesFinishFailue(message: String) {
        showCustomToast(message)
    }

    override fun TryGetSalesFinishImageSuccess(response: ImageResponse,count:Int) {
        if(response.code==1000){
            Log.d("favorite_text",TitleList.size.toString())

            RvList.add(SalesHistoryDataClass(response.result.image, TitleList[count],"소흘읍","10초전",
                PriceList[count].toString(),1,1,SalesHistoryViewType().RV2))

        }else{
            showCustomToast(response.message+"TryGetSalesFinishImageSuccess")
        }

        if(count==TitleList.size-1) {
            binding.salesHistoryFragment2Rv.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.salesHistoryFragment2Rv.adapter = SalesHistoryAdapter(requireContext(), RvList)
        }

    }

    override fun TryGetSalesFinishImageFauiue(message: String) {
        showCustomToast(message+"TryGetSalesFinishImageFauiue")
    }


}