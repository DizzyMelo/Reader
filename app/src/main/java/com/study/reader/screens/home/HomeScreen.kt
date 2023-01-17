package com.study.reader.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.study.reader.components.FABContent
import com.study.reader.components.ProfileIcon
import com.study.reader.components.ReaderAppBar
import com.study.reader.components.TitleSection

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
    }
}

@Composable
fun BookRating(score: Double = 4.5) {
    Surface(
        modifier = Modifier
            .height(70.dp)
            .padding(4.dp), shape = RoundedCornerShape(56.dp), elevation = 6.dp, color = Color.White
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Icon(
                imageVector = Icons.Filled.StarBorder,
                contentDescription = "Rating icon",
                modifier = Modifier.padding(3.dp)
            )

            Text(text = score.toString(), style = MaterialTheme.typography.subtitle1)
        }
    }
}
