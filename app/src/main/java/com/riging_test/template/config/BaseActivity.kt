package com.riging_test.template.config

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
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
}