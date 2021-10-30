package com.riging_test.template.src.sign_up.second

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentSignupSecondBinding

class SignSecondFragment: BaseFragment<FragmentSignupSecondBinding>(FragmentSignupSecondBinding::bind, R.layout.fragment_signup_second) {
    private var TestList=ArrayList<SignupRvDataClass>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.searchImageSearch.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY)

        var Loading=SignSecondLoadingDialog(requireContext())
        binding.signupSecondNoResult.visibility=View.VISIBLE
        binding.signupSecondRv.visibility=View.INVISIBLE
        Loading.show()

        TestList.add(SignupRvDataClass("경기도"))
        TestList.add(SignupRvDataClass("서울"))
        TestList.add(SignupRvDataClass("충남"))
        TestList.add(SignupRvDataClass("충북"))
        TestList.add(SignupRvDataClass("전남"))
        TestList.add(SignupRvDataClass("전북"))
        TestList.add(SignupRvDataClass("제주"))
        TestList.add(SignupRvDataClass("울산"))
        TestList.add(SignupRvDataClass("인천"))
        TestList.add(SignupRvDataClass("부산"))

        binding.signupSecondRv.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.signupSecondRv.adapter=SignupRvAdapter(TestList)

        Loading.dismiss()

        binding.signupSecondRv.visibility=View.VISIBLE
        binding.signupSecondNoResult.visibility=View.INVISIBLE



    }

}