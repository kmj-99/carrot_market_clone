package com.riging_test.template.src.test.search.models

data class SearchImageResponse(
    val display: Int,
    val items: List<ItemX>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)