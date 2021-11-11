package com.riging_test.template.src.posting

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityPostingBinding
import com.riging_test.template.src.posting.Rv.PostingImageAdapter
import com.riging_test.template.src.posting.Rv.PostingImageDataClass
import com.riging_test.template.src.posting.models.PostingImageRequest
import com.riging_test.template.src.posting.models.PostingImageResponse
import com.riging_test.template.src.posting.models.PostingRequest
import com.riging_test.template.src.posting.models.PostingResponse
import com.riging_test.template.src.sign_up.second.SignupRvAdapter

class PostingActivity: BaseActivity<ActivityPostingBinding>(ActivityPostingBinding::inflate),PostingActivityView {
    private var REQUEST_CODE=2222

    private var ImageList=ArrayList<PostingImageDataClass>()

    private var UriList=ArrayList<Uri>()

    private val userId=sSharedPreferences.getInt("userId",1)
    private val townId= sSharedPreferences.getInt("townId",1)

    private lateinit var storage: FirebaseStorage
    private lateinit var storageRef: StorageReference
    private lateinit var riverRef:StorageReference
    private lateinit var uploadTask:UploadTask
    private var categoryId=0

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
                    binding.postingTextProposePrice.setTextColor(resources.getColor(R.color.black))
                }else{
                    Glide.with(applicationContext).load(R.drawable.select_no_won).into(binding.postingImageEditText)
                    Glide.with(applicationContext).load(R.drawable.select_no_check).into(binding.postingImageCheck)
                    binding.postingTextProposePrice.setTextColor(resources.getColor(R.color.light_light_light_gray))

                }

            }

            //Text 입력이 모두 끝났을 때
            override fun afterTextChanged(s: Editable?) {


            }

        })




        binding.postingLayoutCategory.setOnClickListener {
            showListDialog()

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

        binding.postingButtonFinish.setOnClickListener {
            if(binding.postingEditTitle.toString()==null){
                showCustomToast("제목을 입력하세요")
            }else if( binding.postingEditPrice.toString()==null){
                showCustomToast("가격을 입력하세요")
            }else if(binding.postingEditContent.toString()==null){
                showCustomToast("내용을 입력하세요")
            }else {

                Log.d("certification","${binding.postingEditTitle.text} ${binding.postingEditPrice.text} ${binding.postingEditContent.text}")
                PostingService(this).TryPostPoting(
                    PostingRequest(
                        userId = userId,
                        townId = townId,
                        title = binding.postingEditTitle.text.toString(),
                        categoryId =categoryId+1 ,
                        cost =binding.postingEditPrice.text.toString().toInt(),
                        content = binding.postingEditContent.text.toString()
                    )
                )
                finish()
            }
        }


    }


    fun showListDialog(){
        var category=resources.getStringArray(R.array.categort)
        var builder=AlertDialog.Builder(this)
        builder.setItems(category,object:DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                categoryId=which
                binding.postingTextCategory.text=category[which]
            }

        })

        var alertDialog=builder.create()
        alertDialog.show()
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


                if(clipData!!.itemCount>5){
                    showCustomToast("사진은 5장까지만 선택 가능합니다.")
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

    override fun TryPostPostingSuccess(response: PostingResponse) {
        if(response.code==1000) {
            storage= FirebaseStorage.getInstance("gs://riging-751d4.appspot.com")
            storageRef=storage.getReference()


            for(i in 0 until ImageList.size){
                riverRef=storageRef.child("post_product_images_32/product_image$i")
                uploadTask=riverRef.putFile(ImageList[i].Image!!)
                    PostingService(this).TryPostImagePoting(
                        PostingImageRequest(
                            postId = response.result.postId,
                            "${ImageList[i].Image}"
                        )
                    )
            }
            showCustomToast("게시물이 추가되었습니다.")

        }else{
            showCustomToast(response.code.toString()+"TryPostPostingSuccess")
        }

    }

    override fun TryPostPostingFailue(message: String) {
        showCustomToast(message)

    }

    override fun TryPostingImageSuccess(response: PostingImageResponse) {
            if(response.code==1000){
                showCustomToast("이미지 게시 완료")
            }else{
                showCustomToast(response.code.toString()+"TryPostingImageSuccess")
            }
    }

    override fun TryPostingIamgeFailue(message: String) {
        showCustomToast(message)
    }


    fun PriceTextParsing(text:String): String {
        var t_stringBuilder = StringBuilder()
        var textList=text.split("")
        if(textList.size==4){
            for(i in 0 until textList.size){
                if(i ==0){
                    t_stringBuilder.append(textList[i])
                    t_stringBuilder.append(",")
                }else{
                    t_stringBuilder.append(textList[i])
                }
            }
            return t_stringBuilder.toString()
        }
        return text

    }



}