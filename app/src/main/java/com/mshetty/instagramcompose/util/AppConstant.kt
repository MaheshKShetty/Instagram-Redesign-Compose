package com.mshetty.instagramcompose.util

import com.mshetty.instagramcompose.R
import com.mshetty.instagramcompose.model.Profile

object AppConstant {
    val HOME = "home"
    val SEARCH = "search"
    val PROFILE = "profile"
    val INSTAURL = "https://www.instagram.com/?hl=en"

    val profiles = listOf(
        Profile(
            id = 1,
            text = "foody_123",
            imageId = "",
            userName = "My Story",
            time = "11m"
        ),
        Profile(
            id = 1,
            text = "foody_123",
            imageId = null,
            userName = "foody143",
            time = "11m"
        ),
        Profile(
            id = 2,
            userName = "Nature",
            text = "Google",
            imageId = "https://www.gstatic.com/webp/gallery/1.jpg",
            time = "11m"
        ),
        Profile(
            id = 3,
            userName = "travel_india",
            text = "Google",
            imageId = "https://picsum.photos/seed/picsum/200/300",
            time = "11m"
        ),
        Profile(
            id = 4,
            userName = "insta_shots",
            text = "Google",
            imageId ="https://picsum.photos/200/300.jpg" ,
            time = "11m"
        ),
        Profile(
            id = 5,
            userName = "unknown_ghost",
            text = "Google",
            imageId = "https://picsum.photos/200/300/?blur",
            time = "11m"
        )
    )

}