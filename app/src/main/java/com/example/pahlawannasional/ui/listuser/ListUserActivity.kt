package com.example.pahlawannasional.ui.listuser

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pahlawannasional.R

class ListUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

        val viewModel = ViewModelProvider(this).get(ListUserViewModel::class.java)
        viewModel.getListUser()
        viewModel.getResultListUsers().observe(this){
            Log.i("ListUserActivity", "onCreate: $it")
        }
    }
}