package com.riging_test.template.src.sign_up.second

import android.app.Activity
import android.app.FragmentManager
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.naver.maps.geometry.LatLng
import com.naver.maps.geometry.Tm128
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.MapFragment
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.util.FusedLocationSource
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentSignupSecondBinding
import com.riging_test.template.src.sign_up.SignActivity
import com.riging_test.template.src.sign_up.second.models.ArroundLocationResponse
import com.riging_test.template.src.sign_up.second.models.LocationResponse
import com.riging_test.template.src.sign_up.third.SignThirdFragment
import com.riging_test.template.src.test.Test

class SignupSecondFragment: BaseFragment<FragmentSignupSecondBinding>(FragmentSignupSecondBinding::bind, R.layout.fragment_signup_second),SignupSecondFragmentView {
    private var TestList=ArrayList<SignupRvDataClass>()
    private lateinit var recyclerViewState:Parcelable

    private val PERMISSION_REQUEST_CODE=100
    private var Current_Location=""

    private var ThirdFragment=SignThirdFragment()

    private val Client_Id="etlmjycr7q"
    private val Client_Pw="UjxCnfxNahnQM9sQN5TFOYn4F9qrYaogNB3RND3D"
    private val Test_request="coordsToaddr"
    private var Test_coords="127.1408536,37.8295577"
    private val Test_sourcecrs="epsg:4326"
    private val Test_output="json"
    private val Test_orders="legalcode"

    private val Jwt="eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWQiOjIxLCJpYXQiOjE2MzU5NTUyMDQsImV4cCI6MTYzNzQyNjQzM30.ZLVXRR6MZO3d9P0oyWMXJnPhdQ-H9xyGHwfCsgT-vZI"
    private val TownId=5200

    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var Rv:View
    private lateinit var Rv_Adapter:SignupRvAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.searchImageSearch.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY

        sharedPreferences=requireActivity().getSharedPreferences("Token", MODE_PRIVATE)




        Rv=binding.signupSecondRv
        Rv_Adapter=SignupRvAdapter(TestList)

        binding.signupSecondResultNo.visibility=View.VISIBLE
        binding.signupSecondRv.visibility=View.INVISIBLE



        // 리사이클러뷰의 마지막 위치감지를 위한 코드
        (Rv as RecyclerView).addOnScrollListener(object : RecyclerView.OnScrollListener(){
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




        // 현재 위치 받아오는 api
        val mapFragment= requireFragmentManager().findFragmentById(R.id.Map1) as MapFragment?
            ?: MapFragment.newInstance().also{
                requireFragmentManager().beginTransaction().add(R.id.Map1,it).commit()
            }
        val Test_Location= LatLng(37.56661020000001,126.97838810000002)


        mapFragment.getMapAsync{
            val marker= Marker()
            marker.position= Test_Location
            marker.map=it

            val cameraUpdata= CameraUpdate.scrollTo(Test_Location)
            it.moveCamera(cameraUpdata)

            var mLocationSource= FusedLocationSource(context as Activity,PERMISSION_REQUEST_CODE)

            var PERMISSIONS= arrayOf<String>(android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION)

            it.locationSource=mLocationSource

            ActivityCompat.requestPermissions(context as Activity, PERMISSIONS,PERMISSION_REQUEST_CODE)

            it.locationTrackingMode= LocationTrackingMode.Follow
            var locationOverlay=it.locationOverlay
            locationOverlay.isVisible=true


            it.addOnLocationChangeListener { location ->
                Log.d( "Current_Location","${location.latitude}, ${location.longitude}")
                Current_Location="${location.longitude},${location.latitude}"
            }

        }

        // 죄표를 지역으로 바꾸는 api
        binding.signupSecondCurrentLocationFind.setOnClickListener {
            Log.d("Test_coords",Test_coords)
            //Test_coords가 현재 위치이고 이걸 서버쪽에 보내서 주변 반경에 있는 지역을 받으면된다.
            showLoading(requireContext())
            SignupSecondService(this).TryGetLocation(Client_Id,Client_Pw,Test_request,Current_Location,Test_sourcecrs ,Test_output , Test_orders)


        }

    }



    override fun TryGetLocationSuccess(response: LocationResponse) {
        Test_coords=response.results[0].region.area3.name
        Log.d("Arround_Location",Test_coords)


        SignupSecondService(this).tryGetAroundLocation(Jwt,Test_coords,TownId)

        Log.d("TryGetLocationSuccess",Test_coords)
    }

    override fun TryGetLocationFailue(message: String) {
        if(message!=null) {
            showCustomToast(message)
        }

    }

    override fun TryGetAroundLocationSuccss(response: ArroundLocationResponse) {
        var location_stream=""

        //받아온 데이터 파싱작업
        for(i in response.result[0].etc){
            if(i.toString()=="," || i.toString()==" ") {

                if(location_stream.length!=0) {
                    TestList.add(SignupRvDataClass(location_stream))
                    location_stream=""
                }
            }

            if(i.toString()!=","&& i.toString()!=" ") {
                location_stream=location_stream+"$i"
            }
        }

        for(i in TestList){
            Log.d("Arround_Location",i.Location.toString())
        }





        (Rv as RecyclerView).layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        (Rv as RecyclerView).adapter=Rv_Adapter

        binding.signupSecondRv.visibility=View.VISIBLE
        binding.signupSecondResultNo.visibility=View.INVISIBLE



        dismissLoading()

    }

    override fun TryGetAroundLocationFailue(message: String) {

    }

}