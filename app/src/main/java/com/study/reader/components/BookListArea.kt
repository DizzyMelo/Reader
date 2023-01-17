package com.study.reader.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.study.reader.model.MBook
import com.study.reader.navigation.AppScreens

@Composable
fun BookListArea(books: List<MBook>, navController: NavController) {
    HorizontalScrollableComponent(
        items = books,
        onClick = { navController.navigate(AppScreens.DetailsScreen.name) })
}