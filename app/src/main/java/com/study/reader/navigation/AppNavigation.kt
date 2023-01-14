package com.study.reader.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.study.reader.screens.details.BookDetailsScreen
import com.study.reader.screens.home.HomeScreen
import com.study.reader.screens.login.LoginScreen
import com.study.reader.screens.search.SearchScreen
import com.study.reader.screens.splash.SplashScreen
import com.study.reader.screens.stats.StatsScreen
import com.study.reader.screens.update.UpdateScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name) {
        composable(route = AppScreens.SplashScreen.name) {
            SplashScreen(navController)
        }
        composable(route = AppScreens.LoginScreen.name) {
            LoginScreen(navController)
        }
        composable(route = AppScreens.HomeScreen.name) {
            HomeScreen(navController)
        }
        composable(route = AppScreens.BookDetailsScreen.name) {
            BookDetailsScreen(navController)
        }
        composable(route = AppScreens.SearchScreen.name) {
            SearchScreen(navController)
        }
        composable(route = AppScreens.StatsScreen.name) {
            StatsScreen(navController)
        }
        composable(route = AppScreens.UpdateScreen.name) {
            UpdateScreen(navController)
        }
    }
}