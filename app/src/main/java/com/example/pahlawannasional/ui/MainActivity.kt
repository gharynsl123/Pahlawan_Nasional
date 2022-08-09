package com.example.pahlawannasional.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.pahlawannasional.R
import com.example.pahlawannasional.databinding.ActivityMainBinding
import com.example.pahlawannasional.ui.listuser.ListUserActivity
import com.example.pahlawannasional.ui.pahlawan.JsonActivity
import com.example.pahlawannasional.ui.searchrepo.SearchRepoActivity
import com.example.pahlawannasional.ui.searchuser.SearchUserActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.center_title)

        binding.apply {
            btnRvJson.setOnClickListener(this@MainActivity)
            btnRvListUsers.setOnClickListener(this@MainActivity)
            btnRvSearchUsers.setOnClickListener(this@MainActivity)
            btnRvRepo.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRvJson -> startActivity(Intent(this, JsonActivity::class.java))
            R.id.btnRvListUsers -> startActivity(Intent(this, ListUserActivity::class.java))
            R.id.btnRvSearchUsers -> startActivity(Intent(this, SearchUserActivity::class.java))
            R.id.btnRvRepo -> startActivity(Intent(this, SearchRepoActivity::class.java))
        }
    }
}


