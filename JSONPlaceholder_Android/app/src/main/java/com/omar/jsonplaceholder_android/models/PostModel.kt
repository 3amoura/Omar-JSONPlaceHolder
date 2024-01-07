package com.omar.jsonplaceholder_android.models

import java.io.Serializable

data class PostModel(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
) : Serializable