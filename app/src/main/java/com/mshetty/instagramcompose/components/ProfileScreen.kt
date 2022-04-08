package com.mshetty.instagramcompose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.mshetty.instagramcompose.R

@Composable
fun ProfileScreen() {
    return Scaffold {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Text(stringResource(R.string.coming_soon),
                style = TextStyle(
                    color = colorResource(id = R.color.textColor)
                ))
        }
    }
}