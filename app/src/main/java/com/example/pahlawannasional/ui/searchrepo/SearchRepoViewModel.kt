package com.example.pahlawannasional.ui.searchrepo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pahlawannasional.data.ApiConfig
import com.example.pahlawannasional.data.respone.RepoRespone
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRepoViewModel: ViewModel() {

    val repoUser = MutableLiveData<RepoRespone>()

    fun searchRepositories(searchRepoUser: String) {
        ApiConfig.getApiSercive().getUserRepositories(searchRepoUser).enqueue(object : Callback<RepoRespone> {
             override fun onResponse(call: Call<RepoRespone>, response: Response<RepoRespone>) {
                repoUser.value = response.body()
            }

            override fun onFailure(call: Call<RepoRespone>, t: Throwable) {
                Log.e("error", "OnFailure: $t")
            }
        })
    }

    fun getSearchRepo(): LiveData<RepoRespone> = repoUser

}