package com.riging_test.template.src.test.search

import com.riging_test.template.src.test.search.models.SearchImageResponse
import com.riging_test.template.src.test.search.models.SearchResponse

interface SearchFragmentView {

    fun TryGetSearchSuccess(response:SearchResponse)
    fun TryGetSearchFaliue(message:String)

    fun TryGetSearchImageSuccess(response:SearchImageResponse)
    fun TryGetSearchImageFaliue(message:String)
}