package com.riging_test.template.src.test.search

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentSearchBinding
import com.riging_test.template.src.test.search.models.SearchImageResponse
import com.riging_test.template.src.test.search.models.SearchResponse

class SearchFragment :BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search),SearchFragmentView{
    private val Client_Id="dhXEre4XYgG7_kYIwNfR"
    private val Client_Pw="SsBk5KjKd8"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bundle=Bundle()


        Log.d("Search_Fragment_onViewCreated","1")
        binding.searchButtonSearch.setOnClickListener {
            var SearchContent=binding.searchEdit.text.toString()
            showLoadingDialog(requireContext())
            SearchService(this).TryGetSearch(Client_Id,Client_Pw,SearchContent,1,1)

        }
        binding.searchButtonSearchImage.setOnClickListener {
            var SearchImageContent=binding.searchEdit.text.toString()
            showLoadingDialog(requireContext())
            SearchService(this).TryGetImageSearch(Client_Id,Client_Pw,SearchImageContent,1,1)
        }
        binding.testButton.setOnClickListener {
            //이미지 어둡게
            binding.searchImageSearch.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY)

        }
    }

    override fun TryGetSearchSuccess(response: SearchResponse) {
        dismissLoadingDialog()
        binding.searchText.text=response.items[0].title

    }

    override fun TryGetSearchFaliue(message: String) {
        dismissLoadingDialog()
        Toast.makeText(requireActivity(),"Error : $message" ,Toast.LENGTH_LONG).show()
    }

    override fun TryGetSearchImageSuccess(response: SearchImageResponse) {
        dismissLoadingDialog()
        Glide.with(requireContext()).load(response.items[0].link).into(binding.searchImageSearch)
    }

    override fun TryGetSearchImageFaliue(message: String) {
        Toast.makeText(requireContext(),"Error : $message",Toast.LENGTH_LONG).show()
    }


}