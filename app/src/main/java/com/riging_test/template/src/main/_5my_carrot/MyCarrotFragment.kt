package com.riging_test.template.src.main._5my_carrot

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentMyCarrotBinding
import com.riging_test.template.src.main._5my_carrot.Rv.MyCarrotAdapter
import com.riging_test.template.src.main._5my_carrot.Rv.MyCarrotDataClass
import com.riging_test.template.src.my_carrot_sales_history.SalesHistoryActivity
import com.riging_test.template.src.my_profile.MyProfileActivity

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



        TestList.add(MyCarrotDataClass(R.drawable.my_carrot_location,"내 동네 설정"))
        TestList.add(MyCarrotDataClass(R.drawable.my_carrot_certification2,"동네 인증하기"))
        TestList.add(MyCarrotDataClass(R.drawable.my_carrot_keyword,"키워드 알림"))
        TestList.add(MyCarrotDataClass(R.drawable.my_carrot_bills,"당근가계부"))
        TestList.add(MyCarrotDataClass(R.drawable.my_carrot_see_all,"모아보기"))
        TestList.add(MyCarrotDataClass(R.drawable.my_carrot_caterory,"관심 카테고리 설정"))


        binding.myCarrotRv1.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myCarrotRv1.adapter=MyCarrotAdapter(requireContext(),TestList)




        TestList2.add(MyCarrotDataClass(R.drawable.my_carrot_life_posting,"동내생활 글"))
        TestList2.add(MyCarrotDataClass(R.drawable.my_carrot_comment,"동네생활 댓글"))
        TestList2.add(MyCarrotDataClass(R.drawable.my_carrot_life_topic_list,"동네생활 주제 목록"))

        binding.myCarrotRv2.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myCarrotRv2.adapter=MyCarrotAdapter(requireContext(),TestList2)



        TestList3.add(MyCarrotDataClass(R.drawable.my_carrot_beads_profile,"비즈프로필 만들기"))
        TestList3.add(MyCarrotDataClass(R.drawable.my_carrot_promotion,"동내홍보 글"))
        TestList3.add(MyCarrotDataClass(R.drawable.my_carrot_promotion_around,"지역광고"))

        binding.myCarrotRv3.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myCarrotRv3.adapter=MyCarrotAdapter(requireContext(),TestList3)



        TestList4.add(MyCarrotDataClass(R.drawable.my_carrot_freinds_invit,"친구초대"))
        TestList4.add(MyCarrotDataClass(R.drawable.my_carrot_share,"당근마켓 공유"))
        TestList4.add(MyCarrotDataClass(R.drawable.my_carrot_news,"공지사항"))
        TestList4.add(MyCarrotDataClass(R.drawable.my_carrot_question,"자주 묻는 질문"))


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