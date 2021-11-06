package com.riging_test.template.src.home_category

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityHomeCategoryBinding
import com.riging_test.template.src.home_category.Rv.HomeCategoryAdpater
import com.riging_test.template.src.home_category.Rv.HomeCategoryDataClass

class HomeCategoryActivity: BaseActivity<ActivityHomeCategoryBinding>(ActivityHomeCategoryBinding::inflate) {
    private var CategoryList=ArrayList<HomeCategoryDataClass>()
    private var Category= arrayOf("디지털기기","인기매물","생활가전","가구/인테리어","유아동","생활/가공식품","유아도서","스포츠/레저","여성잡화",
                                "여성의류","남성패션/잡화","게임/취미","뷰티/미용","반려동물용품","도서/티켓/음반","식물","기타 중고풀품","삽니다")
    override fun onStart() {
        super.onStart()

        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        binding.homeCategoryRv.layoutManager=GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false)
        binding.homeCategoryRv.adapter=HomeCategoryAdpater(this,CategoryList)




    }


    fun init(){
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_tv_icon,"디지털기기"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_star_icon,"인기매물"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_life_product_icon,"생활가전"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.interior_icon,"가구/인테리어"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_chid_icon,"유아동"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_food_icon,"생활/가공식품"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_book_icon,"유아도서"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_sport_icon,"스포츠/레저"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_woman_stuff_icon,"여성잡화"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_woman_cloth_icon,"여성의류"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_man_cloth_icon,"남성패션/잡화"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_game_icon,"게임/취미"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_beauty_icon,"뷰티/미용"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_pet_icon,"반려동물용품"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_tiket_icon,"도서/티켓/음반"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_plant_icon,"식물"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_etc_icon,"기타 중고물품"))
        CategoryList.add(HomeCategoryDataClass(R.drawable.category_buy_icon,"삽니다"))
    }
}