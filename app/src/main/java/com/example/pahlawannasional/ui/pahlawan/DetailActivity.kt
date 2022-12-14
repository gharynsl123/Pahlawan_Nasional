package com.example.pahlawannasional.ui.pahlawan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pahlawannasional.data.respone.DaftarPahlawan
import com.example.pahlawannasional.data.respone.DaftarPahlawanItem
import com.example.pahlawannasional.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<DaftarPahlawan>(DETAIL_KEY) as DaftarPahlawanItem

        supportActionBar?.title = data.nama
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.apply {
            tvAsalDetail.text = data.asal
            tvDescDetail.text = data.history
            tvGugurDetail.text = data.gugur
            tvLahirDetail.text = data.lahir
            tvNameDetail.text = data.nama2
            tvLahirDetail.text = data.lahir
            tvUsiaDetail.text = data.usia
            lokasiMakamDetail.text = data.lokasimakam

            Glide.with(imgHeroDetail).load(data.img).into(imgHeroDetail)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val DETAIL_KEY = "data_pahlawan"
    }
}