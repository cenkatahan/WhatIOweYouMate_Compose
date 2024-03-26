package com.ata.whatioweyoumate.navigation

sealed class Screen(val route: String) {

    object Home : Screen("Home")
    object Add : Screen("Add")
    object Update : Screen("Update")
    object Summary : Screen("Summary")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }

}