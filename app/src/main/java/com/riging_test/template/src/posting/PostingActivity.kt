package com.riging_test.template.src.posting

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityPostingBinding
import com.riging_test.template.src.posting.Rv.PostingImageAdapter
import com.riging_test.template.src.posting.Rv.PostingImageDataClass
import com.riging_test.template.src.sign_up.second.SignupRvAdapter

class PostingActivity: BaseActivity<ActivityPostingBinding>(ActivityPostingBinding::inflate) {
    private var REQUEST_CODE=2222

    private var ImageList=ArrayList<PostingImageDataClass>()

    override fun onStart() {
        super.onStart()
        window.statusBarColor = Color.TRANSPARENT

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding.postingEditPrice.addTextChangedListener(object: TextWatcher {
            //Text를 입력하기 전
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            //Text가 변경 될때
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(start>0){
                    Glide.with(applicationContext).load(R.drawable.select_won).into(binding.postingImageEditText)
                    Glide.with(applicationContext).load(R.drawable.select_check).into(binding.postingImageCheck)
                }else{
                    Glide.with(applicationContext).load(R.drawable.select_no_won).into(binding.postingImageEditText)
                    Glide.with(applicationContext).load(R.drawable.select_no_check).into(binding.postingImageCheck)
                }

            }

            //Text 입력이 모두 끝났을 때
            override fun afterTextChanged(s: Editable?) {
            }

        })

        binding.postingLayoutCategory.setOnClickListener {

        }

        binding.postingLayoutImageNumbers.setOnClickListener {
            var image_intent=Intent(Intent.ACTION_PICK)
            image_intent.setType(MediaStore.Images.Media.CONTENT_TYPE)
            image_intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true)
            startActivityForResult(image_intent,REQUEST_CODE)
        }

        binding.postingButtonBack.setOnClickListener {
            finish()
        }


    }

    // 앨범에서 이미지를 가져옴
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(data==null){
            showCustomToast("이미지를 선택하지 않았습니다")
        }else{
            if(data.clipData==null){
                ImageList.add(PostingImageDataClass(data.data))
                binding.postingRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                binding.postingRv.adapter=PostingImageAdapter(this,ImageList)
            }else{
                var clipData=data.clipData

                if(clipData!!.itemCount>10){
                    showCustomToast("사진은 10장까지만 선택 가능합니다.")
                }else{
                    for(i in 0 until  clipData.itemCount){
                        ImageList.add(PostingImageDataClass(clipData.getItemAt(i).uri))
                    }
                }
                var postingImageAdapter=PostingImageAdapter(this,ImageList)

                binding.postingTextImageNumbers.text=clipData.itemCount.toString()+"/"
                binding.postingRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                binding.postingRv.adapter=postingImageAdapter
                postingImageAdapter.setItemClickListener(object: PostingImageAdapter.OnItemClickListener{
                    @SuppressLint("NotifyDataSetChanged")
                    override fun onClick(v: View, position: Int) {
                        ImageList.removeAt(position)
                        // List 반영
                        postingImageAdapter.notifyDataSetChanged()
                        binding.postingTextImageNumbers.text=ImageList.size.toString()+"/"

                    }

                })

            }
        }
    }


}