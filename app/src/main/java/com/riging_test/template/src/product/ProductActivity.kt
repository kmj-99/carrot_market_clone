package com.riging_test.template.src.product

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuInflater
import android.widget.PopupMenu
import androidx.annotation.Px
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityProductBinding
import com.riging_test.template.src.product.models.request.AddRequest
import com.riging_test.template.src.product.models.request.DeleteRequest
import com.riging_test.template.src.product.models.response.AddResponse
import com.riging_test.template.src.product.models.response.DeleteResponse
import com.riging_test.template.src.product.models.response.FavoriteListResponse
import com.riging_test.template.src.product.models.response.ImageListResponse
import com.riging_test.template.src.product.rv.ProductRvAdapter
import com.riging_test.template.src.product.rv.ProductRvDataClass
import com.riging_test.template.src.product.view_pager.ProductViewPagerAdapter
import com.riging_test.template.src.product_deal.ProductDealChatActivity

class ProductActivity:BaseActivity<ActivityProductBinding>(ActivityProductBinding::inflate),ProductActivityView {
    private var TestItemList=ArrayList<ProductRvDataClass>()
    private var TestItemList2=ArrayList<ProductRvDataClass>()
    private var PostIdList=ArrayList<Int>()
    private var WishIdList=ArrayList<Int>()

    private val jwt=sSharedPreferences.getString("jwt","w")!!
    private val userId=sSharedPreferences.getInt("userId",1)


    private var favorite=false

    private var postId=20
    private var Start=true

    private var ImageList=ArrayList<String>()

    override fun onStart() {
        super.onStart()

        StatusColor()
        TextUnderBar(binding.productTextPricePropose)
        TextUnderBar(binding.productTextMannerTemperature)
        TextUnderBar(binding.productTextCategory)



    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var category=resources.getStringArray(R.array.categort)


        val Current_location=intent.getStringExtra("Location")
        val Category=intent.getIntExtra("Category",1)
        val Content=intent.getStringExtra("Content")
        val image=intent.getIntExtra("Image",R.drawable.test_image)
        val Price=intent.getStringExtra("Price")
        val Time=intent.getStringExtra("Time")
        val Title=intent.getStringExtra("Title")
        postId=intent.getIntExtra("postId",0)

        ProductService(this).GetImageList(postId)

        ProductService(this).TryGetFavoriteList(jwt)

        binding.productTextTitle.text=Title
        binding.productTextContent.text=Content
        binding.productTextLocation.text=Current_location
        binding.productTextPrice.text=Price
        binding.productTextTime.text=Time
        Log.d("Cateogry_numner",Category.toString())
        binding.productTextCategory.text=category[Category-1]








            TestItemList.add(ProductRvDataClass(R.drawable.dumy1, "?????? ?????????", "10,0000???"))
            TestItemList.add(ProductRvDataClass(R.drawable.dumy2, "?????? ??????", "30,000???"))
            TestItemList.add(ProductRvDataClass(R.drawable.dumy3, "?????? ?????????", "25,000???"))
            TestItemList.add(ProductRvDataClass(R.drawable.dumy4 ,"?????? ?????????", "55,000???"))


        binding.productRv1.layoutManager=GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false)
        binding.productRv1.adapter=ProductRvAdapter(this,TestItemList)


        TestItemList2.add(ProductRvDataClass(R.drawable.n_dumy1, "?????????", "35,000???"))
        TestItemList2.add(ProductRvDataClass(R.drawable.n_dumy2, "????????? ?????????", "24,000???"))
        TestItemList2.add(ProductRvDataClass(R.drawable.n_dumy3, "?????? ??????", "41,000???"))
        TestItemList2.add(ProductRvDataClass(R.drawable.n_dumy4, "???????????? ??????", "10,000???"))

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
            popupMenu.menu.findItem(R.id.menu_home_location_current).title="????????????"
            popupMenu.menu.findItem(R.id.menu_home_location_add).title="??? ???????????? ??? ?????? ??????"
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
            val Title=binding.productTextTitle.text

            ProductDealChat_Intent.putExtra("Price",Price)
            ProductDealChat_Intent.putExtra("NickName",NickName)
            ProductDealChat_Intent.putExtra("Title",Title)
            ProductDealChat_Intent.putExtra("PostId",postId)


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



        binding.AppBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener{

            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {

                if (appBarLayout != null) {
                    when{
                        //collapsing??? ???????????????
                        verticalOffset==0 -> {
                            Glide.with(applicationContext).load(R.drawable.home_callapsing_left).into(binding.productButtonBack)
                            Glide.with(applicationContext).load(R.drawable.home_callapsing_home).into(binding.productButtonHome)
                            Glide.with(applicationContext).load(R.drawable.home_callapsing_share).into(binding.productButtonShare)
                            Glide.with(applicationContext).load(R.drawable.home_callasing_list).into(binding.productButtonReport)


                        }

                        //????????? collapsing ???????????? ???, ??????????????? ????????? ???
                        Math.abs(verticalOffset) >=appBarLayout.totalScrollRange -> {

                            Glide.with(applicationContext).load(R.drawable.home_callasing_left2).into(binding.productButtonBack)
                            Glide.with(applicationContext).load(R.drawable.home_callasing_home2).into(binding.productButtonHome)
                            Glide.with(applicationContext).load(R.drawable.home_callasing_share2).into(binding.productButtonShare)
                            Glide.with(applicationContext).load(R.drawable.home_callasing_list2).into(binding.productButtonReport)


                        }

                        Math.abs(verticalOffset) <=820 ->{
                            Glide.with(applicationContext).load(R.drawable.home_callapsing_left).into(binding.productButtonBack)
                            Glide.with(applicationContext).load(R.drawable.home_callapsing_home).into(binding.productButtonHome)
                            Glide.with(applicationContext).load(R.drawable.home_callapsing_share).into(binding.productButtonShare)
                            Glide.with(applicationContext).load(R.drawable.home_callasing_list).into(binding.productButtonReport)
                        }

                        Math.abs(verticalOffset) >=820->{
                            Glide.with(applicationContext).load(R.drawable.home_callapsing_left).into(binding.productButtonBack)
                            Glide.with(applicationContext).load(R.drawable.home_callapsing_home).into(binding.productButtonHome)
                            Glide.with(applicationContext).load(R.drawable.home_callapsing_share).into(binding.productButtonShare)
                            Glide.with(applicationContext).load(R.drawable.home_callasing_list).into(binding.productButtonReport)

                        }


                        // collapsing??? ???????????????
                        else-> {

                        }
                    }
                }
            }
        })





    }

    override fun TryPostAddSuccess(response: AddResponse) {
        when(response.code){
            1000 -> {
                showCustomToast("??????????????? ?????????????????????.")
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
            showCustomToast("?????????????????? ?????????????????????.")
        }else{
            showCustomToast(response.message)
        }
    }

    override fun TryDeleteFailue(message: String) {
        showCustomToast(message)
    }

    override fun TryGetFavoriteSuccess(response: FavoriteListResponse) {
        if(response.code==1000){
            PostIdList.clear()
            WishIdList.clear()
            for(i in 0 until  response.result.size){
                PostIdList.add(response.result[i].postId)
                WishIdList.add(response.result[i].wishListId)
            }


            Log.d("postId",postId.toString())
            //???????????? ???????????? ??? ??? ???????????? ?????? ??????????????? ????????? ????????? ??????????????? ???????????? ????????? Start??? ?????? ??????. 
            // ??? ?????? ?????? ?????? ??? ????????? ????????? ????????? Start??? ???????????? Start??? false??? ????????? ??? ?????? ???????????? ????????? ?????? ?????? ????????? ??????  
            if(Start) {
                if (postId in PostIdList) {
                    //????????? ???????????? postId??? ??????????????? ?????? postId??? ????????? ????????? ??????
                    Log.d("Favorite_List", PostIdList[0].toString())
                    Glide.with(this).load(R.drawable.select_favorite_icon)
                        .into(binding.productButtonFavorite)
                    favorite = true
                }
            Start=false
            }else{
                Glide.with(this).load(R.drawable.select_no_favorite_icon).into(binding.productButtonFavorite)
                //?????? ???????????? postId??? ?????? ??????????????? ?????? wishId?????? ?????? ??????
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

    override fun TryGetImageListSuccess(response: ImageListResponse) {
        if(response.code==1000){
            for(i in 0 until response.result.size){
                Log.d("Image_List",response.result[i].image)
                ImageList.add(response.result[i].image)
            }
            var viewPager=binding.productViewPager
            viewPager.adapter=ProductViewPagerAdapter(this,ImageList)
            viewPager.orientation= ViewPager2.ORIENTATION_HORIZONTAL


            viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){

                override fun onPageScrolled(
                    position: Int, positionOffset: Float,
                    @Px positionOffsetPixels: Int
                ) {
                }
                //??????????????? ??????????????? ??? ??????????????? ???????????? ???????????? ??????
                override fun onPageSelected(position: Int) {
                    when(position){
                        0 -> {
                            binding.productImageIndex1.setImageResource(R.color.dark_gray)
                            binding.productImageIndex2.setImageResource(R.color.light_gray)
                        }
                        1 -> {
                            binding.productImageIndex1.setImageResource(R.color.light_gray)
                            binding.productImageIndex2.setImageResource(R.color.dark_gray)
                        }
                    }

                }

                override fun onPageScrollStateChanged(@ViewPager2.ScrollState state: Int) {}

            })



        }

    }

    override fun TryGetImageListFailue(message: String) {
        showCustomToast(message+"TryGetImageListFailue")
    }


}