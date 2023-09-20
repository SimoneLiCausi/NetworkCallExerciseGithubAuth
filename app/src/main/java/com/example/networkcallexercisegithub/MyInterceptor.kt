package com.example.networkcallexercisegithub

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor: Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response{
        val basicRequest = chain.request()
        val newRequest = basicRequest.newBuilder()
            .header("key", "c7b5ea9d69ed04096d4098101c200d6f")
            .build()

        return chain.proceed(newRequest)
    }

}