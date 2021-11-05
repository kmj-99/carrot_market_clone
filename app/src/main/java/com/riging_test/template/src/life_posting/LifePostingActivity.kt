package com.riging_test.template.src.life_posting

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityLifePostingBinding
import com.riging_test.template.src.life_posting.Rv.LifePostingAdapter
import com.riging_test.template.src.life_posting.Rv.LifePostingDataClass

class LifePostingActivity: BaseActivity<ActivityLifePostingBinding>(ActivityLifePostingBinding::inflate) {
    private var ImageList=ArrayList<LifePostingDataClass>()
    private val REQUEST_CODE=3333

    override fun onStart() {
        super.onStart()
        window.statusBarColor = Color.TRANSPARENT
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifePostingImageGallery.setOnClickListener {
            var image_intent=Intent(Intent.ACTION_PICK)
            image_intent.setType(MediaStore.Images.Media.CONTENT_TYPE)
            image_intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true)
            startActivityForResult(image_intent,REQUEST_CODE)
        }

        binding.lifePostingImageLocation.setOnClickListener {
            showCustomToast("아직 구현 안함")
        }

    }




    // 앨범에서 이미지를 가져옴
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(data==null){
            showCustomToast("이미지를 선택하지 않았습니다")
        }else{
            if(data.clipData==null){
                ImageList.add(LifePostingDataClass(data.data))
                binding.lifePostingRv.layoutManager=
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
                binding.lifePostingRv.adapter= LifePostingAdapter(this,ImageList)
            }else{
                var clipData=data.clipData

                if(clipData!!.itemCount>10){
                    showCustomToast("사진은 10장까지만 선택 가능합니다.")
                }else{
                    for(i in 0 until  clipData.itemCount){
                        ImageList.add(LifePostingDataClass(clipData.getItemAt(i).uri))
                    }
                }
                var lifePostingAdapter= LifePostingAdapter(this,ImageList)

                binding.lifePostingTextGalleryCount.text=clipData.itemCount.toString()
                binding.lifePostingRv.layoutManager=
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
                binding.lifePostingRv.adapter=lifePostingAdapter
                lifePostingAdapter.setItemClickListener(object: LifePostingAdapter.OnItemClickListener{
                    @SuppressLint("NotifyDataSetChanged")
                    override fun onClick(v: View, position: Int) {
                        ImageList.removeAt(position)
                        // List 반영
                        lifePostingAdapter.notifyDataSetChanged()
                        binding.lifePostingTextGalleryCount.text=ImageList.size.toString()

                    }

                })

            }
        }
    }

}