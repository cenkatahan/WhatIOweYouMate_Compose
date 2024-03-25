package com.ata.core.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.ata.core.ui.theme.OweGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OweTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: @Composable() (() -> Unit),
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable() (() -> Unit),
    trailingIcon: @Composable() (() -> Unit),
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = {onValueChange(it)},
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        label = label,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = OweGreen.color(),
            focusedBorderColor = OweGreen.color(),
            unfocusedBorderColor = OweGreen.color()
        ),
        keyboardOptions = keyboardOptions
    )
}