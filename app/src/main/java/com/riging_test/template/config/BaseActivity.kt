package com.riging_test.template.config

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.riging_test.template.util.LoadingDialog

abstract class BaseActivity<B: ViewBinding>(private val inflate:(LayoutInflater)->B):AppCompatActivity(){
    protected lateinit var binding:B
    private set
    lateinit var mLoadingDialog:LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun showLoadingDialog(context: Context){
        mLoadingDialog= LoadingDialog(context)
        mLoadingDialog.show()
    }

    fun dismissLoadingDialog(){
        if(mLoadingDialog.isShowing){
            mLoadingDialog.dismiss()
        }
    }

    fun showCustomToast(message:String){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

    fun StatusColor(){
        //상태바 투명하게 만드는 코드
        window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.TRANSPARENT

    }
}