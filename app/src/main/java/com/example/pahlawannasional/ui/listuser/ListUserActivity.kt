package com.example.pahlawannasional.ui.listuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pahlawannasional.databinding.ActivityListUserBinding

class ListUserActivity : AppCompatActivity() {

    private var _binding: ActivityListUserBinding? = null
    private val binding get() = _binding as ActivityListUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this).get(ListUserViewModel::class.java)

        viewModel.apply {
            getListUser()
            getResultListUsers().observe(this@ListUserActivity) {
                binding.rvListUser.apply {
                    adapter = ListUserAdapter(context, it)
                    layoutManager = LinearLayoutManager(this@ListUserActivity)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}