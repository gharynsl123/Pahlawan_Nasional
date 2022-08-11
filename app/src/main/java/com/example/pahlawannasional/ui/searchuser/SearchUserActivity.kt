package com.example.pahlawannasional.ui.searchuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pahlawannasional.databinding.ActivitySearchUserBinding

class SearchUserActivity : AppCompatActivity() {

    private var _binding: ActivitySearchUserBinding? = null
    private val binding get() = _binding as ActivitySearchUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[SearchUserViewModel::class.java]

        binding.svUser.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.searchUser(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        viewModel.getSearchUser().observe(this) {
            binding.rvSearchUser.apply {
                adapter = it.items?.let { it1 -> SearchUserAdapter(it1) }
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@SearchUserActivity)

            }
        }
    }
}