package com.riging_test.template.src.main._2life

import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentLifeBinding
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

        defalt_Location="소흘읍"
        add_Location="내 동네 추가하기"


        TestItemList.add(LifeKeywordDataClass(R.drawable.share_icon,null))
        for(i in 0..10) {
            TestItemList.add(LifeKeywordDataClass(null, "TestKeyword$i"))
        }

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


        binding.lifeLocationAdd.setOnClickListener {

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
            popupMenu.show()
        }
    }
}