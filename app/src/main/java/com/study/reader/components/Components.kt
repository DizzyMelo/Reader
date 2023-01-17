package com.study.reader.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.study.reader.utils.AppColors

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