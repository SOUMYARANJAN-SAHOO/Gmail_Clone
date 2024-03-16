package com.soumyaranjan.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soumyaranjan.gmailclone.GmailApp
import com.soumyaranjan.gmailclone.models.BottomMenuData
import com.soumyaranjan.gmailclone.ui.theme.GmailCloneTheme

@Composable
fun BottomAppBarMenu() {
    val items = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                BottomAppBarItem(
                    bottomMenuData = item
                )
            }
        }
}

@Composable
fun BottomAppBarItem(bottomMenuData: BottomMenuData) {
    Box(Modifier.clickable {  }) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = bottomMenuData.icon,
                contentDescription = bottomMenuData.title
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = bottomMenuData.title)
        }
    }
}

