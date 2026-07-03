package com.androidengineer.tiffunapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import tiffunapp.shared.generated.resources.Res
import tiffunapp.shared.generated.resources.about_faqs_terms
import tiffunapp.shared.generated.resources.download_app_store
import tiffunapp.shared.generated.resources.download_play_store
import tiffunapp.shared.generated.resources.tiffun

@Preview
@Composable
fun AboutTermsFAQs() {

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).background(color = Color(0xFFF8F8F9))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().wrapContentHeight().background(color = Color.White).padding(0.dp,0.dp,0.dp,20.dp)
        ) {

            Image(
                painterResource(Res.drawable.tiffun),
                contentDescription = "",
                modifier = Modifier.padding(13.07.dp,83.dp,0.dp,0.dp)
            )

            Image(
                modifier = Modifier.padding(0.dp,83.dp,21.dp,0.dp),
                painter = painterResource(Res.drawable.about_faqs_terms),
                contentDescription = ""
            )
        }

        ElevatedCard (
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(11.dp,34.dp,11.dp,0.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp)
        ){
            Column (
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(0.dp,15.dp,0.dp,15.dp)
            ){
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Terms",
                    fontSize = 22.sp,
                    color = Color(0xFF363B52),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    modifier = Modifier.padding(8.dp,15.dp,0.dp,0.dp),
                    text = "1. Overview to Privacy",
                    fontSize = 18.sp,
                    color = Color(0xFF363B52),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    modifier = Modifier.padding(10.dp,12.dp,10.dp,0.dp),
                    text = "Are you sure that you would like to perform this action Are you sure that you would like to perform this action Are you sure that you would like to perform this action Are you sure that you would like to perform this action",
                    fontSize = 12.sp,
                    color = Color(0xFF6F7382)
                )
            }
        }

        ElevatedCard (
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(11.dp,34.dp,11.dp,0.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp)
        ){
            Column (
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(0.dp,15.dp,0.dp,15.dp)
            ){
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "About",
                    fontSize = 22.sp,
                    color = Color(0xFF363B52),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    modifier = Modifier.padding(8.dp,15.dp,0.dp,0.dp),
                    text = "1. Overview to Privacy",
                    fontSize = 18.sp,
                    color = Color(0xFF363B52),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    modifier = Modifier.padding(10.dp,12.dp,10.dp,0.dp),
                    text = "Are you sure that you would like to perform this action Are you sure that you would like to perform this action Are you sure that you would like to perform this action Are you sure that you would like to perform this action",
                    fontSize = 12.sp,
                    color = Color(0xFF6F7382)
                )
            }
        }

        ElevatedCard (
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(11.dp,34.dp,11.dp,0.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp)
        ){
            Column (
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(0.dp,15.dp,0.dp,15.dp)
            ){
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "FAQs",
                    fontSize = 22.sp,
                    color = Color(0xFF363B52),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    modifier = Modifier.padding(8.dp,15.dp,0.dp,0.dp),
                    text = "FAQ",
                    fontSize = 18.sp,
                    color = Color(0xFF363B52),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    modifier = Modifier.padding(10.dp,12.dp,10.dp,0.dp),
                    text = "Are you sure that you would like to perform this action Are you sure that you would like to perform this action Are you sure that you would like to perform this action Are you sure that you would like to perform this action",
                    fontSize = 12.sp,
                    color = Color(0xFF6F7382)
                )
            }
        }

        Column (
            modifier = Modifier.fillMaxSize().padding(0.dp,35.dp,0.dp,0.dp).background(color = Color.White)
        ){
            Image(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(0.dp,34.dp,0.dp,0.dp),
                painter = painterResource(Res.drawable.tiffun),
                contentDescription = ""
            )

            Text(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(0.dp,20.dp,0.dp,0.dp),
                text = "Copyright 2019, All Rights Reserved",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0XFF6F7382)
            )

            Row (
                modifier = Modifier.wrapContentSize().align(alignment = Alignment.CenterHorizontally).padding(0.dp,29.dp,0.dp,0.dp),
            ) {

                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = "About",
                    fontSize = 14.sp,
                    color = Color(0xFF6F7382)
                )

                Text(
                    modifier = Modifier.wrapContentSize().padding(15.dp,0.dp,0.dp,0.dp),
                    text = "Terms",
                    fontSize = 14.sp,
                    color = Color(0xFF6F7382)
                )

                Text(
                    modifier = Modifier.wrapContentSize().padding(15.dp,0.dp,0.dp,0.dp),
                    text = "FAQs",
                    fontSize = 14.sp,
                    color = Color(0xFF6F7382)
                )

            }

            Text(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(0.dp,37.dp,0.dp,0.dp),
                text = "Download the Tiffun Application",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0XFF363B52)
            )

            Row (
                modifier = Modifier.wrapContentSize().align(alignment = Alignment.CenterHorizontally).padding(0.dp,15.dp,0.dp,50.dp),
            ) {
                Image(
                    painter = painterResource(Res.drawable.download_app_store),
                    contentDescription = ""
                )

                Image(
                    modifier = Modifier.wrapContentSize().padding(17.dp,0.dp,0.dp,0.dp),
                    painter = painterResource(Res.drawable.download_play_store),
                    contentDescription = ""
                )
            }
        }
    }

}