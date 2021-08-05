package com.example.risingtest.config

import com.example.risingtest.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.risingtest.config.ApplicationClass.Companion.sSharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class XAccessTokenInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        val jwtToken: String? = sSharedPreferences.getString(X_ACCESS_TOKEN, null)
        if (jwtToken != null) {
            builder.addHeader("X-ACCESS-TOKEN", jwtToken)
        }
        return chain.proceed(builder.build())
        //http통신할때 헤더에 자동으로 jwt토큰을 붙여주는 코드
        //최초로그인시에 발급받은 토큰값을 sharedPreference에 잘 저장해놓기만 하면 됨(이걸 이용해서 자동로그인도 가능)
    }
}