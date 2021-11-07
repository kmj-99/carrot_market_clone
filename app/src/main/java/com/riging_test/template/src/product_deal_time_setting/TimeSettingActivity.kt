package com.riging_test.template.src.product_deal_time_setting

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityTimeSettingBinding
import com.riging_test.template.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class TimeSettingActivity: BaseActivity<ActivityTimeSettingBinding>(ActivityTimeSettingBinding::inflate) {
    private lateinit var time_dialog:TimePickerDialog
    private lateinit var dialog:DatePickerDialog

    override fun onStart() {
        super.onStart()
        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var date=CurrentData()
        var date_List=date.split(" ")



        binding.timeSettingLayoutTimeSetting.setOnClickListener {


            val listener=DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                showCustomToast("$year $month $dayOfMonth")
                time_dialog.show()
            }

            val time_listner=TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                showCustomToast("$hourOfDay $minute")
            }



            time_dialog=TimePickerDialog(this,R.style.MyTimePickerStyle,time_listner,10,12,false)
            dialog=DatePickerDialog(this,  R.style.MyDatePickerStyle,listener,date_List[0].toInt(),date_List[1].toInt(),date_List[2].toInt())




            dialog.show()

            //테마에서 변경을 했는데 변경이 잘 안되어서 밑에 코드로 변경을 하였다.
            dialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(resources.getColor(R.color.carrot_color, theme))
            dialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(R.color.carrot_color, theme))





        }



    }

    fun CurrentData():String{
        val current = LocalDateTime.now()
        val Date = DateTimeFormatter.ofPattern("yyyy MM dd")
        val Current_Date=current.format(Date)

        return Current_Date
    }








}