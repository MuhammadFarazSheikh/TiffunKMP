package com.androidengineer.tiffunapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import tiffunapp.shared.generated.resources.Res
import tiffunapp.shared.generated.resources.download_app_store
import tiffunapp.shared.generated.resources.download_play_store
import tiffunapp.shared.generated.resources.image_five
import tiffunapp.shared.generated.resources.image_four
import tiffunapp.shared.generated.resources.image_one
import tiffunapp.shared.generated.resources.image_seven
import tiffunapp.shared.generated.resources.image_six
import tiffunapp.shared.generated.resources.image_three
import tiffunapp.shared.generated.resources.image_two
import tiffunapp.shared.generated.resources.tiffun

@Preview
@Composable
fun GetStarted() {
    Column (
        modifier = Modifier.background(color = Color.White).verticalScroll(rememberScrollState()).fillMaxSize()
    ){
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(13.dp,50.dp,0.dp,0.dp).fillMaxWidth().wrapContentHeight()
        ){

            Row (
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.wrapContentSize().padding(0.dp, 32.dp, 0.dp, 0.dp)
            ) {
                Image(
                    painterResource(Res.drawable.tiffun),
                    contentDescription = ""
                )

                Text(
                    modifier = Modifier.align(alignment = Alignment.Bottom)
                        .padding(15.dp, 0.dp, 0.dp, 2.dp),
                    text = "Corporate",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF363B52)
                )
            }

            TextButton(
                modifier = Modifier.padding(0.dp,20.dp,10.dp,0.dp).width(120.dp).background(color = Color(0xFFE84B4B), shape = RoundedCornerShape(5.dp)).fillMaxWidth().wrapContentHeight(),
                onClick = {},
                content = {
                    Text(
                        text = "Get Started",
                        fontSize = 12.sp,
                        color = Color(0xFFFFFFFF),
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(0.dp,25.dp,0.dp,0.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxWidth().height(316.dp).drawWithContent {
                    drawContent()
                    drawRect(color = Color(0xB2363B52))
                },
                painter = painterResource(Res.drawable.image_one),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.wrapContentSize().wrapContentSize().padding(0.dp,40.dp,0.dp,0.dp)
            ) {

                Text(
                    text = "A new way to eat for the\ncompany",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier.wrapContentSize().padding(0.dp, 15.dp, 0.dp, 0.dp),
                    text = "Provide the best food for employees, increase\nproductivity and work time efficiency.",
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                TextButton(
                    modifier = Modifier.width(162.dp).padding(0.dp, 20.dp, 0.dp, 0.dp)
                        .background(color = Color(0xFFE84B4B), shape = RoundedCornerShape(5.dp))
                        .fillMaxWidth().wrapContentHeight(),
                    onClick = {},
                    content = {
                        Text(
                            text = "Get Started",
                            fontSize = 15.sp,
                            color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            }
        }

        Text(
            modifier = Modifier.wrapContentSize().padding(10.dp,26.dp, 10.dp,0.dp),
            text = "Employees are more productive",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        Text(
            modifier = Modifier.wrapContentSize().padding(10.dp,26.dp, 10.dp,0.dp),
            text = "Employees are free to choose their own food so they no longer need to bother looking for food.",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6F7382)
        )

        Image(
            modifier = Modifier.fillMaxWidth().height(340.dp).padding(10.dp,30.dp,10.dp,0.dp).clip(shape = RoundedCornerShape(10.dp)),
            painter = painterResource(Res.drawable.image_one),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier.wrapContentSize().padding(10.dp,30.dp, 10.dp,0.dp),
            text = "Free from company eating complaints",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        Text(
            modifier = Modifier.wrapContentSize().padding(10.dp,26.dp, 10.dp,0.dp),
            text = "The Tiffuna Customer Experience Team is ready to help deal with complaints about company food.",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6F7382)
        )

        Image(
            modifier = Modifier.fillMaxWidth().height(340.dp).padding(10.dp,60.dp,10.dp,0.dp).clip(shape = RoundedCornerShape(10.dp)),
            painter = painterResource(Res.drawable.image_two),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier.wrapContentSize().padding(10.dp,31.dp, 10.dp,0.dp),
            text = "Lots of food choices",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        Text(
            modifier = Modifier.wrapContentSize().padding(10.dp,22.dp, 10.dp,0.dp),
            text = "More than 80 lunch vendors are ready to accompany your company lunch every day.",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6F7382)
        )

        Image(
            modifier = Modifier.fillMaxWidth().height(340.dp).padding(10.dp,60.dp,10.dp,0.dp).clip(shape = RoundedCornerShape(10.dp)),
            painter = painterResource(Res.drawable.image_three),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(0.dp,30.dp,0.dp,0.dp).background(color = Color(0xFFF8F8F9)).fillMaxWidth().wrapContentHeight()
        ) {

            Text(
                modifier = Modifier.wrapContentSize().padding(7.dp,31.dp, 7.dp,0.dp),
                text = "Reasons to choose Tiffun\nCorporate Catering?",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF363B52),
                textAlign = TextAlign.Center
            )

            Image(
                modifier = Modifier.padding(0.dp,30.dp,0.dp,0.dp),
                painter = painterResource(Res.drawable.image_four),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp),
                text = "Save a budget of up to 30%",
                fontSize = 20.sp,
                color = Color(0xFF363B52),
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(0.dp,25.dp,0.dp,0.dp),
                text = "Pay as you ordered so your company can\nsave up to 30% on the budget",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0XFF6F7382),
                textAlign = TextAlign.Center
            )

            Image(
                modifier = Modifier.padding(0.dp,30.dp,0.dp,0.dp),
                painter = painterResource(Res.drawable.image_five),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp),
                text = "Reduce food waste in the office",
                fontSize = 20.sp,
                color = Color(0xFF363B52),
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(0.dp,25.dp,0.dp,0.dp),
                text = "PReducing food waste because every employee\nonly orders food as needed.",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0XFF6F7382),
                textAlign = TextAlign.Center
            )

            Image(
                modifier = Modifier.padding(0.dp,30.dp,0.dp,0.dp),
                painter = painterResource(Res.drawable.image_five),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp),
                text = "Reduce food waste in the office",
                fontSize = 20.sp,
                color = Color(0xFF363B52),
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(0.dp,25.dp,0.dp,0.dp),
                text = "Reducing food waste because every employee\nonly orders food as needed.",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0XFF6F7382),
                textAlign = TextAlign.Center
            )

            Image(
                modifier = Modifier.padding(0.dp,30.dp,0.dp,0.dp),
                painter = painterResource(Res.drawable.image_six),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp),
                text = "Flexibility for companies",
                fontSize = 20.sp,
                color = Color(0xFF363B52),
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(0.dp,25.dp,0.dp,0.dp),
                text = "Set a dining budget according to company\nbudget so much easier",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0XFF6F7382),
                textAlign = TextAlign.Center
            )

            Image(
                modifier = Modifier.padding(0.dp,30.dp,0.dp,0.dp),
                painter = painterResource(Res.drawable.image_seven),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp),
                text = "Guaranteed lunch",
                fontSize = 20.sp,
                color = Color(0xFF363B52),
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(0.dp,25.dp,0.dp,31.dp),
                text = "Food in Kulina has a guaranteed quality and\ndelivery that can be claimed easily",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0XFF6F7382),
                textAlign = TextAlign.Center
            )
        }

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