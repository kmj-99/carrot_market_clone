package com.riging_test.template.src.posting

import com.riging_test.template.src.posting.models.PostingRequest
import com.riging_test.template.src.posting.models.PostingResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PostingInterface {

    @POST("post")
    fun postTryPosting(@Body parms: PostingRequest): Call<PostingResponse>
}