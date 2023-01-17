package com.study.reader.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.study.reader.navigation.AppScreens
import com.study.reader.utils.Utils

@Composable
fun ProfileIcon(navController: NavController) {
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
            text = Utils.getUserName(),
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