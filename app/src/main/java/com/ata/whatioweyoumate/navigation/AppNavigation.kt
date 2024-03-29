package com.ata.whatioweyoumate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ata.add.AddScreen
import com.ata.home.HomeScreen
import com.ata.summary.SummaryScreen
import com.ata.update.UpdateScreen

@Composable
fun AppNav(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.name
    ) {
        composable(route = Screen.Home.name) {
            HomeScreen(
                navigateToAdd = {
                    navController.navigate(Screen.Add.name)
                }
            )
        }
        composable(route = Screen.Add.name) { AddScreen() }
        composable(route = Screen.Update.name) { UpdateScreen() }
        composable(route = Screen.Summary.name) { SummaryScreen() }
    }

}

enum class Screen {
    Home,
    Add,
    Update,
    Summary
}
