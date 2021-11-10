package com.riging_test.template.src.main._1home

import android.app.Application
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuInflater
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.MultiTransformation
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentHomeBinding
import com.riging_test.template.src.alarm.AlarmActivity
import com.riging_test.template.src.home_category.HomeCategoryActivity
import com.riging_test.template.src.product.ProductActivity
import com.riging_test.template.src.main._1home.Rv.HomeAdapter
import com.riging_test.template.src.main._1home.Rv.HomeDataClass
import com.riging_test.template.src.main._1home.models.HomePostListDataClass
import com.riging_test.template.src.main._1home.models.HomeTitleImageResponse
import com.riging_test.template.src.main._1home.models.PostIdRresponse
import com.riging_test.template.src.main._1home.models.RangeResponse
import com.riging_test.template.src.my_location_setting.MyLocationSettingAcvitiy
import com.riging_test.template.src.posting.PostingActivity
import com.riging_test.template.src.search.SearchActivity
import com.riging_test.template.src.sign_up.second.SignupSecondService

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),HomeFragmentView {
    private var TestItemList = ArrayList<HomeDataClass>()
    private var TitleImageList = ArrayList<String>()
    private var PostIdList=ArrayList<Int>()

    private lateinit var defalt_Location: String
    private lateinit var add_Location: String

    private lateinit var Home_Rv_Adapter: HomeAdapter

    private var Close = true
    private var Icon_Dowun = true

    private lateinit var jwt: String
    private var paising_numner = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var sWipe = binding.homeSwiper

        defalt_Location = "서울"
        add_Location = "내 동네 설정"

        var fab_open = AnimationUtils.loadAnimation(requireContext(), R.anim.fab_open)
        var fab_close = AnimationUtils.loadAnimation(requireContext(), R.anim.fab_close)


        var icon_down = AnimationUtils.loadAnimation(requireContext(), R.anim.icon_rotate_down)
        var icon_up = AnimationUtils.loadAnimation(requireContext(), R.anim.icon_rotate_up)


        jwt = sSharedPreferences.getString("jwt", "0")!!
        Home_Rv_Adapter = HomeAdapter(requireContext(), TestItemList)

        HomeFragmentService(this).TryGetPostId(32)





        sWipe.setOnRefreshListener {

            HomeFragmentService(this).TryGetPostId(32)



            sWipe.isRefreshing = false
        }





        binding.homeSearch.setOnClickListener {
            startActivity(Intent(requireContext(), SearchActivity::class.java))
        }

        binding.homeList.setOnClickListener {
            startActivity(Intent(requireContext(), HomeCategoryActivity::class.java))
        }

        binding.homeAlarm.setOnClickListener {
            startActivity(Intent(requireContext(), AlarmActivity::class.java))
        }


        binding.homeButtonPlus.setOnClickListener {

            if (Close) {
                binding.homeButtonPlus.setBackgroundColor(resources.getColor(R.color.white))
                binding.homeButtonMarketing.startAnimation(fab_open)
                binding.homeButtonPosting.startAnimation(fab_open)

                Close = false
            } else {
                binding.homeButtonPlus.setBackgroundColor(resources.getColor(R.color.carrot_color))
                binding.homeButtonMarketing.startAnimation(fab_close)
                binding.homeButtonPosting.startAnimation(fab_close)

                Close = true
            }

        }

        binding.homeButtonMarketing.setOnClickListener {
            showCustomToast("Marketing")
            binding.homeButtonMarketing.startAnimation(fab_close)
            binding.homeButtonPosting.startAnimation(fab_close)
            Close = true
        }
        binding.homeButtonPosting.setOnClickListener {
            startActivity(Intent(requireContext(), PostingActivity::class.java))


            binding.homeButtonMarketing.startAnimation(fab_close)
            binding.homeButtonPosting.startAnimation(fab_close)
            Close = true

        }


        Home_Rv_Adapter.setItemClickListener(object : HomeAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                var Product_Intent = Intent(requireActivity(), ProductActivity::class.java)

                Product_Intent.putExtra("Location", TestItemList[position].Location.toString())
                Product_Intent.putExtra("Title", TestItemList[position].Title.toString())
                Product_Intent.putExtra("Category",TestItemList[position].Category)
                Product_Intent.putExtra("Content",TestItemList[position].content.toString())
                Product_Intent.putExtra("Image", TestItemList[position].ImageUrl)
                Product_Intent.putExtra("Price", TestItemList[position].Price)
                Product_Intent.putExtra("Time", TestItemList[position].Time)
                Product_Intent.putExtra("userId", TestItemList[position].userId)
                Product_Intent.putExtra("postId", TestItemList[position].postId)



                startActivity(Product_Intent)

            }

        })


        var view = this
        //binding.homeRv.addOnScrollListener(object : RecyclerView.OnScrollListener(){
        //    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        //        super.onScrolled(recyclerView, dx, dy)
//
        //        var lastVisibleItemPosition = (recyclerView!!.getLayoutManager() as LinearLayoutManager).findLastCompletelyVisibleItemPosition();
        //        var itemTotalCount = recyclerView.getAdapter()!!.getItemCount() - 1;
//
        //        if(lastVisibleItemPosition==itemTotalCount){
        //            showLoading(requireContext())
        //            HomeFragmentService(view).TryGetRange(jwt)
//
//
        //            showCustomToast("Last")
        //        }
//
        //    }
//
        //})


        binding.homeLocationAdd.setOnClickListener {
            if (Icon_Dowun) {
                binding.homeIconBottomUp.startAnimation(icon_up)
                Icon_Dowun = false
            } else {
                binding.homeIconBottomUp.startAnimation(icon_down)
                Icon_Dowun = true
            }
            var popupMenu = PopupMenu(requireContext(), it)
            MenuInflater(requireContext()).inflate(R.menu.home_popup, popupMenu.menu)
            popupMenu.menu.findItem(R.id.menu_home_location_current).title = defalt_Location
            popupMenu.menu.findItem(R.id.menu_home_location_add).title = add_Location


            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_home_location_current -> {
                        showCustomToast("${item.itemId}")
                    }
                    R.id.menu_home_location_add -> {
                        startActivity(
                            Intent(
                                requireContext(),
                                MyLocationSettingAcvitiy::class.java
                            )
                        )

                    }

                }
                false
            }
            popupMenu.setOnDismissListener {
                binding.homeIconBottomUp.startAnimation(icon_down)
                Icon_Dowun = true
            }
            popupMenu.show()
        }


    }

    fun dialog() {
        var dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.activity_home_float_button_bacground)
        dialog.show()
    }


    override fun TryGetPostListSuccess(response: HomePostListDataClass) {
        if (response.code == 1000) {
            TestItemList.clear()
            for (i in 0 until response.result.size) {
                if (i < TitleImageList.size){
                    Log.d("Title_Test",TitleImageList[i])
                    TestItemList.add(
                        HomeDataClass(
                            TitleImageList[i],
                            response.result[i].title,
                            response.result[i].categoryId,
                            response.result[i].content,
                            response.result[i].townName,
                            response.result[i].time,
                            "${response.result[i].cost.toString()}원",
                            1,
                            1,
                            response.result[i].userId,
                            response.result[i].postId
                        )
                    )
            }
            }
            Thread.sleep(1000)


            binding.homeRv.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            binding.homeRv.adapter = Home_Rv_Adapter

        } else {
            showCustomToast(response.message+"TryGetPostListSuccess")
        }
    }


        override fun TryGetPostFailure(message: String) {
            showCustomToast(message)
        }

        override fun TryGetRangeSuccess(response: RangeResponse) {
            if (response.code == 1000) {
                HomeFragmentService(this).TryGetPostList(jwt, 1665, response.result.range)
            } else {

                showCustomToast(response.message+"TryGetRangeSuccess")
            }
        }

        override fun TryGetRangeFailure(message: String) {
            showCustomToast(message)
        }


        override fun TryGetTitleImageSuccess(response: HomeTitleImageResponse,count:Int) {
            if (response.code == 1000) {
                Log.d("Title_iamge_size",response.result.image)
                TitleImageList.add(response.result.image)

            } else {
                Log.d("Title_iamge_size","null")

            }
            if(count==PostIdList.size-1){
                HomeFragmentService(this).TryGetRange(jwt)
            }

        }

        override fun TryGetTitleImageFailure(message: String) {
            showCustomToast(message)
        }

    override fun TryGetPostIdSucess(response: PostIdRresponse) {
        if(response.code==1000){
            for(i in 0 until response.result.size){
                PostIdList.add(response.result[i].postId)

            }

            for (i in 0 until PostIdList.size) {
                Thread.sleep(100)
                HomeFragmentService(this).TryGetTitleImage(PostIdList[i],i)
            }



        }else{
            showCustomToast(response.message+"TryGetPostIdSucess")
        }
    }

    override fun TryGetPostIdFailure(message: String) {
        showCustomToast(message)
    }


}
