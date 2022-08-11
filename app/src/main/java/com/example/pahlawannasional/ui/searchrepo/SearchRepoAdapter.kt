package com.example.pahlawannasional.ui.searchrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pahlawannasional.data.respone.RepoResponeItem
import com.example.pahlawannasional.databinding.RowItemRepoBinding

class SearchRepoAdapter(var listRepoUser: List<RepoResponeItem>) :
    RecyclerView.Adapter<SearchRepoAdapter.MyRepoHolder>() {

    inner class MyRepoHolder(val binding: RowItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyRepoHolder(
        RowItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyRepoHolder, po: Int) {
        val dataRepo = listRepoUser[po]
        holder.binding.apply {
            tvNameRepo.text = dataRepo.name
            tvFullRepo.text = dataRepo.fullName
            tvvDescRepo.text = dataRepo.description
            tvCreatedAt.text = dataRepo.created
            tvUpdate.text = dataRepo.update
        }
    }

    override fun getItemCount(): Int = listRepoUser.size
}