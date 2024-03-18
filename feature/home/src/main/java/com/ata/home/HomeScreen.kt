package com.ata.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ata.core.ui.component.OweButton
import com.ata.core.ui.component.OweOutlinedButton
import com.ata.core.ui.component.OweText
import com.ata.core.ui.theme.OweBackground
import com.ata.core.ui.theme.OweGreen
import com.ata.home.component.FriendItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier.background(color = OweBackground.color())
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            //Add Button
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    tint = OweGreen.color(),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        OweText(text = "Total  Expense: \$0.0")
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxHeight(0.9f)
        ){
            //Add items
            item {
                FriendItem()
                Spacer(modifier = Modifier.height(8.dp))
                FriendItem()
                Spacer(modifier = Modifier.height(8.dp))
                FriendItem()
                Spacer(modifier = Modifier.height(8.dp))
                FriendItem()
                Spacer(modifier = Modifier.height(8.dp))
                FriendItem()
                Spacer(modifier = Modifier.height(8.dp))
                FriendItem()
                Spacer(modifier = Modifier.height(8.dp))

            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OweOutlinedButton(
                modifier = Modifier.fillMaxWidth(0.4f),
                text = "Delete"
            )
            Spacer(modifier = Modifier.width(16.dp))
            OweButton(
                modifier = Modifier.fillMaxWidth(1f),
                text = "Calculate"
            )
        }
    }
}

//@Preview(name = "Light Mode")
//@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "Full Preview", showSystemUi = true)
@Preview(
    name = "Full Preview - Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Composable
private fun OweButtonPrev() {
    HomeScreen()
}