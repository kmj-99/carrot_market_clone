package com.riging_test.template.src.posting

import com.riging_test.template.src.posting.models.PostingImageRequest
import com.riging_test.template.src.posting.models.PostingImageResponse
import com.riging_test.template.src.posting.models.PostingRequest
import com.riging_test.template.src.posting.models.PostingResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PostingImageInterface {
    @POST("post/image")
    fun postImageTryPosting(@Body parms: PostingImageRequest): Call<PostingImageResponse>
}