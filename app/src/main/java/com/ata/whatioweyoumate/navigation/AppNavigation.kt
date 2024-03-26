package com.ata.whatioweyoumate.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ata.add.AddScreen
import com.ata.home.HomeScreen
import com.ata.summary.SummaryScreen
import com.ata.update.EditScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun AppNav(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                navigateToAdd = {
                    navController.navigate(Screen.Add.route)
                },
                navigateToEdit = {
                    navController.navigate(Screen.Update.withArgs(it.toString()))
                }
            )
        }
        composable(route = Screen.Add.route) {
            AddScreen(
                navigateBack = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(
            route = "${Screen.Update.route}/{friendId}",
            arguments = listOf(
                navArgument("friendId") {
                    type = NavType.IntType
                    defaultValue = 0
                    nullable = false
                }
            )
        ) { backStack ->

            val id = backStack.arguments?.getInt("friendId")
            EditScreen(
                friendId = id!!,
                navigateBack = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                }
            )

        }

        composable(route = Screen.Summary.route) { SummaryScreen() }
    }

}
