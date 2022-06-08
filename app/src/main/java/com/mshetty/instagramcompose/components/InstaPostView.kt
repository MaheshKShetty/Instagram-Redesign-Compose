package com.mshetty.instagramcompose.components

import android.text.TextUtils
import android.util.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
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
import com.mshetty.instagramcompose.util.loadPicture

@Composable
fun InstaPostView(modifier:Modifier,profile:Profile) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Column(horizontalAlignment = Alignment.Start) {
            LoadStoryItems(profile, modifier = modifier,40.dp,false)
            if (!TextUtils.isEmpty(profile.imageId)) {
                val imgBitMap =  profile.imageId?.let { loadPicture(it) }?.value
                imgBitMap?.let {
                    Image(bitmap = it.asImageBitmap(),
                        contentDescription = profile.text,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize())
                }
            } else {
                Image(painter = painterResource(R.drawable.sample) ,
                    contentDescription = profile.text,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize())
            }
            Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp).size(25.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat),
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp).size(25.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_send_black_outline),
                    contentDescription = null,
                    modifier =Modifier.padding(8.dp).size(25.dp)
                )
            }
        }
    }
}
