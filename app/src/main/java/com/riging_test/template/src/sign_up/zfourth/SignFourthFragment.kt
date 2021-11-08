package com.riging_test.template.src.sign_up.zfourth

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.riging_test.template.R
import com.riging_test.template.config.ApplicationClass.Companion.editor
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentSignupFourthBinding
import com.riging_test.template.src.main.MainActivity
import com.riging_test.template.src.sign_up.zfourth.models.PostNewSignupRequest
import com.riging_test.template.src.sign_up.zfourth.models.SignupResponse
import retrofit2.http.Url
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.lang.reflect.Type
import java.util.jar.Manifest

class SignFourthFragment:
    BaseFragment<FragmentSignupFourthBinding>(FragmentSignupFourthBinding::bind, R.layout.fragment_signup_fourth),SignFouthFragmentView {


    private val REQUEST_CODE=1001
    private val REQUEST_EXTERNAL_STORAGE_PERMISSION=1002

    private lateinit var current_location:String
    private lateinit var phoneNumber:String

    private lateinit var Profile_image: ImageView

    private lateinit var storage: FirebaseStorage
    private lateinit var storageRef:StorageReference





    private val Test_Image_Url="http://post.phinf.naver.net/MjAyMTA5MDJfMjg3/MDAxNjMwNTYyNjc3OTUx.eUoey7erD2ZlW6TfA5sHseMrfjMhBAMY2cDTbsnjyJYg.I9R1N3Qithxv-x2qjacdRW1Qwixg953FZLlHjASgNcwg.JPEG/I3YZLE8p_1d-lCGeU8Ijzg1Ry9YU.jpg"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storage= FirebaseStorage.getInstance("gs://riging-751d4.appspot.com")
        storageRef=storage.getReference()




        phoneNumber=arguments?.getString("phoneNumber")!!
        current_location=arguments?.getString("location")!!


        showCustomToast(phoneNumber+current_location)





        Profile_image=binding.signupFourthImageProfile


        binding.signupFourthEditNickname.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("Editext_Change",count.toString())
                if(count>1){
                    binding.signupFourthTextNickname.visibility=View.INVISIBLE
                }else if(count<1){
                    binding.signupFourthTextNickname.visibility=View.VISIBLE

                }

            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        binding.signupFourthButtonNext.setOnClickListener {
            var Main_Intent=Intent(activity,MainActivity::class.java)
            var NickName=binding.signupFourthEditNickname.text.toString()
            var profile_Image=storageRef.child("profile_image/profile1").toString()


            SignFouthService(this)
            var location=current_location.split(" ")
            SignFouthService(this).PostSignup(
                PostNewSignupRequest(city = location[0],district = location[1],
                townName = location[2],phoneNumber = phoneNumber,nickName = NickName,profile_Image)
            )




            Main_Intent.putExtra("NickName",NickName)
            Main_Intent.putExtra("PhoneNumber",phoneNumber)
            Main_Intent.putExtra("Location",current_location)

            startActivity(Main_Intent)
            requireActivity().finish()

        }

        if(ContextCompat.checkSelfPermission(requireActivity(),
            android.Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),
                android.Manifest.permission.READ_EXTERNAL_STORAGE)){

            }else{
                ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    REQUEST_EXTERNAL_STORAGE_PERMISSION)
            }
        }


        Profile_image.setOnClickListener {
            var Image_Intent=Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(Image_Intent,REQUEST_CODE)

        }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==REQUEST_CODE){
            if(data!=null) {
                var image = data?.data
                var riverRef=storageRef.child("profile_image/profile1")
                var uploadTask=riverRef.putFile(image!!)

                // 가져온 사진을 이미지뷰에 띄우기 위해서는 비트맵으로 변환하는 과정이 필요함
                try {
                    var bitmap =
                        MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, image)
                    Log.d("Profile_Imaga", bitmap.toString())
                    Log.d("Profiloe_Image_Data", image.toString())
                    //saveBitmapToJpeg(bitmap,"profile_image")// 캐시에 이미지를 저장
                    //var read_image=readCache() // 캐시에 이미지가 저장이 되어 있으면 캐시에서 이미지를 가져오는 메서드

                    Glide.with(requireContext()).load(bitmap).circleCrop().into(Profile_image)
                    binding.signupFourthIconCamara.visibility = View.INVISIBLE
                } catch (e: IOException) { // 에러가 났을 때 강제로 종료가 되지 않도록 처리
                    e.printStackTrace()
                }
            }else{
                showCustomToast("어떠한 이미지도 선택하지 않으셨습니다")
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    fun readCache() : File{
        var file=File(requireActivity().cacheDir.toString())
        var files=file.listFiles()
        return files[0]
    }

    fun saveBitmapToJpeg(bitmap:Bitmap,name:String){
        var storage=requireActivity().cacheDir
        var file_name=name

        var file= File(storage,file_name)

        try{
            file.createNewFile()

            var out_stream=FileOutputStream(file)

            bitmap.compress(Bitmap.CompressFormat.JPEG,100,out_stream)

            out_stream.close()

        }catch(e:FileNotFoundException){
            e.printStackTrace()
        }catch(e:IOException){
            e.printStackTrace()
        }
    }

    override fun onPostSignupSuccess(response: SignupResponse) {
        when(response.code){
            1000 ->{
                Log.d("test_jwt",response.result.jwt)
                editor.putString("jwt",response.result.jwt)
                editor.putInt("userId",response.result.userId)
                editor.apply()
            }

            2011 ->{
                showCustomToast(response.message)
            }

            2012 ->{
                showCustomToast(response.message)
            }

            2013 -> {
                showCustomToast(response.message)

            }

            2014 -> {
                showCustomToast(response.message)
            }

            2019 ->{
                showCustomToast(response.message)
            }

            4000 -> {
                showCustomToast(response.message)
            }

        }

    }

    override fun onPostSignupFailure(message: String) {
        showCustomToast(message)
    }
}