package com.riging_test.template.src.sign_up.second

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentSignupSecondBinding
import com.riging_test.template.src.sign_up.second.models.LocationResponse
import com.riging_test.template.src.sign_up.third.SignThirdFragment

class SignupSecondFragment: BaseFragment<FragmentSignupSecondBinding>(FragmentSignupSecondBinding::bind, R.layout.fragment_signup_second),SignupSecondFragmentView {
    private var TestList=ArrayList<SignupRvDataClass>()
    private lateinit var recyclerViewState:Parcelable

    private var ThirdFragment=SignThirdFragment()

    private val Client_Id="etlmjycr7q"
    private val Client_Pw="UjxCnfxNahnQM9sQN5TFOYn4F9qrYaogNB3RND3D"
    private val Test_request="coordsToaddr"
    private val Test_coords="127.1408536,37.8295577"
    private val Test_sourcecrs="epsg:4326"
    private val Test_output="json"
    private val Test_orders="legalcode"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.searchImageSearch.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY


        var Loading=SignupSecondLoadingDialog(requireContext())
        var Rv=binding.signupSecondRv
        var Rv_Adapter=SignupRvAdapter(TestList)

        binding.signupSecondResultNo.visibility=View.VISIBLE
        binding.signupSecondRv.visibility=View.INVISIBLE
        Loading.show()

        TestList.add(SignupRvDataClass("경기도"))
        TestList.add(SignupRvDataClass("서울"))
        TestList.add(SignupRvDataClass("충남"))
        TestList.add(SignupRvDataClass("충북"))
        TestList.add(SignupRvDataClass("전남"))
        TestList.add(SignupRvDataClass("전북"))
        TestList.add(SignupRvDataClass("제주"))
        TestList.add(SignupRvDataClass("울산"))
        TestList.add(SignupRvDataClass("인천"))
        TestList.add(SignupRvDataClass("부산"))
        TestList.add(SignupRvDataClass("광주"))
        TestList.add(SignupRvDataClass("수원"))


//        recyclerViewState=Rv.layoutManager!!.onSaveInstanceState()!!
        Rv.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        Rv.adapter=Rv_Adapter


        Loading.dismiss()

        // 리사이클러뷰의 마지막 위치감지를 위한 코드
        Rv.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                var lastVisibleItemPosition = (recyclerView!!.getLayoutManager() as LinearLayoutManager).findLastCompletelyVisibleItemPosition();
                var itemTotalCount = recyclerView.getAdapter()!!.getItemCount() - 1;

                if(lastVisibleItemPosition==itemTotalCount){
                    showCustomToast("Last")
                }

            }

        })



        Rv_Adapter.setItemClickListener(object:SignupRvAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {

                var bundle=Bundle()
                bundle.putString("Location",TestList[position].Location.toString())
                ThirdFragment.arguments=bundle
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.signup_layout,ThirdFragment)
                    ?.commitAllowingStateLoss()
            }

        })


        binding.signupSecondRv.visibility=View.VISIBLE
        binding.signupSecondResultNo.visibility=View.INVISIBLE

        SignupSecondService(this).TryGetLocation(Client_Id,Client_Pw,Test_request,Test_coords,Test_sourcecrs ,Test_output , Test_orders)


    }



    override fun TryGetLocationSuccess(response: LocationResponse) {
        showCustomToast(response.results[0].region.area1.name)
    }

    override fun TryGetLocationFailue(message: String) {
        showCustomToast(message)

    }

}