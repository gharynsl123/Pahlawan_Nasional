package com.example.pahlawannasional.ui.listuser

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pahlawannasional.R
import com.example.pahlawannasional.data.respone.UsersResponseItem
import com.example.pahlawannasional.databinding.RowItemUserBinding

class ListUserAdapter(var ctx: Context, var listUserGithub: List<UsersResponseItem>) :
    RecyclerView.Adapter<ListUserAdapter.MyUserHolder>() {

    inner class MyUserHolder(val binding: RowItemUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyUserHolder(
        RowItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyUserHolder, position: Int) {
        val dataUser = listUserGithub[position]
        holder.binding.apply {
            tvName.text = dataUser.login
            Glide.with(imgUser)
                .load(dataUser.avatarUrl)
                .placeholder(R.drawable.image_header_card)
                .into(imgUser)
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(ctx, "Type Orang ini adalah ${dataUser.type}", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int = listUserGithub.size
}