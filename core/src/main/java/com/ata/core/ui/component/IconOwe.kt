package com.ata.core.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ata.core.R
import com.ata.core.ui.theme.OweBackground
import com.ata.core.ui.theme.OweGreen

@Composable
fun IconOwe() {
    val icon = painterResource(id = R.drawable.ic_receipt)

    Icon(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .border(width = 2.dp, color = OweGreen.color())
            .background(color = OweGreen.color())
            .padding(4.dp)
        ,
        painter = icon,
        contentDescription = null,
        tint = OweBackground.color()
    )
}


@Preview(name = "Full Preview", showSystemUi = true)
@Preview(
    name = "Full Preview - Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Composable
private fun OweButtonPrev() {
    IconOwe()
}