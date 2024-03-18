package com.ata.core.ui.component

import android.content.res.Configuration
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ata.core.ui.theme.OweBackground
import com.ata.core.ui.theme.OweYellow

@Composable
fun OweButton(
    modifier: Modifier = Modifier,
    text: String,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = OweYellow.color(),
            contentColor = OweBackground.color()
        ),
        elevation = ButtonDefaults.buttonElevation(),
        onClick = { /*TODO*/ }
    ) {
        Text(text = text)
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "Full Preview", showSystemUi = true)
@Preview(name = "Full Preview - Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
private fun OweButtonPrev() {
    OweButton(text = "BUTTON")
}