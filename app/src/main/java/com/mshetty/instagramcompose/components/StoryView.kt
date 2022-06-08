package com.mshetty.instagramcompose.components

import android.text.TextUtils
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
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
        modifier = modifier.padding(16.dp,0.dp,16.dp,0.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(profiles) { items ->
            LoadStoryItems(profile = items, modifier = modifier)
        }
    }
    LazyColumn(
        modifier = modifier.padding(16.dp,0.dp,16.dp,0.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(profiles) { items ->
            InstaPostView(modifier = modifier, profile = items)
        }
    }

}

@Composable
fun LoadStoryItems(profile: Profile, modifier: Modifier) {
    Column( modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = if(!TextUtils.isEmpty(profile.imageId)) {rememberAsyncImagePainter(profile.imageId) } else {
                painterResource(R.drawable.sample)},
            contentDescription = profile.text ,
            modifier = modifier
                .clip(CircleShape)
                .size(80.dp),
            contentScale = ContentScale.Crop
        )
        Text(text = profile.userName,
            modifier = modifier,
            maxLines = 1,
            fontSize = 14.sp,
            style = MaterialTheme.typography.h2
        )
    }
}
