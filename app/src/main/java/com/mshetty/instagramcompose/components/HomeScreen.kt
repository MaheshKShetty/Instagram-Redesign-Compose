package com.mshetty.instagramcompose.components

import android.content.Intent
import android.graphics.Insets.add
import android.net.Uri
import android.os.Build.VERSION.SDK_INT
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.android.volley.toolbox.ImageLoader
import com.bumptech.glide.Glide
import com.bumptech.glide.gifdecoder.GifDecoder
import com.mshetty.instagramcompose.R
import com.mshetty.instagramcompose.util.AppConstant

@Preview
@Composable
fun HomeScreen() {

    val context = LocalContext.current

    return Scaffold(
        topBar = {
            TopAppBar(
                 modifier = Modifier.padding(16.dp,16.dp,0.dp,0.dp),
                 title = { Text(text = stringResource(R.string.instagram), style = MaterialTheme.typography.h1) },
                 backgroundColor = colorResource(id = R.color.white),
                 elevation = 0.dp,
                 navigationIcon = {
                     IconButton(onClick = {
                         val browserIntent =
                             Intent(Intent.ACTION_VIEW, Uri.parse(AppConstant.INSTAURL))
                         context.startActivity(browserIntent)
                     }) {
                         Icon(
                             painter = painterResource(id = R.drawable.ic_insta_icon),
                             contentDescription = null,
                             tint = androidx.compose.ui.graphics.Color.Unspecified
                         )
                     }
                 },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)) {
                        Icon(
                            modifier = Modifier.padding(16.dp,0.dp,16.dp,0.dp),
                            painter = painterResource(id = R.drawable.ic_messenger),
                            contentDescription = null,
                            tint = androidx.compose.ui.graphics.Color.Unspecified
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_insta_icon),
                            contentDescription = null,
                            tint = androidx.compose.ui.graphics.Color.Unspecified
                        )
                    }

                }
        ) },
    ) {

    }
}

sealed class MenuAction(@DrawableRes val icon: Int) {
    object Share : MenuAction(R.drawable.ic_baseline_search_24)
}
