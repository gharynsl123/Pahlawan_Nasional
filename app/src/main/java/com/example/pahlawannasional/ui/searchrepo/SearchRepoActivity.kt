package com.example.pahlawannasional.ui.searchrepo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pahlawannasional.databinding.ActivitySearchRepoBinding

class SearchRepoActivity : AppCompatActivity() {

    private var _binding: ActivitySearchRepoBinding? = null
    private val binding get() = _binding as ActivitySearchRepoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[SearchRepoViewModel::class.java]

        binding.svRepo.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.searchRepositories(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        viewModel.getSearchRepo().observe(this@SearchRepoActivity) {
            binding.rvSearchRepo.apply {
                adapter = it.items?.let { it1 -> SearchRepoAdapter(it1) }
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@SearchRepoActivity)

            }
        }
    }
}