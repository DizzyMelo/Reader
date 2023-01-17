package com.study.reader.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.study.reader.model.MBook

@Composable
fun ReadingNowArea(books: List<MBook>, navController: NavController) {
    LazyRow(content = {
        items(items = books) { book ->
            ListCard(book)
        }
    })
}