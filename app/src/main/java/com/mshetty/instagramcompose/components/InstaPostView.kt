package com.mshetty.instagramcompose.components

import android.text.TextUtils
import android.util.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size.Companion.ORIGINAL
import com.mshetty.instagramcompose.R
import com.mshetty.instagramcompose.model.Profile

@Composable
fun InstaPostView(modifier:Modifier,profile:Profile) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image( if (!TextUtils.isEmpty(profile.imageId)) {
                rememberAsyncImagePainter(model = ImageRequest.Builder(LocalContext.current)
                    .data(profile.imageId)
                    .build(),contentScale = ContentScale.FillWidth)
            } else {
                painterResource(R.drawable.sample)
            },
                contentDescription = profile.text,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().padding(16.dp))
            Text(text = profile.userName,
                modifier = modifier,
                maxLines = 1,
                fontSize = 14.sp,
                style = MaterialTheme.typography.h2)
        }
    }
}
