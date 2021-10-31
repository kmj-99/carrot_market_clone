package com.riging_test.template.src.sign_up.second

import android.util.Log
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.sign_up.second.models.LocationResponse
import com.riging_test.template.src.test.search.models.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupSecondService(val view:SignupSecondFragmentView) {

    fun TryGetLocation(Client_Id:String,Client_Pw:String,request:String,coords:String,sourcecrs:String,output:String,orders:String){
        val locationRetrofitInterface= ApplicationClass.NaverGeoRetrofit.create(SignupSecondLocationInterace::class.java)
        locationRetrofitInterface.getLocation(Client_Id,Client_Pw,request,coords,sourcecrs,output,orders).enqueue(object:
            Callback<LocationResponse> {
            override fun onResponse(
                call: Call<LocationResponse>,
                response: Response<LocationResponse>
            ) {
                view.TryGetLocationSuccess(response.body() as LocationResponse)

            }

            override fun onFailure(call: Call<LocationResponse>, t: Throwable) {
                Log.d("TryGetLocation","1")

                view.TryGetLocationFailue(t.message?:"통신오류")

            }

        })

    }
}