package com.ata.core.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ata.core.ui.theme.OweGreen

@Composable
fun OweOutlinedButton(
    modifier: Modifier = Modifier,
    text: String
) {
    OutlinedButton(
        modifier = modifier,
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = OweGreen.color()
        ),
        border = BorderStroke(width = 1.dp, color = OweGreen.color()),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = text)
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
    OweOutlinedButton(text = "BUTTON")
}