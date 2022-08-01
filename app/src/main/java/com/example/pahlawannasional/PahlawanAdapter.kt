package com.example.pahlawannasional

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pahlawannasional.databinding.RowItemPahlawanBinding
import com.example.pahlawannasional.respone.DaftarPahlawan
import com.example.pahlawannasional.respone.DaftarPahlawanItem
import com.google.gson.Gson

class PahlawanAdapter(var context: Context) :
    RecyclerView.Adapter<PahlawanAdapter.MyPahlawanHolder>() {

    //Memanggil Function Helper untuk membaca data json
    private val pahlawanList: List<DaftarPahlawanItem> = Gson()
        .fromJson(
            getJsonDataFromAsset(context, "pahlawan_nasional.json").toString(),
            DaftarPahlawan::class.java
        ).daftarPahlawan as List<DaftarPahlawanItem>

    //Membuat ViewHolder dan mengambil Layout Item dari XML menggunakan Binding
    inner class MyPahlawanHolder(val binding: RowItemPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root)

    //Mengambil Layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyPahlawanHolder(
        RowItemPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyPahlawanHolder, position: Int) {
        val dataPahlawan = pahlawanList[position]
        holder.binding.apply {
                tvNameHero.text = dataPahlawan.nama
                tvDescHero.text = dataPahlawan.history
                tvAge.text = dataPahlawan.usia
                tvDomicileHero.text = dataPahlawan.asal

            Glide.with(imgHero).load(dataPahlawan.img).placeholder(R.drawable.ic_loading)
                .into(imgHero)

            holder.itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.DETAIL_KEY, dataPahlawan)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = pahlawanList.size
}