package com.mshetty.instagramcompose.model

data class Profile(
    val id: Int,
    val text: String,
    val userName: String,
    val time: String,
    val imageId: String? = null
)