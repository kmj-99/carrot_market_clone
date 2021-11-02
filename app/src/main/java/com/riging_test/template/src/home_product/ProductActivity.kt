package com.riging_test.template.src.home_product

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityProductBinding
import com.riging_test.template.src.product.rv.ProductRvAdapter
import com.riging_test.template.src.product.rv.ProductRvDataClass

class ProductActivity:BaseActivity<ActivityProductBinding>(ActivityProductBinding::inflate) {
    private var TestItemList=ArrayList<ProductRvDataClass>()
    private var TestItemList2=ArrayList<ProductRvDataClass>()

    override fun onStart() {
        super.onStart()

        StatusColor()
        TextUnderBar(binding.productTextPricePropose)
        TextUnderBar(binding.productTextMannerTemperature)
        TextUnderBar(binding.productTextCategory)



    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Glide.with(this).load(R.drawable.test_image).centerCrop().into(binding.productProductImage)

        for(i in 1..4) {
            TestItemList.add(ProductRvDataClass(R.drawable.test_image, "Rocky$i", "$i,000원"))
        }
        binding.productRv1.layoutManager=GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false)
        binding.productRv1.adapter=ProductRvAdapter(this,TestItemList)


        for(i in 1..10) {
            TestItemList2.add(ProductRvDataClass(R.drawable.test_image, "Android$i", "$i,200원"))
        }

        binding.productRv2.layoutManager=GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false)
        binding.productRv2.adapter=ProductRvAdapter(this,TestItemList2)




    }



}