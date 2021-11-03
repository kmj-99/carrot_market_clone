package com.riging_test.template.src.sign_up.first

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentSignupFirstBinding
import com.riging_test.template.src.main.MainActivity
import com.riging_test.template.src.sign_up.second.SignupSecondFragment

class SignFirstFragment:BaseFragment<FragmentSignupFirstBinding>(FragmentSignupFirstBinding::bind, R.layout.fragment_signup_first) {
    private lateinit var sharedPreferences: SharedPreferences


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("Token", MODE_PRIVATE)

        if (sharedPreferences.getString("phoneNumber", "Error") != "Error") {
            startActivity(Intent(requireActivity(),MainActivity::class.java))
            requireActivity().finish()

        }else{
            binding.signupFirstButtonStart.setOnClickListener {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.signup_layout, SignupSecondFragment())
                    ?.commitAllowingStateLoss()
            }

        }
    }


}