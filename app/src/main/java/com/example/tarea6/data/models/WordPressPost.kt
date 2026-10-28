package com.example.tarea6.data.models

data class WordPressPost(
    val id: Long? = null,
    val date: String? = null,
    val link: String? = null,
    val title: RenderedText? = null,
    val excerpt: RenderedText? = null
)

data class RenderedText(
    val rendered: String? = null
)
