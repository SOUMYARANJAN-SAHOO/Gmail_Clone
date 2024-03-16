package com.soumyaranjan.gmailclone.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.soumyaranjan.gmailclone.R
import com.soumyaranjan.gmailclone.accountList
import com.soumyaranjan.gmailclone.models.Account

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false },
        properties = DialogProperties(dismissOnClickOutside = false)){
        AccountDialogUI(Modifier, openDialog)
    }
}

@Composable
fun AccountDialogUI(modifier: Modifier, openDialog: MutableState<Boolean>) {
    Card {
        Column(
            modifier
                .background(Color.White)
                .padding(bottom = 16.dp)
        ){
            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(onClick = { openDialog.value = false }) {
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = "Close Dialog")
                }
                Image(painter = painterResource(id = R.drawable.google_2015_logo),
                    contentDescription = "Google Image",
                    modifier
                        .size(30.dp)
                        .weight(2.0f))
            }

            Row(modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp)) {
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(color = Color.Gray)
                )
                Column(
                    modifier
                        .weight(2.0f)
                        .padding(start = 16.dp, bottom = 16.dp)
                ) {
                    Text(text = "Soumyaranjan Sahoo", fontWeight = FontWeight.SemiBold)
                    Text(text = "sahusoumyaranjans123@gmail.com")
                }
                Text(text = "99+", modifier = Modifier.padding(end = 16.dp))
            }
            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = Color.Gray)
                ) {
                    Text(
                        text = "Google Account",
                        modifier.padding(8.dp).fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier.width(10.dp))
            }
            Divider(modifier.padding(top = 16.dp))

            Column {
                AccountItem(accountList[1])
                AccountItem(accountList[2])
            }
            AddAccount(icon = Icons.Default.Person,
                title = "Add Another Account")
            AddAccount(
                icon = Icons.Outlined.Phone,
                title = "Manage Accounts"
            )
            Divider(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Privacy Policy")
                Card(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(3.dp)
                        .background(Color.Black),
                    shape = CircleShape
                ) {
                }
                Text(text = "Terms Of Service")
            }
        }
    }
}

@Composable
fun AccountItem(account: Account) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, top = 16.dp)) {
        if (account.icon != null) {
            Image(
                imageVector = account.icon,
                contentDescription = "Profile",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color.Gray)
            )
        }else{
            Card(modifier = Modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)){

                Text(text = account.userName[0].toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                        .fillMaxSize())
            }
        }
        Column(
            modifier = Modifier
                .weight(2.0f)
                .padding(start = 16.dp, bottom = 16.dp)
        ) {
            Text(text = account.userName,fontWeight = FontWeight.SemiBold)
            Text(text = account.email)
        }

        Text(text = "${account.unReadMails}+", modifier = Modifier.padding(end = 16.dp))
    }
}

@Composable
fun AddAccount(icon: ImageVector, title:String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp)) {
        IconButton(onClick = {  }) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        Text(text = title,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 8.dp,start = 8.dp))
    }
}
