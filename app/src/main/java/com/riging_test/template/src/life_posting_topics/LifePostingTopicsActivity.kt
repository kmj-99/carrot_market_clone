package com.riging_test.template.src.life_posting_topics

import android.graphics.Color
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityLifePostingBinding
import com.riging_test.template.databinding.ActivityLifePostingTopicsBinding
import com.riging_test.template.src.life_posting_topics.Rv.LifePostingTopicAdapter
import com.riging_test.template.src.life_posting_topics.Rv.LifePostingTopicDataClass

class LifePostingTopicsActivity: BaseActivity<ActivityLifePostingTopicsBinding>(ActivityLifePostingTopicsBinding::inflate) {
    private var Basic_TopicList=ArrayList<LifePostingTopicDataClass>()
    private var Favorite_TopicList=ArrayList<LifePostingTopicDataClass>()

    override fun onStart() {
        super.onStart()
        window.statusBarColor = Color.TRANSPARENT

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Basic_TopicList.add(LifePostingTopicDataClass("우리동네질문"))
        Basic_TopicList.add(LifePostingTopicDataClass("동네사건사고"))

        binding.lifePostingTopicRv1.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.lifePostingTopicRv1.adapter=LifePostingTopicAdapter(Basic_TopicList)

        Favorite_TopicList.add(LifePostingTopicDataClass("동네맛집"))
        Favorite_TopicList.add(LifePostingTopicDataClass("해주세요"))
        Favorite_TopicList.add(LifePostingTopicDataClass("동네소식"))
        Favorite_TopicList.add(LifePostingTopicDataClass("분실/실종센터"))
        Favorite_TopicList.add(LifePostingTopicDataClass("일상"))
        Favorite_TopicList.add(LifePostingTopicDataClass("취미생활"))
        Favorite_TopicList.add(LifePostingTopicDataClass("고양이"))
        Favorite_TopicList.add(LifePostingTopicDataClass("강아지"))
        Favorite_TopicList.add(LifePostingTopicDataClass("건강"))
        Favorite_TopicList.add(LifePostingTopicDataClass("살림"))
        Favorite_TopicList.add(LifePostingTopicDataClass("인테리어"))
        Favorite_TopicList.add(LifePostingTopicDataClass("교육/학원"))
        Favorite_TopicList.add(LifePostingTopicDataClass("동네사진전"))
        Favorite_TopicList.add(LifePostingTopicDataClass("출산/육아"))
        Favorite_TopicList.add(LifePostingTopicDataClass("기타"))

        binding.lifePostingTopicRv2.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.lifePostingTopicRv2.adapter=LifePostingTopicAdapter(Favorite_TopicList)

    }
}