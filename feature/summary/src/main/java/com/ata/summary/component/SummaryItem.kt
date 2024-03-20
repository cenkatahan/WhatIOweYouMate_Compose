package com.ata.summary.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ata.core.ui.component.OweText
import com.ata.core.ui.theme.OweBackground
import com.ata.core.ui.theme.OweGreen

@Composable
fun SummaryItem() {
    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = OweGreen.color())
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(8.dp))
            OweText(
                text = "Jane Cooper pays Jane Cooper",
                color = OweBackground.color()
            )

        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Rounded.AttachMoney,
                tint = OweBackground.color(),
                contentDescription = null
            )
            OweText(
                text = "124",
                color = OweBackground.color()
            )
        }

    }
}

@Preview(name = "Full Preview", showSystemUi = true)
@Preview(
    name = "Full Preview - Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Composable
private fun OweButtonPrev() {
    SummaryItem()
}