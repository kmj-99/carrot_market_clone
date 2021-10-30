package com.riging_test.template.src.sign_up.second

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import com.riging_test.template.R

class SignSecondLoadingDialog(context: Context):Dialog(context) {

    init{
        setCanceledOnTouchOutside(false) // 외부에서 클릭을 해도 로딩창이 안 없어지게 하는 코드

        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        // 뒷 배경 어둡게

        setContentView(R.layout.activity_signup_second_loading)
        var parms=this.window!!.attributes
        parms.width=WindowManager.LayoutParams.MATCH_PARENT
        parms.height=WindowManager.LayoutParams.MATCH_PARENT
        this.window!!.attributes=parms

    }

}