package com.soumyaranjan.gmailclone.models

import androidx.compose.ui.graphics.vector.ImageVector

data class Account(
    val icon: ImageVector? = null,
    val userName: String,
    val email: String,
    val unReadMails: Int
)