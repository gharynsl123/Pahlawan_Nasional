package com.example.pahlawannasional.ui.searchuser

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pahlawannasional.data.ApiConfig
import com.example.pahlawannasional.data.respone.UsersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchUserViewModel : ViewModel() {
    val listUser = MutableLiveData<UsersResponse>()

    fun searchUser(searchViewString: String) {
        ApiConfig.getApiSercive().searchUsers(searchViewString)
            .enqueue(object : Callback<UsersResponse> {
                override fun onResponse(
                    call: Call<UsersResponse>,
                    response: Response<UsersResponse>
                ) {
                    listUser.value = response.body()
                }

                override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                    Log.e("error", "OnFailure: $t")
                }
            })
    }

    fun getSearchUser(): LiveData<UsersResponse> = listUser
}