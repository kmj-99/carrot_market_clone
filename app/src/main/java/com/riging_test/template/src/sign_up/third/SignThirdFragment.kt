package com.riging_test.template.src.sign_up.third

import android.content.Intent
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
import com.riging_test.template.src.main.MainActivity

class SignThirdFragment: BaseFragment<FragmentSignupThirdBinding>(FragmentSignupThirdBinding::bind, R.layout.fragment_signup_third) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TextView 밑줄 추가하는 코드
        var content =SpannableString(binding.signupThirdEmailFind.text.toString())
        content.setSpan(UnderlineSpan(),0,content.length,0)
        binding.signupThirdEmailFind.text=content

        var Location=arguments?.getString("Location")

        binding.signupThirdEditPhoneNumber.addTextChangedListener(object:TextWatcher{
            var Tiping1=true
            var Tiping2=true

            //Text를 입력하기 전
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            //Text가 변경 될때
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(start<9){
                    if(start==8) {
                        binding.signupThirdCertification.setBackgroundResource(R.drawable.signup_third_certification_response_shape)
                    }
                    if(start==2 && Tiping1){
                        binding.signupThirdEditPhoneNumber.setText("${s} ")
                        binding.signupThirdEditPhoneNumber.setSelection(s!!.length+1)
                        Tiping1=false
                    }
                    if(start<2){
                        Tiping1=true
                    }
                    if(start==7 && Tiping2){
                        binding.signupThirdEditPhoneNumber.setText("${s} ")
                        binding.signupThirdEditPhoneNumber.setSelection(s!!.length+1)
                        Tiping2=false
                    }
                    if(start<7){
                        Tiping2=true
                    }

                }else if(start>8){
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
                if(start<3){
                    binding.signupThirdCertificationConfirm.setBackgroundResource(R.drawable.signup_third_certification_response_shape)
                }else{
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

        binding.signupThirdCertificationConfirm.setOnClickListener {
            //전화번호 인증이 되면 토큰을 받아서 SharedPreference에 저장을 하고 다시 앱을 시작할 때 해당 토큰이 확인 되면 바로 홈 화면으로 넘어갈 수 있게해야한다.
            //아직 api가 안 나왔기에 보류

            startActivity(Intent(activity,MainActivity::class.java))
            requireActivity().finish()
        }
    }
}