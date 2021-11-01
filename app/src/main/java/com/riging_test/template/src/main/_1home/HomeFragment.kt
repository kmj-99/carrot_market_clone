package com.riging_test.template.src.main._home

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentHomeBinding
import com.riging_test.template.src.alarm.AlarmActivity
import com.riging_test.template.src.home_category.HomeCategoryActivity
import com.riging_test.template.src.main._1home.Rv.HomeAdapter
import com.riging_test.template.src.main._1home.Rv.HomeDataClass
import com.riging_test.template.src.search.SearchActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {
    private var TestItemList=ArrayList<HomeDataClass>()
    private lateinit var defalt_Location:String
    private lateinit var add_Location:String

    private var Close=true


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        defalt_Location="서울"
        add_Location="내 동네 설정"

        var fab_open=AnimationUtils.loadAnimation(requireContext(),R.anim.fab_open)
        var fab_close=AnimationUtils.loadAnimation(requireContext(),R.anim.fab_close)

        var icon_down=AnimationUtils.loadAnimation(requireContext(),R.anim.icon_rotate_down)
        var icon_up=AnimationUtils.loadAnimation(requireContext(),R.anim.icon_rotate_up)
        icon_up.fillAfter=true
        icon_down.fillAfter=true // 애니매이션 후 고정




        for(i in 0..10) {
            TestItemList.add(HomeDataClass(null, "Rocky$i", "서울$i", i, "30,000", i, i))
        }
        binding.homeRv.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        binding.homeRv.adapter= HomeAdapter(requireContext(),TestItemList)

        binding.homeSearch.setOnClickListener {
            startActivity(Intent(requireContext(),SearchActivity::class.java))
        }

        binding.homeList.setOnClickListener {
            startActivity(Intent(requireContext(),HomeCategoryActivity::class.java))
        }

        binding.homeAlarm.setOnClickListener {
            startActivity(Intent(requireContext(),AlarmActivity::class.java))
        }


        binding.homeButtonPlus.setOnClickListener {
            if(Close) {
                binding.homeButtonPlus.setBackgroundColor(resources.getColor(R.color.white))
                binding.homeButtonMarketing.startAnimation(fab_open)
                binding.homeButtonPosting.startAnimation(fab_open)

                Close=false
            }else{
                binding.homeButtonPlus.setBackgroundColor(resources.getColor(R.color.carrot_color))
                binding.homeButtonMarketing.startAnimation(fab_close)
                binding.homeButtonPosting.startAnimation(fab_close)

                Close=true
            }

        }



        icon_down.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.homeIconBottomUp.setImageResource(R.drawable.bottom_icon)
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

        icon_up.setAnimationListener(object:Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.homeIconBottomUp.setImageResource(R.drawable.bottom_icon)

            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })
        binding.homeLocationAdd.setOnClickListener {
            binding.homeIconBottomUp.startAnimation(icon_down)

            var popupMenu=PopupMenu(requireContext(),it)
            MenuInflater(requireContext()).inflate(R.menu.home_popup,popupMenu.menu)
            popupMenu.menu.findItem(R.id.menu_home_location_current).title=defalt_Location
            popupMenu.menu.findItem(R.id.menu_home_location_add).title=add_Location
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
            popupMenu.setOnDismissListener {
                binding.homeIconBottomUp.startAnimation(icon_up)
            }
            popupMenu.show()
        }



    }


}