package com.riging_test.template.src.alarm

import android.os.Bundle
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityAlarmBinding
import com.riging_test.template.databinding.ActivityHomeCategoryBinding
import javax.net.ssl.SSLEngineResult

class AlarmActivity: BaseActivity<ActivityAlarmBinding>(ActivityAlarmBinding::inflate) {

    override fun onStart() {
        super.onStart()

        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}