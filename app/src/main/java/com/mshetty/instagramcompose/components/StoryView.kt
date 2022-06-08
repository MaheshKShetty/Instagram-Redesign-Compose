package com.mshetty.instagramcompose.components

import android.graphics.Color
import android.text.TextUtils
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.mshetty.instagramcompose.model.Profile
import com.mshetty.instagramcompose.util.AppConstant

import com.mshetty.instagramcompose.R

@Composable
fun LoadStroiesView(
    profiles: List<Profile>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(profiles) { items ->
            LoadStoryItems(profile = items, modifier = modifier,80.dp,)
        }
    }
    Divider(modifier = modifier.padding(0.dp,6.dp,0.dp,6.dp), thickness = 1.dp)
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(profiles) { items ->
            if (items.userName != "My Story" ) {
                InstaPostView(modifier = modifier, profile = items)
            }
        }
    }

}

@Composable
fun LoadStoryItems(profile: Profile, modifier: Modifier, size: Dp,verticalAlignment:Boolean ?= true) {
    if (verticalAlignment == true) {
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = if (!TextUtils.isEmpty(profile.imageId)) {
                rememberAsyncImagePainter(profile.imageId)
            } else {
                painterResource(R.drawable.sample)
            },
                contentDescription = profile.text,
                modifier = modifier
                    .clip(CircleShape)
                    .size(size),
                contentScale = ContentScale.Crop)
            Text(text = profile.userName,
                modifier = modifier,
                maxLines = 1,
                fontSize = 14.sp,
                style = MaterialTheme.typography.h2)
        }
    } else {
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Image(painter = if (!TextUtils.isEmpty(profile.imageId)) {
                rememberAsyncImagePainter(profile.imageId)
            } else {
                painterResource(R.drawable.sample)
            },
                contentDescription = profile.text,
                modifier = modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .size(size),
                contentScale = ContentScale.Crop)
            Text(text = profile.userName,
                modifier = modifier.padding(8.dp,8.dp,0.dp,8.dp),
                maxLines = 1,
                style = MaterialTheme.typography.h2)
            Box(Modifier
                .weight(1f)
                .height(size),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 8.dp).size(size/2)
                )
            }
        }
    }
}
