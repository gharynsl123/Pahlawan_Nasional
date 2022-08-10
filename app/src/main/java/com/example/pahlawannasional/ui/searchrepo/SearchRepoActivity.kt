package com.example.pahlawannasional.ui.searchrepo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pahlawannasional.data.respone.RepoResponeItem
import com.example.pahlawannasional.databinding.ActivitySearchRepoBinding

class SearchRepoActivity : AppCompatActivity() {
    private var _binding: ActivitySearchRepoBinding? = null
    private val binding get() = _binding as ActivitySearchRepoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel = ViewModelProvider(this)[SearchRepoViewModel::class.java]


        binding.apply {
            svRepo.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        viewModel.searchRepositories(it)
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }

            })
        }

        viewModel.apply {
            getSearchRepo().observe(this@SearchRepoActivity) {
                it.items?.let { it1 -> showData(it1) }
            }
        }
    }

    private fun showData(it: List<RepoResponeItem>) {
        binding.rvSearchRepo.apply {
            adapter = SearchRepoAdapter(it)
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SearchRepoActivity)

        }
    }
}