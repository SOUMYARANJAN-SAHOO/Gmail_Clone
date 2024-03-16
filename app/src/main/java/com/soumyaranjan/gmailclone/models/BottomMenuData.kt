package com.soumyaranjan.gmailclone.models


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val icon: ImageVector,
    val title: String){
    object Mail: BottomMenuData(icon = Icons.Outlined.Email, title = "Mails")
    object Meet: BottomMenuData(icon = Icons.Outlined.Call, title = "Meet")
}