package com.example.nguyen.fakeapp.utils

import com.example.nguyen.fakeapp.models.LoginInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("api/auth/login")
    fun getDataLogin(
        @Field("email") email: String,@Field("password") password: String
    ): Call<LoginInfo>

//    https://tdhh.viso.vn/api/auth/login
}