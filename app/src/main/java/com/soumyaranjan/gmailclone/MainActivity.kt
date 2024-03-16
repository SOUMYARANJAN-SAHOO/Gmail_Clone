package com.soumyaranjan.gmailclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.soumyaranjan.gmailclone.components.BottomAppBarMenu
import com.soumyaranjan.gmailclone.components.ComposeFab
import com.soumyaranjan.gmailclone.components.DrawerMenu
import com.soumyaranjan.gmailclone.components.MailList
import com.soumyaranjan.gmailclone.components.TopAppBarMenu
import com.soumyaranjan.gmailclone.ui.theme.GmailCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailCloneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GmailApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GmailApp() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val openDialog = remember {
        mutableStateOf(false)
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerMenu(scrollState = scrollState)
            }
        },
    ) {
        Scaffold(
            topBar = { TopAppBarMenu(drawerState = drawerState, scope = scope, openDialog = openDialog) },
            bottomBar = { BottomAppBarMenu() },
            floatingActionButton = { ComposeFab(scrollState) },
        ) { contentPadding ->
            MailList(paddingValues = contentPadding, scrollState)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    GmailCloneTheme {
        GmailApp()
    }
}