package com.example.pahlawannasional.respone

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DaftarPahlawan(
    @field:SerializedName("daftar_pahlawan")
    val daftarPahlawan: List<DaftarPahlawanItem>? = null,
) : Parcelable

@Parcelize
data class DaftarPahlawanItem(

    @field:SerializedName("nama2")
    var nama2: String? = null,

    @field:SerializedName("asal")
    var asal: String? = null,

    @field:SerializedName("usia")
    var usia: String? = null,

    @field:SerializedName("img")
    var img: String? = null,

    @field:SerializedName("lahir")
    var lahir: String? = null,

    @field:SerializedName("lokasimakam")
    var lokasimakam: String? = null,

    @field:SerializedName("nama")
    var nama: String? = null,

    @field:SerializedName("gugur")
    var gugur: String? = null,

    @field:SerializedName("kategori")
    var kategori: String? = null,

    @field:SerializedName("history")
    var history: String? = null
) : Parcelable
