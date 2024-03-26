package com.ata.update

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.ui.component.OweButton
import com.ata.core.ui.component.OweOutlinedButton
import com.ata.core.ui.component.OweText
import com.ata.core.ui.component.OweTextField
import com.ata.core.ui.theme.OweGreen

@Composable
fun EditScreen(
    friendId: Int,
    viewModel: EditViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {

    viewModel.getFriend(friendId)
    when (val friendState = viewModel.friendState.collectAsState().value) {
        is EditUIState.Error -> {
            Text(text = "ERROR")
        }

        EditUIState.Loading -> {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }

        is EditUIState.Success -> {
            var name by remember {
                mutableStateOf(friendState.data.name)
            }
            var expense by remember {
                mutableStateOf(friendState.data.expense)
            }

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                OweText(
                    text = "Update Friend",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {

                    OweTextField(
                        value = name,
                        label = { Text(text = "Name", color = OweGreen.color()) },
                        onValueChange = {
                            name = it
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Rounded.Person,
                                contentDescription = null,
                                tint = OweGreen.color()
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Rounded.Cancel,
                                    contentDescription = null,
                                    tint = OweGreen.color()
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OweTextField(
                        value = expense.toString(),
                        label = { Text(text = "Expense", color = OweGreen.color()) },
                        onValueChange = {
                            if (it == "") {
                                return@OweTextField
                            }
                            expense = it.toInt()
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Rounded.Money,
                                contentDescription = null,
                                tint = OweGreen.color()
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Rounded.Cancel,
                                    contentDescription = null,
                                    tint = OweGreen.color()
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OweOutlinedButton(
                            modifier = Modifier.fillMaxWidth(0.4f),
                            text = "Dismiss",
                            onClick = { navigateBack() }
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        OweButton(
                            modifier = Modifier.fillMaxWidth(1f),
                            text = "Update",
                            onClick = {
                                val editedFriend = Friend(friendState.data.id, name, expense)
                                viewModel.update(editedFriend)
                                navigateBack()
                            }
                        )
                    }
                }
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
    EditScreen(
        friendId = 0,
        navigateBack = {}
    )
}