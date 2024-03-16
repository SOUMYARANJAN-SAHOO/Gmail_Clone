package com.soumyaranjan.gmailclone.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuData(
    val icon: ImageVector? = null, val title:String? = null,
    val isDivider:Boolean=false, val isHeader:Boolean = false
){
    object AllInboxes: DrawerMenuData(
        icon = Icons.Outlined.MailOutline,
        title = "All inboxes"
    )
    object Primary: DrawerMenuData(
        icon = Icons.Default.MailOutline,
        title = "Primary"
    )
    object Social: DrawerMenuData(
        icon = Icons.Outlined.Person,
        title = "Social"
    )
    object Promotions: DrawerMenuData(
        icon = Icons.Outlined.MailOutline,
        title = "Promotions",
    )
    object Starred: DrawerMenuData(
        icon = Icons.Outlined.MailOutline,
        title = "Starred"
    )

    object Snoozed: DrawerMenuData(
        icon = Icons.Outlined.MailOutline,
        title = "Snoozed"
    )
    object Important: DrawerMenuData(
        icon = Icons.Outlined.MailOutline,
        title = "Important"
    )
    object Sent: DrawerMenuData(
        icon = Icons.Outlined.Send,
        title = "Sent"
    )
    object Schedule: DrawerMenuData(
        icon = Icons.Outlined.MailOutline,
        title = "Scheduled"
    )
    object Outbox: DrawerMenuData(
        icon = Icons.Outlined.MailOutline,
        title = "Outbox"
    )
    object Draft: DrawerMenuData(
        icon = Icons.Outlined.MailOutline,
        title = "Drafts"
    )
    object AllMail: DrawerMenuData(
        icon = Icons.Outlined.MailOutline,
        title = "All Mail"
    )
    object Calendar: DrawerMenuData(
        icon = Icons.Outlined.DateRange,
        title = "Calendar"
    )
    object Contacts: DrawerMenuData(
        icon = Icons.Outlined.Call,
        title = "Contacts"
    )
    object Setting: DrawerMenuData(
        icon = Icons.Outlined.Settings,
        title = "Settings"
    )
    object Help: DrawerMenuData(
        icon = Icons.Outlined.Info,
        title = "Help & FeedBack"
    )

    object Divider: DrawerMenuData(
        isDivider = true
    )
    object HeaderOne: DrawerMenuData(
        isHeader = true,
        title = "ALL LABELS"
    )
    object HeaderTwo: DrawerMenuData(
        isHeader = true,
        title = "GOOGLE APPS"
    )
}