package com.example.pahlawannasional.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.pahlawannasional.R
import com.example.pahlawannasional.databinding.ActivityMainBinding
import com.example.pahlawannasional.ui.pahlawan.JsonActivity

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.center_title)

        binding.apply {
            btnRvJson.setOnClickListener {
                startActivity(Intent(this@MainActivity, JsonActivity::class.java))
            }
            btnRvListUsers.setOnClickListener {
                startActivity(Intent(this@MainActivity, ListUserActivity::class.java))
            }
        }
    }
}


