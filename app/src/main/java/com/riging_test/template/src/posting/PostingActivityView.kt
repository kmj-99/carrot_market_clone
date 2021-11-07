package com.riging_test.template.src.posting

import com.riging_test.template.src.posting.models.PostingResponse

interface PostingActivityView {

    fun TryPostPostingSuccess(response: PostingResponse)
    fun TryPostPostingFailue(message:String)

}