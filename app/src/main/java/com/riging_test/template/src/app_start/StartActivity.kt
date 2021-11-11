package com.riging_test.template.src.app_start

import android.content.Intent
import android.os.Bundle
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityStartBinding
import com.riging_test.template.src.app_start.models.CertificationReponse
import com.riging_test.template.src.main.MainActivity
import com.riging_test.template.src.sign_up.SignActivity

class StartActivity : BaseActivity<ActivityStartBinding>(ActivityStartBinding::inflate),AppStartFragmentView {

    private var jwt= ApplicationClass.sSharedPreferences.getString("jwt","null")!!


    override fun onStart() {
        super.onStart()
        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(jwt!="null"){
            AppStartService(this).TryGetCertification(jwt)

        }else{
            startActivity(Intent(this,SignActivity::class.java))
        }

    }


    override fun getCertificationSuccess(response: CertificationReponse) {
        if(response.code==1000){
            showCustomToast("인증이 되었습니다.")
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            showCustomToast("인증이 안되었습니다.")
            startActivity(Intent(this,SignActivity::class.java))

        }

    }

    override fun getCertificationFailure(message: String) {

    }

}