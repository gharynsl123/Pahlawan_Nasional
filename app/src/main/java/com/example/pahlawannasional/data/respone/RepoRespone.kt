package com.example.pahlawannasional.data.respone

import com.google.gson.annotations.SerializedName

data class RepoRespone(

    @field:SerializedName("total_count")
    val total_count: Int? = null,

    @field:SerializedName("items")
    val items: List<RepoResponeItem>? = null
)

data class RepoResponeItem(
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("full_name")
    val fullName: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("topics")
    val topic: List<String>,

    @field:SerializedName("created_at")
    val created: String? = null,

    @field:SerializedName("updated_at")
    val update: String? = null
)
