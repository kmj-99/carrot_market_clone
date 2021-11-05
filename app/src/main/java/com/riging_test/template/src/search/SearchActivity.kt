package com.riging_test.template.src.search

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivitySearchBinding
import com.riging_test.template.databinding.ActivitySignupBinding
import com.riging_test.template.src.search.Rv.SearchAdapter
import com.riging_test.template.src.search.Rv.SearchDataClass
import javax.net.ssl.SSLEngineResult

class SearchActivity: BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate) {
    private var CategoryList=ArrayList<SearchDataClass>()

    override fun onStart() {
        super.onStart()
        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CategoryList.add(SearchDataClass("스파크"))
        CategoryList.add(SearchDataClass("파세코"))
        CategoryList.add(SearchDataClass("이사"))
        CategoryList.add(SearchDataClass("유록스"))
        CategoryList.add(SearchDataClass("강아지분양"))

        binding.searchRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.searchRv.adapter=SearchAdapter(CategoryList)

        binding.searchButtonBack.setOnClickListener {
            finish()
        }


    }
}