package com.riging_test.template.src.sign_up.second

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.sign_up.second.models.AroundLocationResponse
import com.riging_test.template.src.sign_up.second.models.ArroundLocationTownId
import com.riging_test.template.src.sign_up.second.models.LocationResponse
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

    fun tryGetTownId(City:String,District:String,TownName:String){
        val locationRetrofitInterface= ApplicationClass.sRetrofit.create(SignupSecondTownIdInterface::class.java)
        locationRetrofitInterface.getTownId(City,District,TownName).enqueue(object:
            Callback<ArroundLocationTownId> {
            override fun onResponse(
                call: Call<ArroundLocationTownId>,
                response: Response<ArroundLocationTownId>
            ) {
                if(response.body()!=null) {
                    view.TryGetTownIdSuccss(response.body() as ArroundLocationTownId)
                }
            }

            override fun onFailure(call: Call<ArroundLocationTownId>, t: Throwable) {
                view.TryGetTownFailue(t.message?:"통신오류")

            }


        })

    }


    fun tryGetAroundLocation(TownId:Int){

        val locationRetrofitInterface= ApplicationClass.sRetrofit.create(SignupSecondAroundLocationInterface::class.java)
        locationRetrofitInterface.getAroundLocation(TownId).enqueue(object:
            Callback<AroundLocationResponse> {
            override fun onResponse(
                call: Call<AroundLocationResponse>,
                response: Response<AroundLocationResponse>
            ) {
                    view.TryGetAroundLocationSuccss(response.body() as AroundLocationResponse)
            }

            override fun onFailure(call: Call<AroundLocationResponse>, t: Throwable) {
                view.TryGetAroundLocationFailue(t.message?:"통신오류")
            }


        })

    }
}