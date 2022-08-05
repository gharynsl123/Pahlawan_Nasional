package com.example.pahlawannasional.data

import com.example.pahlawannasional.data.respone.UsersResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getListUsers(): Call<List<UsersResponseItem>>
}