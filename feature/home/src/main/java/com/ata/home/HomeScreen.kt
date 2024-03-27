package com.ata.home

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.GroupOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ata.core.ui.component.OweButton
import com.ata.core.ui.component.OweOutlinedButton
import com.ata.core.ui.component.OweText
import com.ata.core.ui.theme.OweBackground
import com.ata.core.ui.theme.OweGreen
import com.ata.home.component.EmptyList
import com.ata.home.component.FriendItem
import com.ata.home.component.TopBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToAdd: () -> Unit,
    navigateToEdit: (Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val friendListState = viewModel.friendsState.collectAsState().value

    Column(
        modifier = modifier
            .background(color = OweBackground.color())
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {

        TopBar(
            onClickAdd = {
                navigateToAdd()
            }
        )



        when (friendListState) {
            is HomeUIState.Error -> {
                EmptyList(msg = "Error. List is Empty.")
            }

            is HomeUIState.Loading -> {
                CircularProgressIndicator()
            }

            is HomeUIState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxHeight(0.9f)
                ) {
                    item {
                        val totalExpense = friendListState.data.sumOf { it.expense }
                        OweText(text = "Total  Expense: $totalExpense")
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    if (friendListState.data.isEmpty()) {
                        item {
                            EmptyList(msg = "List is Empty.")
                        }
                    }

                    items(friendListState.data.size, key = {
                        friendListState.data[it].id
                    }) {

                        Spacer(modifier = Modifier.height(8.dp))

                        val friend = friendListState.data[it]
                        FriendItem(
                            friend = friend,
                            onClickToEdit = { navigateToEdit(friend.id) },
                            onClickRemove = { viewModel.remove(friend) }
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                    }
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OweOutlinedButton(
                modifier = Modifier.fillMaxWidth(0.4f),
                text = "Delete",
                onClick = {
                    viewModel.removeAll()
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            OweButton(
                modifier = Modifier.fillMaxWidth(1f),
                text = "Calculate",
                onClick = {

                }
            )
        }
    }
}

//@Preview(name = "Light Mode")
//@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Preview(name = "Full Preview", showSystemUi = true)
//@Preview(
//    name = "Full Preview - Dark Mode",
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showSystemUi = true
//)
//@Composable
//private fun OweButtonPrev() {
//    HomeScreen(
//        navigateToAdd = {}
//    )
//}