package com.androidengineer.tiffunapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import tiffunapp.shared.generated.resources.Res
import tiffunapp.shared.generated.resources.arrow_down
import tiffunapp.shared.generated.resources.tiffun

@Composable
@Preview
fun App() {
    var companyName by rememberSaveable{ mutableStateOf("") }
    MaterialTheme {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(Color.White)
                .fillMaxSize()
        ) {

            Row (
                modifier = Modifier.padding(13.dp,48.dp,0.dp,0.dp).wrapContentSize()
            ){
                Image(
                    painterResource(Res.drawable.tiffun),
                    contentDescription = ""
                )

                Text(
                    modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp),
                    text = "Corporate",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF363B52)
                )
            }

            Text(
                modifier = Modifier.padding(15.dp,20.dp,0.dp,0.dp),
                text = "Corporate Catering Signup",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF363B52)
            )

            Text(
                modifier = Modifier.padding(16.31.dp,24.79.dp,0.dp,0.dp),
                text = "We will contact you as soon as you fill the form.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6F7382)
            )

            Text(
                modifier = Modifier.padding(17.2.dp, 40.21.dp,0.dp,0.dp),
                text = "Company name",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF363B52)
            )

            TextField(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(17.dp,0.dp,17.dp,0.dp),
                value = companyName,
                onValueChange = { text ->
                    companyName = text
                },
                placeholder = {
                    Text(
                        text = "e.g: xyz",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF7B8387)
                    )
                },
                colors = TextFieldDefaults.colors(
                    cursorColor = Color(0xFF7B8387),
                    focusedIndicatorColor = Color(0xFFE84B4B),
                    unfocusedIndicatorColor = Color(0xFFCFCCD9),
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                singleLine = true
            )

            Text(
                modifier = Modifier.padding(17.2.dp, 29.27.dp,0.dp,0.dp),
                text = "City /Company Location",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF363B52)
            )

            TextField(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(17.dp,0.dp,17.dp,0.dp),
                value = companyName,
                onValueChange = { text ->
                    companyName = text
                },
                placeholder = {
                    Text(
                        text = "e.g: xyz",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF7B8387)
                    )
                },
                colors = TextFieldDefaults.colors(
                    cursorColor = Color(0xFF7B8387),
                    focusedIndicatorColor = Color(0xFFE84B4B),
                    unfocusedIndicatorColor = Color(0xFFCFCCD9),
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                singleLine = true
            )

            Text(
                modifier = Modifier.padding(17.2.dp, 32.27.dp,0.dp,0.dp),
                text = "Number of employees",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF363B52)
            )

            Row (
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(17.2.dp, 12.62.dp,17.2.dp,0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Please select",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7B8387),
                )

                Icon(
                    modifier = Modifier.padding(0.dp,0.dp,15.dp,0.dp).size(12.dp),
                    painter = painterResource(Res.drawable.arrow_down),
                    contentDescription = ""
                )
            }

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth().padding(17.dp,13.11.dp,17.dp,0.dp),
                thickness = 0.6.dp,
                color = Color(0xFFCFCCD9)
            )

            Text(
                modifier = Modifier.padding(17.2.dp, 39.27.dp,0.dp,0.dp),
                text = "PIC Name",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF363B52)
            )

            TextField(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(17.dp,0.dp,17.dp,0.dp),
                value = companyName,
                onValueChange = { text ->
                    companyName = text
                },
                placeholder = {
                    Text(
                        text = "e.g: xyz",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF7B8387)
                    )
                },
                colors = TextFieldDefaults.colors(
                    cursorColor = Color(0xFF7B8387),
                    focusedIndicatorColor = Color(0xFFE84B4B),
                    unfocusedIndicatorColor = Color(0xFFCFCCD9),
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                singleLine = true
            )

            Text(
                modifier = Modifier.padding(17.2.dp, 32.27.dp,0.dp,0.dp),
                text = "PIC Email Address",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF363B52)
            )

            TextField(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(17.dp,0.dp,17.dp,0.dp),
                value = companyName,
                onValueChange = { text ->
                    companyName = text
                },
                placeholder = {
                    Text(
                        text = "e.g: xyz",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF7B8387)
                    )
                },
                colors = TextFieldDefaults.colors(
                    cursorColor = Color(0xFF7B8387),
                    focusedIndicatorColor = Color(0xFFE84B4B),
                    unfocusedIndicatorColor = Color(0xFFCFCCD9),
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                singleLine = true
            )

            Text(
                modifier = Modifier.padding(17.2.dp, 39.27.dp,0.dp,0.dp),
                text = "PIC Telephone Number",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF363B52)
            )

            TextField(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(17.dp,0.dp,17.dp,0.dp),
                value = companyName,
                onValueChange = { text ->
                    companyName = text
                },
                placeholder = {
                    Text(
                        text = "e.g: xyz",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF7B8387)
                    )
                },
                colors = TextFieldDefaults.colors(
                    cursorColor = Color(0xFF7B8387),
                    focusedIndicatorColor = Color(0xFFE84B4B),
                    unfocusedIndicatorColor = Color(0xFFCFCCD9),
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                singleLine = true
            )

            TextButton(
                modifier = Modifier.padding(15.dp,42.27.dp,15.dp,40.dp).background(color = Color(0xFFE84B4B), shape = RoundedCornerShape(5.dp)).fillMaxWidth().wrapContentHeight(),
                onClick = {},
                content = {
                    Text(
                        text = "Sign up",
                        fontSize = 15.sp,
                        color = Color(0xFFFFFFFF),
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    }
}