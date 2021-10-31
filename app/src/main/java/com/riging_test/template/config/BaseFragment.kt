package com.riging_test.template.config

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.riging_test.template.src.sign_up.second.SignupSecondLoadingDialog
import com.riging_test.template.util.LoadingDialog

abstract class BaseFragment<B: ViewBinding>(
    private val bind:(View)->B,
    @LayoutRes layoutresId:Int
) : Fragment(layoutresId) {

    private var _binding:B?=null
    lateinit var mLoadingDialog:LoadingDialog
    lateinit var Loading:SignupSecondLoadingDialog

    protected val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=bind(super.onCreateView(inflater, container, savedInstanceState)!!)

        return binding.root
    }

    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }

    fun showCustomToast(message:String){
        Toast.makeText(activity,message, Toast.LENGTH_LONG).show()
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

    fun showLoading(context:Context){
        Loading=SignupSecondLoadingDialog(context)
        Loading.show()

    }
    fun dismissLoading(){
        if(Loading.isShowing){
            Loading.dismiss()
        }
    }




}