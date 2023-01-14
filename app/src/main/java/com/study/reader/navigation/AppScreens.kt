package com.study.reader.navigation

enum class AppScreens {
    SplashScreen,
    LoginScreen,
    SignupScreen,
    HomeScreen,
    SearchScreen,
    StatsScreen,
    UpdateScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): AppScreens =
            when(route?.substringBefore("/")) {
                SplashScreen.name -> SplashScreen
                LoginScreen.name -> LoginScreen
                SignupScreen.name -> SignupScreen
                HomeScreen.name -> HomeScreen
                SearchScreen.name -> SearchScreen
                DetailsScreen.name -> DetailsScreen
                UpdateScreen.name -> UpdateScreen
                StatsScreen.name -> StatsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route: $route is not recognized")
            }
    }

}