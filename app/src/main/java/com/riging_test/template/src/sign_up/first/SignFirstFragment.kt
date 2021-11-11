package com.riging_test.template.src.sign_up.first

import android.os.Bundle
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentSignupFirstBinding
import com.riging_test.template.src.sign_up.second.SignupSecondFragment

class SignFirstFragment:BaseFragment<FragmentSignupFirstBinding>
    (FragmentSignupFirstBinding::bind, R.layout.fragment_signup_first) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.signupFirstButtonStart.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.signup_layout, SignupSecondFragment())
                ?.commitAllowingStateLoss()
        }

    }

}