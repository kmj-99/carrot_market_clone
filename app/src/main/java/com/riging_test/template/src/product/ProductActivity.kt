package com.riging_test.template.src.product

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.widget.PopupMenu
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityProductBinding
import com.riging_test.template.src.product.rv.ProductRvAdapter
import com.riging_test.template.src.product.rv.ProductRvDataClass
import com.riging_test.template.src.product_deal.ProductDealChatActivity

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

        val Current_location=intent.getStringExtra("Location")
        val Name=intent.getStringExtra("Name")
        val image=intent.getIntExtra("Image",R.drawable.carrot_image)
        val Price=intent.getStringExtra("Price")

        binding.productTextLocation.text=Current_location
        binding.productTextTitle.text=Name
        binding.productTextPrice.text=Price
        Glide.with(this).load(image).centerCrop().into(binding.productProductImage)

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


        binding.productButtonBack.setOnClickListener {
            finish()
        }
        binding.productButtonHome.setOnClickListener {
            finish()
        }


        binding.productButtonReport.setOnClickListener {
            var popupMenu= PopupMenu(this,it)
            MenuInflater(this).inflate(R.menu.home_popup,popupMenu.menu)
            popupMenu.menu.findItem(R.id.menu_home_location_current).title="신고하기"
            popupMenu.menu.findItem(R.id.menu_home_location_add).title="이 사용자의 글 보지 않기"
            popupMenu.setOnMenuItemClickListener{item->
                when(item.itemId){
                    R.id.menu_home_location_current ->{

                        showCustomToast("${item.itemId}")
                    }
                    R.id.menu_home_location_add ->{
                        showCustomToast("${item.itemId}")

                    }

                }
                false
            }

            popupMenu.show()
        }

        binding.productButtonDeal.setOnClickListener {
            var ProductDealChat_Intent=Intent(this,ProductDealChatActivity::class.java)

            val Price=binding.productTextPrice.text
            val NickName=binding.productTextNickname.text

            ProductDealChat_Intent.putExtra("Price",Price)
            ProductDealChat_Intent.putExtra("NickName",NickName)


            startActivity(ProductDealChat_Intent)
        }


    }



}