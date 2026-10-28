package com.example.tarea6.data.models

import com.google.gson.annotations.SerializedName

data class University(
    val name: String? = null,
    val country: String? = null,
    val domains: List<String>? = null,
    @SerializedName("web_pages")
    val webPages: List<String>? = null
)
