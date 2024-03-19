package com.ata.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ata.core.R
import com.ata.core.ui.theme.OweGreen
import com.ata.core.ui.theme.OweYellow

@Composable
fun TopBar(
    onClickAdd: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        val appName = buildAnnotatedString {
            withStyle(
                style = SpanStyle(fontSize = 20.sp, color = OweGreen.color())
            ) {
                append("What I")
            }
            append("\n")
            withStyle(
                style = SpanStyle(color = OweGreen.color())
            ) {
                withStyle(
                    style = SpanStyle(color = OweYellow.color())
                ){
                    append("Owe ")
                }
                append("You, Mate?")

            }
        }
        val appIcon = when(isSystemInDarkTheme()) {
            false -> painterResource(id = R.drawable.ic_app)
            true -> painterResource(id = R.drawable.ic_app_dark)
        }
        Image(
            modifier = Modifier.size(48.dp),
            painter = appIcon,
            contentDescription = null
        )
        Text(text = appName, textAlign = TextAlign.Center)
        //Add Button
        IconButton(onClick = { onClickAdd() }) {
            Icon(
                imageVector = Icons.Rounded.AddCircleOutline,
                tint = OweGreen.color(),
                contentDescription = null
            )
        }
    }
}