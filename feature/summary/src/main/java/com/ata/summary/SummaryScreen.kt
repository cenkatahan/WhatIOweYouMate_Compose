package com.ata.summary

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ata.core.ui.component.OweText
import com.ata.summary.component.SummaryItem

@Composable
fun SummaryScreen() {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OweText(
            text = "Summary",
            fontSize = 48.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(16.dp))
        OweText(text = "Total  Expense: \$0.0")
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxHeight(0.9f)
        ) {
            //Add items
            item {
                SummaryItem()
                Spacer(modifier = Modifier.height(8.dp))
                SummaryItem()
                Spacer(modifier = Modifier.height(8.dp))
                SummaryItem()
                Spacer(modifier = Modifier.height(8.dp))
                SummaryItem()
                Spacer(modifier = Modifier.height(8.dp))
                SummaryItem()
                Spacer(modifier = Modifier.height(8.dp))
                SummaryItem()
                Spacer(modifier = Modifier.height(8.dp))
            }
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
    SummaryScreen()
}