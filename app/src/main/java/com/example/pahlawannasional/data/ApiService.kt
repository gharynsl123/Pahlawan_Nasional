package com.example.pahlawannasional.data

import com.example.pahlawannasional.data.respone.RepoRespone
import com.example.pahlawannasional.data.respone.UsersResponse
import com.example.pahlawannasional.data.respone.UsersResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    fun getListUsers(): Call<List<UsersResponseItem>>


    @GET("search/users")
    fun searchUsers(
        @Query("q") userName: String,
    ): Call<UsersResponse>

    @GET("search/repositories")
    fun getUserRepositories(
        @Query("q") repositoriesName: String,
    ): Call<RepoRespone>
}