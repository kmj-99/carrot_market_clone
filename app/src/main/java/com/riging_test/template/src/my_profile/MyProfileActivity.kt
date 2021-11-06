package com.riging_test.template.src.my_profile

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityMyProfileBinding
import com.riging_test.template.src.my_profile.Rv.MyProfileAdapter
import com.riging_test.template.src.my_profile.Rv.MyProfileDataClass
import com.riging_test.template.src.my_profile.Rv.MyProfileViewType

class MyProfileActivity: BaseActivity<ActivityMyProfileBinding>(ActivityMyProfileBinding::inflate) {
    private var RvList=ArrayList<MyProfileDataClass>()
    private var CategoryList=arrayOf("활동 배지 5개","판매상품 0개","동네생활","동네홍보 글","받은 매너 평가","받은 거래 후기")

    override fun onStart() {
        super.onStart()

        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for(i in CategoryList){
            Log.d("CategoryList","$i")
            if(i=="받은 매너 평가") {
                RvList.add(MyProfileDataClass("$i", "받은 매너 칭찬이 없습니다", R.drawable.right_icon,MyProfileViewType().INFO2))
            }else if(i=="받은 거래 후기"){
                RvList.add(MyProfileDataClass("$i","받은 후기가 없습니다",R.drawable.right_icon,MyProfileViewType().INFO2))
            }else{
                RvList.add(MyProfileDataClass("$i",null,R.drawable.right_icon))
            }


        }

        binding.myProfileRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.myProfileRv.adapter=MyProfileAdapter(this,RvList)

    }

}