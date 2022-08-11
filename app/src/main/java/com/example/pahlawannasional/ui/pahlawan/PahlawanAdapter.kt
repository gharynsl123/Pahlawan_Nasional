package com.example.pahlawannasional.ui.pahlawan

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pahlawannasional.R
import com.example.pahlawannasional.data.respone.DaftarPahlawan
import com.example.pahlawannasional.data.respone.DaftarPahlawanItem
import com.example.pahlawannasional.databinding.RowItemPahlawanBinding
import com.google.gson.Gson
import java.util.*

class PahlawanAdapter(var context: Context) :
    RecyclerView.Adapter<PahlawanAdapter.MyPahlawanHolder>(), Filterable {

    private val pahlawanList: MutableList<DaftarPahlawanItem> = (Gson()
        .fromJson(
            getJsonDataFromAsset(context, "pahlawan_nasional.json").toString(),
            DaftarPahlawan::class.java
        ).daftarPahlawan as List<DaftarPahlawanItem>).toMutableList()

    private var heroFilter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filterList: MutableList<DaftarPahlawanItem> = ArrayList()
            if (constraint == null || constraint.isEmpty()) {
                filterList.addAll(pahlawanList)
            } else {
                val filterPattern = constraint.toString().lowercase(Locale.getDefault())
                for (item: DaftarPahlawanItem in pahlawanList) {
                    if (item.nama?.lowercase(Locale.ROOT)?.contains(filterPattern) == true) {
                        filterList.add(item)
                    }
                }
            }
            val filterResults = FilterResults()
            filterResults.values = filterList
            return filterResults
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            pahlawanList.clear()
            pahlawanList.addAll(results?.values as List<DaftarPahlawanItem>)
            notifyDataSetChanged()
        }
    }

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

            Glide.with(imgHero).load(dataPahlawan.img).placeholder(R.drawable.ic_loading).into(imgHero)

            holder.itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.DETAIL_KEY, dataPahlawan)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = pahlawanList.size

    override fun getFilter(): Filter = heroFilter
}