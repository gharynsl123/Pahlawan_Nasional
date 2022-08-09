package com.example.pahlawannasional.ui.listuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pahlawannasional.data.ApiConfig
import com.example.pahlawannasional.data.respone.UsersResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListUserViewModel : ViewModel() {

    //list ini digunakan sebagai penampung data setelah diambil dari API
    val listUser = MutableLiveData<List<UsersResponseItem>>()

    fun getListUser(){
        ApiConfig.getApiSercive().getListUsers().enqueue(object : Callback<List<UsersResponseItem>>{
            override fun onResponse(
                call: Call<List<UsersResponseItem>>,
                //data sudah berada di parameter response ketika fungsi getListUser() dipanggil
                response: Response<List<UsersResponseItem>>
            ) {
                //mengisi listUser Yang masih kosong dengan data Response
                listUser.postValue(response.body())
            }

            override fun onFailure(call: Call<List<UsersResponseItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getResultListUsers() : LiveData<List<UsersResponseItem>> = listUser
}