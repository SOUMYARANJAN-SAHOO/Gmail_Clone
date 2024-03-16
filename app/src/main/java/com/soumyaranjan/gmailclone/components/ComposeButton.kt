package com.soumyaranjan.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.soumyaranjan.gmailclone.GmailApp
import com.soumyaranjan.gmailclone.ui.theme.GmailCloneTheme

@Composable
fun ComposeFab(scrollState: ScrollState) {
    if(scrollState.value < 100){
        FloatingActionButton(onClick = { /*TODO*/ },
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            Icon(imageVector = Icons.Default.Edit,
                contentDescription = "Compose Button")
        }
    }else{
        ExtendedFloatingActionButton(
            text = { Text(text = "Compose", fontSize = 16.sp) },
            icon = { Icon(imageVector = Icons.Default.Edit,
                contentDescription = "Compose Button") },
            onClick = { /*TODO*/ },
            containerColor = MaterialTheme.colorScheme.surface)
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    GmailCloneTheme {
        GmailApp()
    }
}