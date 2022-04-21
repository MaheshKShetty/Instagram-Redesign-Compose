package com.mshetty.instagramcompose.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.mshetty.instagramcompose.R

@Composable
fun HomeScreen() {
    return Scaffold(
        topBar = { TopAppBar(
            modifier = Modifier.padding(16.dp,16.dp,0.dp,0.dp),
            title = { Text(text = stringResource(R.string.instagram), style = MaterialTheme.typography.h1) },
            backgroundColor = colorResource(id = R.color.white),
            elevation = 0.dp
        ) },
    ) {

    }
}

sealed class MenuAction(@DrawableRes val icon: Int) {
    object Share : MenuAction(R.drawable.ic_baseline_search_24)
}
