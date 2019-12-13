package com.example.nguyen.fakeapp.models


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ControllerApi {



    companion object {
        private const val BASE_URL = "https://tdhh.viso.vn/"
        private var retrofit: Retrofit? = null
        fun getClient(): Retrofit {
            var interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            var client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor).build()

            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit as Retrofit
        }
    }
}
//    https://tdhh.viso.vn/api/auth/login?email=chiennxd00245@fpt.edu.vn&password=123456