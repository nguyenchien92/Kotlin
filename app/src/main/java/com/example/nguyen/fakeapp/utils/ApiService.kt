package com.example.nguyen.fakeapp.utils

import com.example.nguyen.fakeapp.models.LoginInfo
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("api/auth/login")
    fun getDataLogin(
        @Field("email") email: String,@Field("password") password: String
    ): Call<LoginInfo>

    @FormUrlEncoded
    @POST("api/auth/register")
    fun register(@FieldMap map:Map<String,String>):Call<LoginInfo>

//    https://tdhh.viso.vn/api/auth/login
//    https://tdhh.viso.vn/api/auth/register
}