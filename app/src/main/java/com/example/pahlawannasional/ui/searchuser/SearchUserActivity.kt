package com.example.pahlawannasional.ui.searchuser

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pahlawannasional.R

class SearchUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_user)

        val searchViewString = "Lala"

        val viewModel = ViewModelProvider(this)[SearchUserViewModel::class.java]
        viewModel.searchUser(searchViewString)
        viewModel.getSearchUser().observe(this) {
            Log.i("DATA", "onCreate: $it, Nama Usernya -----> ${it.items?.get(0)?.login}")
        }
    }
}