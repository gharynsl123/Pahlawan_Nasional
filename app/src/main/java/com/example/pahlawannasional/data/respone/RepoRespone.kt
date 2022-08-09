package com.example.pahlawannasional.data.respone

import com.google.gson.annotations.SerializedName

data class RepoRespone(
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

    @field:SerializedName("topic")
    val topic: List<String>
)
