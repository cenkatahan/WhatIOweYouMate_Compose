package com.ata.add

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ata.add.component.OweTextField
import com.ata.core.ui.component.OweButton
import com.ata.core.ui.component.OweOutlinedButton
import com.ata.core.ui.theme.OweGreen

@Composable
fun AddScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        OweTextField(
            value = "",
            label = { Text(text = "Name", color = OweGreen.color()) },
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = null,
                    tint = OweGreen.color()
                )
            }) {

        }
        Spacer(modifier = Modifier.height(16.dp))
        OweTextField(
            value = "",
            label = { Text(text = "Cost", color = OweGreen.color()) },
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Money,
                    contentDescription = null,
                    tint = OweGreen.color()
                )
            }) {

        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OweOutlinedButton(
                modifier = Modifier.fillMaxWidth(0.4f),
                text = "Dismiss"
            )
            Spacer(modifier = Modifier.width(16.dp))
            OweButton(
                modifier = Modifier.fillMaxWidth(1f),
                text = "Add"
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
private fun AddPrev() {
    AddScreen()
}