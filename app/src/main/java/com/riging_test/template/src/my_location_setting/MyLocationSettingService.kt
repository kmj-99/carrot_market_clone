package com.riging_test.template.src.my_location_setting

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.my_location_setting.models.AroundTownResponse
import com.riging_test.template.src.my_location_setting.models.ChangeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyLocationSettingService(val view:MyLocationSettingView) {

    fun TryGetAroundTown(townId:Int){
        val aroundTownRetrofitInterface= ApplicationClass.sRetrofit.create(MyLocationSettingInterface::class.java)
        aroundTownRetrofitInterface.getAroundTown(townId).enqueue(object:
            Callback<AroundTownResponse> {
            override fun onResponse(
                call: Call<AroundTownResponse>,
                response: Response<AroundTownResponse>
            ) {
                view.onAroundTownSuccess(response.body() as AroundTownResponse)
            }

            override fun onFailure(call: Call<AroundTownResponse>, t: Throwable) {
                view.onAroundTownFailure(t.message ?: "통신 오류")
            }

        })

    }


    fun TryPatchChangeRange(jwt:String,townId:Int,range:Int){
        val changeRangeRetrofitInterface= ApplicationClass.sRetrofit.create(MyLocationSettingRangeChangeInterface::class.java)
        changeRangeRetrofitInterface.patchRange(jwt,townId,range).enqueue(object:
            Callback<ChangeResponse> {
            override fun onResponse(
                call: Call<ChangeResponse>,
                response: Response<ChangeResponse>
            ) {
                view.onChangeRangeSuccess(response.body() as ChangeResponse)
            }

            override fun onFailure(call: Call<ChangeResponse>, t: Throwable) {
                view.onChangeRangeFailure(t.message ?: "통신 오류")
            }

        })

    }
}