package com.riging_test.template.src.my_favorite.fragment.fragment1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentMyFavorite1Binding
import com.riging_test.template.src.main._1home.models.FavoriteImageResponse
import com.riging_test.template.src.main._5my_carrot.MyCarrotService
import com.riging_test.template.src.my_favorite.fragment.fragment1.Rv.MyFavoriteRvAdapter
import com.riging_test.template.src.my_favorite.fragment.fragment1.Rv.MyFavoriteRvDataClass
import com.riging_test.template.src.my_favorite.fragment.fragment1.models.MyFavoriteListResponse

class MyFavoriteFragment1 : BaseFragment<FragmentMyFavorite1Binding>
    (FragmentMyFavorite1Binding::bind, R.layout.fragment_my_favorite1),MyFavoriteFragment1View{

    private var FavoriteList=ArrayList<MyFavoriteRvDataClass>()
    private var ImageList=ArrayList<String>()
    private var TitleList=ArrayList<String>()
    private var PriceList=ArrayList<Int>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MyFavoriteService(this).TryGetFavoriteList(sSharedPreferences.getString("jwt","2")!!)


    }

    override fun getFavoriteListSuccess(response: MyFavoriteListResponse) {
        if(response.code==1000){
            if(response.result.size==0){
                binding.myFavoriteText.visibility=View.VISIBLE
                showCustomToast("관심목록이 없습니다.")
            }else {
                binding.myFavoriteText.visibility=View.INVISIBLE
                for (i in 0 until response.result.size) {
                    TitleList.add(response.result[i].title)
                    PriceList.add(response.result[i].cost)

                }
                MyFavoriteService(this).TryGetFavoriteImage(response.result[0].postId)
            }
        }else{
            showCustomToast(response.message+"getFavoriteListSuccess"+" in MyFavoriteFragment1")
        }

    }

    override fun getFavoriteListFailure(message: String) {
        showCustomToast(message)
    }

    override fun getFavoriteImageSuccess(response: FavoriteImageResponse) {
        if(response.code==1000){
            FavoriteList.add(MyFavoriteRvDataClass(response.result.image,TitleList[0],"소흘읍","10초전",PriceList[0].toString(),
                1,1))
            binding.myFavoriteFragment1Rv.layoutManager=LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)

            binding.myFavoriteFragment1Rv.adapter=MyFavoriteRvAdapter(requireContext(),FavoriteList)
        }else{
            showCustomToast(response.message+"getFavoriteImageSuccess")
        }


    }

    override fun getFavoriteImageFailure(message: String) {
        showCustomToast(message+"getFavoriteImageFailure")
    }
}