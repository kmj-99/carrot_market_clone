package com.riging_test.template.src.sign_up.first

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentSignupFirstBinding
import com.riging_test.template.src.main.MainActivity
import com.riging_test.template.src.sign_up.SignActivity
import com.riging_test.template.src.sign_up.second.SignupSecondFragment

class SignFirstFragment:BaseFragment<FragmentSignupFirstBinding>(FragmentSignupFirstBinding::bind, R.layout.fragment_signup_first) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        if(sSharedPreferences.getString("jwt","ERROR")!="ERROR"){ //jwt가 있으면 바로 메인화면으로 이동
            var Sign_Intent = Intent(requireActivity(), SignActivity::class.java)

            startActivity(Intent(requireActivity(),MainActivity::class.java))
            requireActivity().finish()

        }else{
            var Main_Intent=Intent(requireActivity(),MainActivity::class.java)

            binding.signupFirstButtonStart.setOnClickListener {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.signup_layout, SignupSecondFragment())
                    ?.commitAllowingStateLoss()
            }
        }

    }


}