package com.riging_test.template.src.product

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuInflater
import android.widget.PopupMenu
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.config.ApplicationClass.Companion.editor
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityProductBinding
import com.riging_test.template.src.product.models.request.AddRequest
import com.riging_test.template.src.product.models.request.DeleteRequest
import com.riging_test.template.src.product.models.response.AddResponse
import com.riging_test.template.src.product.models.response.DeleteResponse
import com.riging_test.template.src.product.models.response.FavoriteListResponse
import com.riging_test.template.src.product.rv.ProductRvAdapter
import com.riging_test.template.src.product.rv.ProductRvDataClass
import com.riging_test.template.src.product_deal.ProductDealChatActivity

class ProductActivity:BaseActivity<ActivityProductBinding>(ActivityProductBinding::inflate),ProductActivityView {
    private var TestItemList=ArrayList<ProductRvDataClass>()
    private var TestItemList2=ArrayList<ProductRvDataClass>()
    private var PostIdList=ArrayList<Int>()
    private var WishIdList=ArrayList<Int>()

    private var jwt=sSharedPreferences.getString("jwt","w")!!

    private var favorite=false

    private var postId=20
    private var Start=true

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
        val Time=intent.getStringExtra("Time")
        val userId=sSharedPreferences.getInt("userId",1)
        postId=intent.getIntExtra("postId",0)

        ProductService(this).TryGetFavoriteList(jwt)
        showCustomToast("$userId $postId")

        binding.productTextLocation.text=Current_location
        binding.productTextTitle.text=Name
        binding.productTextPrice.text=Price
        binding.productTextTime.text=Time
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


        binding.productButtonFavorite.setOnClickListener {
            if(!favorite) {
                Glide.with(this).load(R.drawable.select_favorite_icon)
                    .into(binding.productButtonFavorite)

                ProductService(this).TryPostAdd(AddRequest(userId = userId,postId=postId),jwt =jwt)

                favorite=true
            }else{
                ProductService(this).TryGetFavoriteList(jwt)

                favorite=false
            }
        }


    }

    override fun TryPostAddSuccess(response: AddResponse) {
        when(response.code){
            1000 -> {
                showCustomToast("관심목록에 추가되었습니다.")
            }

            else ->{
                showCustomToast(response.message)
            }
        }

    }

    override fun TryPostAddFailue(message: String) {
        showCustomToast(message)
    }

    override fun TryDeleteSuccess(response: DeleteResponse) {
        if(response.code==1000){
            showCustomToast("관심목록에서 삭제되었습니다.")
        }else{
            showCustomToast(response.message)
        }
    }

    override fun TryDeleteFailue(message: String) {
        showCustomToast(message)
    }

    override fun TryGetFavoriteSuccess(response: FavoriteListResponse) {
        if(response.code==1000){
            showCustomToast(response.result.size.toString())
            PostIdList.clear()
            WishIdList.clear()
            for(i in 0 until  response.result.size){
                PostIdList.add(response.result[i].postId)
                WishIdList.add(response.result[i].wishListId)
            }


            Log.d("postId",postId.toString())
            //포스트를 로드시킬 때 이 포스트가 내가 관심목록을 눌렀던 거라면 하트표시를 해주어야 하기에 Start를 사용 했다. 
            // 한 번만 해도 되서 이 로직을 수행을 하기에 Start로 구분했고 Start를 false로 바꾸면 그 후에 관심목록 제거를 헸을 때의 로직을 수행  
            if(Start) {
                if (postId in PostIdList) {
                    //불러온 게시물의 postId가 관심목록에 있는 postId에 있으면 하트를 바꿈
                    Log.d("Favorite_List", PostIdList[0].toString())
                    Glide.with(this).load(R.drawable.select_favorite_icon)
                        .into(binding.productButtonFavorite)
                    favorite = true
                }
            Start=false
            }else{
                Glide.with(this).load(R.drawable.select_no_favorite_icon).into(binding.productButtonFavorite)
                //해당 게시물의 postId가 나의 관심목록에 어떤 wishId인지 찾는 코드
                for(i in 0 until PostIdList.size){
                    if(postId==PostIdList[i])
                    {
                        ProductService(this).TryPatchDelete(jwt = jwt, DeleteRequest("Invalid"),WishIdList[i])

                    }
                }
            }
        }else{
            showCustomToast(response.message)
        }
    }

    override fun TryGetFavoriteFailue(message: String) {
        showCustomToast(message)
    }


}