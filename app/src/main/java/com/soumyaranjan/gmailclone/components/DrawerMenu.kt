package com.soumyaranjan.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soumyaranjan.gmailclone.models.DrawerMenuData

@Composable
fun DrawerMenu(dp: Dp = 8.dp, scrollState: ScrollState) {
    Column(Modifier.verticalScroll(scrollState)) {
        Text(
            "Gmail",
            color = Color.Red,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )
        val menuList = listOf(
            DrawerMenuData.Divider,
            DrawerMenuData.AllInboxes,
            DrawerMenuData.Divider,
            DrawerMenuData.Primary,
            DrawerMenuData.Social,
            DrawerMenuData.Promotions,
            DrawerMenuData.HeaderOne,
            DrawerMenuData.Starred,
            DrawerMenuData.Snoozed,
            DrawerMenuData.Important,
            DrawerMenuData.Sent,
            DrawerMenuData.Schedule,
            DrawerMenuData.Outbox,
            DrawerMenuData.Draft,
            DrawerMenuData.AllMail,
            DrawerMenuData.HeaderTwo,
            DrawerMenuData.Calendar,
            DrawerMenuData.Contacts,
            DrawerMenuData.Divider,
            DrawerMenuData.Setting,
            DrawerMenuData.Help
        )
        menuList.forEach { item ->
            //Todo 24 check for what each it is and display the correct composable
            when {
                item.isDivider -> {
                    Divider(modifier = Modifier.padding(bottom = dp, top = dp))
                }

                item.isHeader -> {
                    Text(
                        text = item.title!!, fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(
                            start = 20.dp, bottom = dp,
                            top = dp
                        )
                    )

                }

                else -> {
                    MailDrawerItem(item = item)
                }
            }
        }
    }
}

@Composable
fun MailDrawerItem(item: DrawerMenuData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 16.dp)
    ) {
        //Todo 16: add weight to each item
        Image(
            imageVector = item.icon!!,
            contentDescription = item.title!!,
            modifier = Modifier.weight(0.5f)
        )
        Text(text = item.title, modifier = Modifier.weight(2.0f))
    }
}