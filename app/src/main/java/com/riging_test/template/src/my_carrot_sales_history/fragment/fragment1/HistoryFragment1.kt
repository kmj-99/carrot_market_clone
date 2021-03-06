package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.RvActivitySalesHostoryFragment1Binding
import com.riging_test.template.src.deal_finish.DealFinish
import com.riging_test.template.src.main._1home.Rv.HomeAdapter
import com.riging_test.template.src.my_carrot_sales_history.Rv.SalesHistoryAdapter
import com.riging_test.template.src.my_carrot_sales_history.Rv.SalesHistoryDataClass
import com.riging_test.template.src.my_carrot_sales_history.Rv.SalesHistoryViewType
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.ProductChangeFinishResponse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.SalesIngResonse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.TitleImageResponse
import com.riging_test.template.src.product.ProductActivity

class HistoryFragment1: BaseFragment<RvActivitySalesHostoryFragment1Binding>
    (RvActivitySalesHostoryFragment1Binding::bind, R.layout.rv_activity_sales_hostory_fragment1),HistoryFragment1View {


    private var RvList = ArrayList<SalesHistoryDataClass>()

    private val userId=sSharedPreferences.getInt("userId",1)
    private val jwt= sSharedPreferences.getString("jwt","1")!!

    private var postIdList = ArrayList<Int>()
    private var ImageList = ArrayList<String>()
    private var TitleList = ArrayList<String>()
    private var PriceList = ArrayList<Int>()


    private var count = false

    private lateinit var Rv: RecyclerView
    private lateinit var Rv_Adapter: SalesHistoryAdapter

    private val view=this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Rv = binding.salesHistoryFragment1Rv

        HistoryFragment1Service(this).TryGetSalesIng(userId)



    }

    override fun TryGetSalesIngSuccess(response: SalesIngResonse) {
        if (response.code == 1000) {
            if(response.result.size==0){
                binding.salesHistoryText1.visibility=View.VISIBLE
            }else {
                binding.salesHistoryText1.visibility=View.INVISIBLE
                if (!count) {
                    count = true
                    for (i in 0 until response.result.size) {
                        TitleList.add(response.result[i].title)
                        PriceList.add(response.result[i].cost)
                        postIdList.add(response.result[i].postId)

                    }
                    Log.d("TryGEtSales_Post",postIdList.size.toString())
                    for (i in 0 until postIdList.size) {
                        Thread.sleep(100)
                        HistoryFragment1Service(this).TryGetSalesImage(postIdList[i], i)
                    }
                } else {
//                for (i in 0 until response.result.size) {
//                    RvList.add(
//                        SalesHistoryDataClass(
//                            ImageList[i],
//                            response.result[i].title,
//                            "?????????",
//                            "2??????",
//                            "${response.result[i].cost}",
//                            3,
//                            2,
//                            SalesHistoryViewType().RV1
//                        )
//                    )
//                }
//
//                Rv_Adapter = SalesHistoryAdapter(requireContext(), RvList)
//                Rv.layoutManager =
//                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//                Rv.adapter = Rv_Adapter
//
//                Rv_Adapter.setItemClickListener(object : SalesHistoryAdapter.OnItemClickListener {
//                    override fun onClick(v: View, position: Int) {
//
//                        startActivity(Intent(requireContext(), DealFinish::class.java))
//
//                    }
//
//                })
                }
            }
            }else{
                showCustomToast("???????????? ???????????? ?????????")
            }

        }

        override fun TryGetSalesIngFailue(message: String) {
            showCustomToast(message)

        }

        override fun TryGetSalesImageSuccess(response: TitleImageResponse, count: Int) {
            if (response.code == 1000) {
                Log.d("Image_list", response.result.image)
                ImageList.add(response.result.image)
            } else {
                ImageList.add("https://modo-phinf.pstatic.net/20170419_207/1492566661261LrFEa_PNG/mosaPDcXf5.png")
                //showCustomToast(response.message + "TryGetSalesImageSuccess")
            }

            if (count == postIdList.size - 1) {
                for (i in 0 until postIdList.size) {
                    RvList.add(
                        SalesHistoryDataClass(
                            ImageList[i],
                            TitleList[i],
                            "?????????",
                            "2??????",
                            "${PriceList[i]}",
                            3,
                            2,
                            SalesHistoryViewType().RV1
                        )
                    )
                }

                Rv_Adapter = SalesHistoryAdapter(requireContext(), RvList)
                Rv.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                Rv.adapter = Rv_Adapter

                Rv_Adapter.setItemClickListener(object : SalesHistoryAdapter.OnItemClickListener {
                    override fun onClick(v: View, position: Int) {

                        HistoryFragment1Service(view).TryPatchChangeFinish(jwt,postIdList[position],20)
                        RvList.removeAt(position)
                        Rv_Adapter.notifyDataSetChanged()
                        startActivity(Intent(requireContext(), DealFinish::class.java))

                    }

                })
            }

            }
        override fun TryGetSalesImageFaiue(message: String) {
            showCustomToast(message + "TryGetSalesImageFaiue")
        }

    override fun TryPatchChangeFinishSuccess(response: ProductChangeFinishResponse) {
        if(response.code==1000){
            showCustomToast("??????????????? ?????????????????????.")
        }else{
            showCustomToast(response.message+"TryPatchChangeFinishSuccess")
        }

    }

    override fun TryPatchChangeFinishFaiue(message: String) {
        showCustomToast(message+"TryPatchChangeFinishFaiue")
    }
}
