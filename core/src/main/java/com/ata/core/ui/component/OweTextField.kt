package com.ata.core.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ata.core.ui.theme.OweGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OweTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: @Composable() (() -> Unit),
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable() (() -> Unit),
    clearValue: () -> Unit,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = {onValueChange(it)},
        leadingIcon = leadingIcon,
        trailingIcon = {
            IconButton(onClick = { clearValue() }) {
                Icon(
                    imageVector = Icons.Rounded.Cancel,
                    contentDescription = null,
                    tint = OweGreen.color()
                )
            }
        },
        label = label,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = OweGreen.color(),
            focusedBorderColor = OweGreen.color(),
            unfocusedBorderColor = OweGreen.color()
        )
    )
}