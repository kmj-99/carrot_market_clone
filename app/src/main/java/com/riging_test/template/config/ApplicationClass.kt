package com.riging_test.template.config

import android.app.Application
import android.content.SharedPreferences
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass :Application() {

    val API_UTL="https://openapi.naver.com/"

    companion object{

        lateinit var sSharedPreferences:SharedPreferences

        val X_ACCESS_TOKEN="X-ACCESS-TOKEN"

        lateinit var sRetrofit: Retrofit

    }

    override fun onCreate() {
        super.onCreate()
        sSharedPreferences=applicationContext.getSharedPreferences("TEMPLATE_APP", MODE_PRIVATE)

        initRetrofitInstance()
    }

    private fun initRetrofitInstance(){

        val client:OkHttpClient=OkHttpClient.Builder()
            .readTimeout(5000,TimeUnit.MILLISECONDS)
            .connectTimeout(5000,TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(XAccessTokenInterceptor())
            .build()

        sRetrofit=Retrofit.Builder()
            .baseUrl(API_UTL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}

