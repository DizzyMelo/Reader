package com.study.reader.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.study.reader.components.ReaderAppBar
import com.study.reader.model.MBook
import com.study.reader.navigation.AppScreens
import com.study.reader.utils.AppColors
import com.study.reader.utils.Utils

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
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
    val currentUserName: String = Utils.getUserName()
    Column(modifier = Modifier.padding(2.dp), verticalArrangement = Arrangement.SpaceEvenly) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .align(alignment = Alignment.Start)
                .fillMaxWidth()
        ) {
            TitleSection(label = "Your reading activity right now...")
            Column(
                modifier = Modifier.fillMaxWidth(.35f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "My Account",
                    modifier = Modifier
                        .clickable {
                            navController.navigate(AppScreens.StatsScreen.name)
                        }
                        .size(45.dp),
                    tint = MaterialTheme.colors.secondaryVariant
                )
                Text(
                    text = currentUserName,
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.overline,
                    color = Color.Red,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Divider()
            }
        }
    }
}

@Composable
fun TitleSection(modifier: Modifier = Modifier, label: String) {
    Surface(modifier = modifier.padding(start = 5.dp, top = 1.dp)) {
        Column {
            Text(
                text = label,
                fontSize = 19.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth(.5f)
            )
        }
    }
}

@Composable
fun ReadingRightNowArea(books: List<MBook>, navController: NavController) {

}

@Composable
fun FABContent(onTap: () -> Unit) {
    FloatingActionButton(
        onClick = { onTap.invoke() },
        shape = CircleShape,
        backgroundColor = AppColors.LightBlue
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add a book",
            tint = Color.White
        )
    }
}
