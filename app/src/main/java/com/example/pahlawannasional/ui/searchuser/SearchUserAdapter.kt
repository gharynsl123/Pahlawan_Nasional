package com.example.pahlawannasional.ui.searchuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pahlawannasional.data.respone.UsersResponseItem
import com.example.pahlawannasional.databinding.RowItemUserBinding

class SearchUserAdapter(var listUserGithub: List<UsersResponseItem>) :
    RecyclerView.Adapter<SearchUserAdapter.MyUserHolder>() {

    inner class MyUserHolder(val binding: RowItemUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyUserHolder(
        RowItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyUserHolder, position: Int) {
        val dataUser = listUserGithub[position]
        holder.binding.apply {
            tvName.text = dataUser.login
            Glide.with(imgUser).load(dataUser.avatarUrl).into(imgUser)
        }
    }

    override fun getItemCount(): Int = listUserGithub.size

}