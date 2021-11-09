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
import com.riging_test.template.src.main._5my_carrot.MyCarrotService
import com.riging_test.template.src.my_favorite.fragment.fragment1.Rv.MyFavoriteRvAdapter
import com.riging_test.template.src.my_favorite.fragment.fragment1.Rv.MyFavoriteRvDataClass
import com.riging_test.template.src.my_favorite.fragment.fragment1.models.MyFavoriteListResponse

class MyFavoriteFragment1 : BaseFragment<FragmentMyFavorite1Binding>
    (FragmentMyFavorite1Binding::bind, R.layout.fragment_my_favorite1),MyFavoriteFragment1View{

    private var FavoriteList=ArrayList<MyFavoriteRvDataClass>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MyFavoriteService(this).TryGetFavoriteList(sSharedPreferences.getString("jwt","2")!!)


    }

    override fun getFavoriteListSuccess(response: MyFavoriteListResponse) {
        if(response.code==1000){
            for(i in 0 until response.result.size){
                FavoriteList.add(MyFavoriteRvDataClass(R.drawable.test_image,response.result[i].title,"소흘읍","10초전",response.result[i].cost.toString(),
                                                    1,1))

            }

            binding.myFavoriteFragment1Rv.layoutManager=LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)

            binding.myFavoriteFragment1Rv.adapter=MyFavoriteRvAdapter(requireContext(),FavoriteList)

        }else{
            showCustomToast(response.message+"getFavoriteListSuccess"+" in MyFavoriteFragment1")
        }

    }

    override fun getFavoriteListFailure(message: String) {
        showCustomToast(message)
    }
}