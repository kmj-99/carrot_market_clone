package com.riging_test.template.src.posting

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.posting.models.PostingRequest
import com.riging_test.template.src.posting.models.PostingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostingService(val view:PostingActivityView) {


    fun TryPostPoting(postingRequest: PostingRequest){
        val postingRetrofitInterface= ApplicationClass.sRetrofit.create(
            PostingInterface::class.java)
        postingRetrofitInterface.postTryPosting(postingRequest).enqueue(object:
            Callback<PostingResponse> {
            override fun onResponse(
                call: Call<PostingResponse>,
                response: Response<PostingResponse>
            ) {
                if(response.body()!=null){
                    view.TryPostPostingSuccess(response.body() as PostingResponse)
                }

            }

            override fun onFailure(call: Call<PostingResponse>, t: Throwable) {
                view.TryPostPostingFailue(t.message?:"통신오류")

            }

        })

    }
}