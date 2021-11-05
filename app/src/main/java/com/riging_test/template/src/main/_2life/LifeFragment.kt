package com.riging_test.template.src.main._2life

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentLifeBinding
import com.riging_test.template.src.life_posting.LifePostingActivity
import com.riging_test.template.src.main._2life.Rv1.LifeKeywordAdapter
import com.riging_test.template.src.main._2life.Rv1.LifeKeywordDataClass
import com.riging_test.template.src.main._2life.Rv2.LifePostingAdapter
import com.riging_test.template.src.main._2life.Rv2.LifePostingDataClass

class LifeFragment: BaseFragment<FragmentLifeBinding>(FragmentLifeBinding::bind, R.layout.fragment_life) {
    private var TestItemList=ArrayList<LifeKeywordDataClass>()
    private var TestItemList2=ArrayList<LifePostingDataClass>()

    private lateinit var defalt_Location:String
    private lateinit var add_Location:String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var icon_down= AnimationUtils.loadAnimation(requireContext(),R.anim.icon_rotate_down)
        var icon_up= AnimationUtils.loadAnimation(requireContext(),R.anim.icon_rotate_up)
        icon_up.fillAfter=true
        icon_down.fillAfter=true // 애니매이션 후 고정

        defalt_Location="소흘읍"
        add_Location="내 동네 추가하기"


        TestItemList.add(LifeKeywordDataClass(R.drawable.share_icon,null))

        TestItemList.add(LifeKeywordDataClass(null, "우리동네질문"))
        TestItemList.add(LifeKeywordDataClass(null, "동네맛짐"))
        TestItemList.add(LifeKeywordDataClass(null, "해주세요"))
        TestItemList.add(LifeKeywordDataClass(null, "동네소식"))
        TestItemList.add(LifeKeywordDataClass(null, "분실/실종센터"))
        TestItemList.add(LifeKeywordDataClass(null, "동네사건사고"))
        TestItemList.add(LifeKeywordDataClass(null, "일상"))
        TestItemList.add(LifeKeywordDataClass(null, "취미생활"))
        TestItemList.add(LifeKeywordDataClass(null, "고양이"))
        TestItemList.add(LifeKeywordDataClass(null, "강아지"))
        TestItemList.add(LifeKeywordDataClass(null, "건강"))
        TestItemList.add(LifeKeywordDataClass(null, "살림"))
        TestItemList.add(LifeKeywordDataClass(null, "인테리어"))
        TestItemList.add(LifeKeywordDataClass(null, "교육/학원"))
        TestItemList.add(LifeKeywordDataClass(null, "동네사진전"))
        TestItemList.add(LifeKeywordDataClass(null, "출산/육아"))
        TestItemList.add(LifeKeywordDataClass(null, "기타"))

        binding.lifeRv1.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.lifeRv1.adapter= LifeKeywordAdapter(requireContext(),TestItemList)
        for(i in 0..10) {
            TestItemList2.add(
                LifePostingDataClass(
                    "기타$i",
                    "Rocky$i",
                    R.drawable.carrot_image,
                    "Content$i",
                    "Location$i",
                    27
                )
            )
        }
        binding.lifeRv2.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.lifeRv2.adapter=LifePostingAdapter(requireContext(),TestItemList2)



        icon_down.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.lifeIconBottomUp.setImageResource(R.drawable.bottom_icon)
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

        icon_up.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.lifeIconBottomUp.setImageResource(R.drawable.bottom_icon)

            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

        binding.lifeLocationAdd.setOnClickListener {

                binding.lifeIconBottomUp.startAnimation(icon_down)


            var popupMenu= PopupMenu(requireContext(),it)
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
                binding.lifeIconBottomUp.startAnimation(icon_up)

            }
            popupMenu.show()

        }

        binding.lifeButtonWriting.setOnClickListener {
            startActivity(Intent(requireActivity(),LifePostingActivity::class.java))
        }
    }
}