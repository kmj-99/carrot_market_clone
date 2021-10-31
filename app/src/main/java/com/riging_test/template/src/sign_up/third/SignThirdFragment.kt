package com.riging_test.template.src.sign_up.third

import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.UnderlineSpan
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentGrowBinding
import com.riging_test.template.databinding.FragmentSignupThirdBinding

class SignThirdFragment: BaseFragment<FragmentSignupThirdBinding>(FragmentSignupThirdBinding::bind, R.layout.fragment_signup_third) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TextView 밑줄 추가하는 코드
        var content =SpannableString(binding.signupThirdEmailFind.text.toString())
        content.setSpan(UnderlineSpan(),0,content.length,0)
        binding.signupThirdEmailFind.text=content

        var Location=arguments?.getString("Location")

        binding.signupThirdEditPhoneNumber.addTextChangedListener(object:TextWatcher{
            //Text를 입력하기 전
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            //Text가 변경 될때
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(start<10){
                    binding.signupThirdCertification.setBackgroundResource(R.drawable.signup_third_certification_response_shape)
                }else if(start>10){
                    binding.signupThirdCertification.setBackgroundResource(R.drawable.signup_third_certification_no_response_shape)
                }

            }

            //Text 입력이 모두 끝났을 때
            override fun afterTextChanged(s: Editable?) {
            }

        })
        binding.signupThirdCertificationNumber.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(start<10){
                    binding.signupThirdCertificationConfirm.setBackgroundResource(R.drawable.signup_third_certification_response_shape)
                }else if(start>10){
                    binding.signupThirdCertificationConfirm.setBackgroundResource(R.drawable.signup_third_certification_no_response_shape)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        binding.signupThirdCertification.setOnClickListener {
            binding.signupThirdCertificationResponse.text="인증문자 다시 받기"
            binding.signupThirdCertificationInsert.visibility=View.VISIBLE
        }

        binding.signupThirdBack.setOnClickListener {
            showCustomToast("가입단계 진행 중에는 뒤로 갈 수 없습니다.")
        }
    }
}