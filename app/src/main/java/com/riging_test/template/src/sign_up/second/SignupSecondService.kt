package com.riging_test.template.src.sign_up.second

import android.util.Log
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.sign_up.second.models.ArroundLocationResponse
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
                if(response.body()!=null){
                    view.TryGetLocationSuccess(response.body() as LocationResponse)
                }

            }

            override fun onFailure(call: Call<LocationResponse>, t: Throwable) {
                view.TryGetLocationFailue(t.message?:"통신오류")

            }

        })

    }

    fun tryGetAroundLocation(Jwt:String,Location:String,TownId:Int){
        val locationRetrofitInterface= ApplicationClass.sRetrofit.create(SignupSecondArroundLocationInterface::class.java)
        locationRetrofitInterface.getAroundLocation(Jwt,Location,TownId).enqueue(object:
            Callback<ArroundLocationResponse> {
            override fun onResponse(
                call: Call<ArroundLocationResponse>,
                response: Response<ArroundLocationResponse>
            ) {
                if(response.body()!=null) {
                    view.TryGetAroundLocationSuccss(response.body() as ArroundLocationResponse)
                }
            }

            override fun onFailure(call: Call<ArroundLocationResponse>, t: Throwable) {
                view.TryGetAroundLocationFailue(t.message?:"통신오류")

            }


        })



    }
}