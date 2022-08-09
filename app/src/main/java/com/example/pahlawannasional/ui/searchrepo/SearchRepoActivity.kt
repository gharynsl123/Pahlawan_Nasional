package com.example.pahlawannasional.ui.searchrepo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pahlawannasional.R

class SearchRepoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_repo)

        val searchRepoUser = "recyclerview"

        val viewModel = ViewModelProvider(this)[SearchRepoViewModel::class.java]

        viewModel.searchRepositories(searchRepoUser)
        viewModel.getSearchRepo().observe(this){
            Log.i("DataRepositories", "onCreate: $it")
        }
    }
}