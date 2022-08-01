package com.example.pahlawannasional

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pahlawannasional.databinding.ActivityDetailBinding
import com.example.pahlawannasional.respone.DaftarPahlawan
import com.example.pahlawannasional.respone.DaftarPahlawanItem

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data = intent.getParcelableExtra<DaftarPahlawan>(DETAIL_KEY) as DaftarPahlawanItem
        Glide.with(this).load(data.img).into(binding.imgHeroDetail)

        binding.apply {
            tvAsalDetail.text = data.asal
            tvDescDetail.text = data.history
            tvGugurDetail.text = data.gugur
            tvLahirDetail.text = data.lahir
            tvNameDetail.text = data.nama2
            tvLahirDetail.text = data.lahir
            tvUsiaDetail.text = data.usia
            lokasiMakamDetail.text = data.lokasimakam
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object{
        const val DETAIL_KEY = "data_pahlawan"
    }
}