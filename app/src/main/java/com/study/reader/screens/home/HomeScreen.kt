package com.study.reader.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.study.reader.components.*
import com.study.reader.model.MBook

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController = NavController(LocalContext.current)) {
    Scaffold(
        topBar = { ReaderAppBar(title = "A.Reader", navController = navController) },
        floatingActionButton = {
            FABContent(onTap = {})
        }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            HomeContent(navController)
        }
    }
}

@Composable
fun HomeContent(navController: NavController) {
    Column(modifier = Modifier.padding(2.dp), verticalArrangement = Arrangement.Top) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .align(alignment = Alignment.Start)
                .fillMaxWidth()
        ) {
            TitleSection(label = "Your reading activity right now...")
            ProfileIcon(navController = navController)
        }

        ReadingNowArea(
            navController = navController
        )
        
        TitleSection(label = "Reading List")

        BookListArea(
            books = listOf(
                MBook(
                    id = "book_id",
                    title = "Running",
                    authors = "Daniel Melo",
                    notes = "this is a great book",
                ),
                MBook(
                    id = "book_id",
                    title = "Running",
                    authors = "Daniel Melo",
                    notes = "this is a great book",
                ),
                MBook(
                    id = "book_id",
                    title = "Running",
                    authors = "Daniel Melo",
                    notes = "this is a great book",
                ),
            ), navController = navController
        )
    }
}
