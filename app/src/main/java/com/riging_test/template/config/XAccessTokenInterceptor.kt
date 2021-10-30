package com.riging_test.template.config

import com.riging_test.template.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import java.io.IOException
import kotlin.jvm.Throws

class XAccessTokenInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder=chain.request().newBuilder()
        val jwtToken:String?=sSharedPreferences.getString(X_ACCESS_TOKEN,null)
        if(jwtToken!=null){
            builder.addHeader("X-ACCESS-TOKEN",jwtToken)
        }
        return chain.proceed(builder.build())
    }

}