package com.riging_test.template.src.main._5my_carrot

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentHomeBinding
import com.riging_test.template.databinding.FragmentMyCarrotBinding
import com.riging_test.template.src.main._5my_carrot.Rv.MyCarrotAdapter
import com.riging_test.template.src.main._5my_carrot.Rv.MyCarrotDataClass
import com.riging_test.template.src.main._5my_carrot.Rv.MyCarrotViewType
import com.riging_test.template.src.my_carrot_sales_history.SalesHistoryActivity
import com.riging_test.template.src.my_profile.MyProfileActivity
import kotlinx.android.synthetic.main.fragment_signup_second.*

class MyCarrotFragment : BaseFragment<FragmentMyCarrotBinding>(FragmentMyCarrotBinding::bind, R.layout.fragment_my_carrot){
    private var TestList=ArrayList<MyCarrotDataClass>()
    private var TestList2=ArrayList<MyCarrotDataClass>()
    private var TestList3=ArrayList<MyCarrotDataClass>()
    private var TestList4=ArrayList<MyCarrotDataClass>()

    private lateinit var nickName:String
    private lateinit var phoneNumber:String
    private lateinit var location:String
    private lateinit var profileImage:String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let {
            if(it?.getString("NickName")==null){
                nickName="김민중"
            }else{
                nickName=it.getString("NickName")!!
            }

            if(it?.getString("PhoneNumber")==null){
                phoneNumber="00000000"
            }else{
                phoneNumber=it.getString("PhoneNumber")!!
            }

            if(it?.getString("Location")==null){
                location="경기도 포천시 소흘읍 송우리"
            }else{
                location=it.getString("Location")!!
            }

            if(it?.getString("ProfileImage")==null){
                profileImage="ds"
            }else{
                profileImage=it.getString("ProfileImage")!!

            }
        }

        var location_List=location.split(" ")
        binding.myCarrotTextNickName.text=nickName
        binding.myCarrotTextLocation.text=location_List[2]
        showCustomToast(nickName+phoneNumber+location+profileImage)



        for(i in 0..5){
            TestList.add(MyCarrotDataClass(R.drawable.certification_image,"Content1 $i"))
        }

        binding.myCarrotRv1.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myCarrotRv1.adapter=MyCarrotAdapter(requireContext(),TestList)

        for(i in 0..5){
            TestList2.add(MyCarrotDataClass(R.drawable.carrot_image,"Content2 $i"))
        }

        binding.myCarrotRv2.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myCarrotRv2.adapter=MyCarrotAdapter(requireContext(),TestList2)
        for(i in 0..5){
            TestList3.add(MyCarrotDataClass(R.drawable.document_image,"Content3 $i"))
        }

        binding.myCarrotRv3.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myCarrotRv3.adapter=MyCarrotAdapter(requireContext(),TestList3)
        for(i in 0..5){
            TestList4.add(MyCarrotDataClass(R.drawable.share_icon,"Content4 $i"))
        }

        binding.myCarrotRv4.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myCarrotRv4.adapter=MyCarrotAdapter(requireContext(),TestList4)


        binding.myCarrotLayoutProfile.setOnClickListener {
            var Profile_Intent=Intent(requireActivity(),MyProfileActivity::class.java)

            Profile_Intent.putExtra("NickName",nickName)
            startActivity(Profile_Intent)

        }

        binding.myCarrotImageSale.setOnClickListener {
            startActivity(Intent(requireActivity(),SalesHistoryActivity::class.java))
        }

    }
}