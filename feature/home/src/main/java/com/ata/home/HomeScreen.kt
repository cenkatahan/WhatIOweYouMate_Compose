package com.ata.home

import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ata.core.ui.component.OweButton
import com.ata.core.ui.component.OweOutlinedButton
import com.ata.core.ui.component.OweText
import com.ata.core.ui.theme.OweBackground
import com.ata.home.component.FriendItem
import com.ata.home.component.TopBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToAdd: () -> Unit,
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

        OweText(text = "Total  Expense: \$0.0")
        Spacer(modifier = Modifier.height(16.dp))

        when (friendListState) {
            is HomeUIState.Error -> {
//                EmptyListSection(state.message)
            }

            is HomeUIState.Loading -> {}
            is HomeUIState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxHeight(0.9f)
                ) {

                    items(friendListState.data.size, key = {
                        friendListState.data[it].id
                    }) {
                        Spacer(modifier = Modifier.height(8.dp))

                        val friend = friendListState.data[it]
                        FriendItem(
                            friend = friend,
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