package com.example.pahlawannasional.ui.pahlawan

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pahlawannasional.databinding.ActivityJsonBinding
import java.io.IOException

class JsonActivity : AppCompatActivity() {
    private var _binding: ActivityJsonBinding? = null
    private val binding get() = _binding as ActivityJsonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rvHero.apply {
                layoutManager = LinearLayoutManager(this@JsonActivity)
                adapter = PahlawanAdapter(this@JsonActivity)
            }

            fabBackTop.setOnClickListener {
                rvHero.smoothScrollToPosition(0)

            }

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText != null) {
                        (rvHero.adapter as PahlawanAdapter).filter.filter(newText)
                    }
                    return false
                }
            })
        }
    }
}

//function untuk mengambil data dari json
fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}