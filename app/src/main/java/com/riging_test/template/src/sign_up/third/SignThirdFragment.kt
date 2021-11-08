package com.riging_test.template.src.sign_up.third

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.*
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentSignupThirdBinding
import com.riging_test.template.src.main.MainActivity
import com.riging_test.template.src.sign_up.third.models.PostSignUpRequest
import com.riging_test.template.src.sign_up.third.models.PostSignUpResponse
import com.riging_test.template.src.sign_up.zfourth.SignFourthFragment
import kotlinx.android.synthetic.main.fragment_signup_fourth.*

class SignThirdFragment: BaseFragment<FragmentSignupThirdBinding>(FragmentSignupThirdBinding::bind, R.layout.fragment_signup_third),SignThirdFragmentView {

    private var phoneNumber="01012326955"
    private val certificationNum="018099"
    private lateinit var current_location:String

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor:SharedPreferences.Editor
    private var signFourthFragment=SignFourthFragment()





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences=requireActivity().getSharedPreferences("profile", Context.MODE_PRIVATE)
        editor=sharedPreferences.edit()

        val textData=binding.signupThirdTextInfo.text

        val spannable=SpannableStringBuilder(textData)
        val boldSpan=StyleSpan(Typeface.BOLD)
        spannable.setSpan(boldSpan,24,33,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.signupThirdTextInfo.text=spannable

//StyleSpan(Typeface.BOLD) 24,32

        //TextView 밑줄 추가하는 코드
        var content =SpannableString(binding.signupThirdEmailFind.text.toString())
        content.setSpan(UnderlineSpan(),0,content.length,0)
        binding.signupThirdEmailFind.text=content

        current_location=arguments?.getString("Location")!!

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
            //해당 전화번호에 대한 토큰(sharepreference)이 있다면 바로 다음 화면으로 넘어감
            //해당 전화번호에 대한 토큰이 없다면 프로필설정화면으로 넘어 감
            //아직 api가 안 나왔기에 보류

            //startActivity(Intent(activity,MainActivity::class.java)) // 토큰이 있을 때
            //requireActivity().finish()

            phoneNumber=binding.signupThirdEditPhoneNumber.text.toString()
            var certification_number=binding.signupThirdCertificationNumber.text.toString()
            phoneNumber=phoneNumber.replace(" ","")

            SignThirdService(this).PostCertification(PostSignUpRequest(phoneNumber=phoneNumber,certificationNum=certification_number))

        }
    }

    override fun onPostCertificationSuccess(response: PostSignUpResponse) {

        if(response.code==1000){
            startActivity(Intent(requireActivity(),MainActivity::class.java))
            editor.putString("Jwt","${response.result.jwt}")
            editor.apply()
            Log.d("onPostCertificationSuccess","!")

            requireActivity().finish()

            //인증이 안 된 핸드폰번호면 서버에서 jwt를 보내줌 그래서 그걸 저장
        }else if(response.code==2020){

            var bundle=Bundle()
            bundle.putString("phoneNumber",phoneNumber)
            bundle.putString("location",current_location)

            signFourthFragment.arguments=bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.signup_layout, signFourthFragment)
                .commitAllowingStateLoss()
        }
    }

    override fun onPostCertificationFailure(message: String) {
        showCustomToast("오류 : $message")
    }
}