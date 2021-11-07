package com.riging_test.template.src.main._1home

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentHomeBinding
import com.riging_test.template.src.alarm.AlarmActivity
import com.riging_test.template.src.home_category.HomeCategoryActivity
import com.riging_test.template.src.product.ProductActivity
import com.riging_test.template.src.main._1home.Rv.HomeAdapter
import com.riging_test.template.src.main._1home.Rv.HomeDataClass
import com.riging_test.template.src.my_location_setting.MyLocationSettingAcvitiy
import com.riging_test.template.src.posting.PostingActivity
import com.riging_test.template.src.search.SearchActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home){
    private var TestItemList=ArrayList<HomeDataClass>()
    private lateinit var defalt_Location:String
    private lateinit var add_Location:String

    private var Close=true
    private var Icon_Dowun=true



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        defalt_Location="서울"
        add_Location="내 동네 설정"

        var fab_open=AnimationUtils.loadAnimation(requireContext(),R.anim.fab_open)
        var fab_close=AnimationUtils.loadAnimation(requireContext(),R.anim.fab_close)


        var icon_down=AnimationUtils.loadAnimation(requireContext(),R.anim.icon_rotate_down)
        var icon_up=AnimationUtils.loadAnimation(requireContext(),R.anim.icon_rotate_up)

        var Home_Rv_Adapter=HomeAdapter(requireContext(),TestItemList)





        for(i in 0..10) {
            TestItemList.add(HomeDataClass(R.drawable.bottom_icon, "Rocky$i", "서울$i", i, "12,000", i, i))
        }
        binding.homeRv.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        binding.homeRv.adapter= Home_Rv_Adapter

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

        binding.homeButtonMarketing.setOnClickListener {
            showCustomToast("Marketing")
            binding.homeButtonMarketing.startAnimation(fab_close)
            binding.homeButtonPosting.startAnimation(fab_close)
            Close=true
        }
        binding.homeButtonPosting.setOnClickListener {
            startActivity(Intent(requireContext(),PostingActivity::class.java))


            binding.homeButtonMarketing.startAnimation(fab_close)
            binding.homeButtonPosting.startAnimation(fab_close)
            Close=true

        }


        Home_Rv_Adapter.setItemClickListener(object: HomeAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                var Product_Intent=Intent(requireActivity(),ProductActivity::class.java)

                Product_Intent.putExtra("Location",TestItemList[position].Location.toString())
                Product_Intent.putExtra("Title",TestItemList[position].Title.toString())
                Product_Intent.putExtra("Image",TestItemList[position].ImageUrl)
                Product_Intent.putExtra("Price",TestItemList[position].Price)


                startActivity(Product_Intent)

            }

        })







        binding.homeLocationAdd.setOnClickListener {
            if(Icon_Dowun) {
                binding.homeIconBottomUp.startAnimation(icon_up)
                Icon_Dowun=false
            }else{
                binding.homeIconBottomUp.startAnimation(icon_down)
                Icon_Dowun=true
            }
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
                        startActivity(Intent(requireContext(),MyLocationSettingAcvitiy::class.java))

                    }

                }
                false
            }
            popupMenu.setOnDismissListener {
                binding.homeIconBottomUp.startAnimation(icon_down)
                Icon_Dowun=true
            }
            popupMenu.show()
        }



    }

    fun dialog(){
        var dialog= Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.activity_home_float_button_bacground)
        dialog.show()
    }



}