package com.androidengineer.tiffunapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import tiffunapp.shared.generated.resources.Res
import tiffunapp.shared.generated.resources.tiffun

@Composable
fun UserLogin(
    onLoginClicked: () -> Unit,
    countryCode: String,
    phoneNumber: String,
    countryEmoji: String
) {
    var password by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.background(color = Color.White).fillMaxSize()
    ){
        Image(
            painterResource(Res.drawable.tiffun),
            contentDescription = "",
            modifier = Modifier.padding(13.07.dp,48.dp,0.dp,0.dp)
        )

        Text(
            modifier = Modifier.padding(15.dp,60.dp,0.dp,0.dp),
            text = "Login",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        Text(
            modifier = Modifier.padding(16.31.dp,11.79.dp,0.dp,0.dp),
            text = "Please log into your account",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6F7382)
        )

        Row (
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(17.dp,47.21.dp,0.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Text(
                text = "${countryEmoji}  ${countryCode}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF363B52)
            )

            VerticalDivider(
                modifier = Modifier.padding(20.dp,0.dp,0.dp,0.dp).height(29.dp),
                thickness = 0.6.dp,
                color = Color(0xFFC4C4C4)
            )

            Text(
                modifier = Modifier.wrapContentSize().padding(25.3.dp,0.dp,0.dp,0.dp),
                text = phoneNumber,
                fontSize = 18.sp,
                color = Color(0xFF6F7382),
                fontWeight = FontWeight.Bold
            )
        }

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth().padding(17.dp,15.dp,17.dp,0.dp),
            thickness = 0.6.dp,
            color = Color(0xFFCFCCD9)
        )

        Text(
            modifier = Modifier.padding(16.2.dp,22.dp,0.dp,0.dp),
            text = "Password",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        TextField(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(16.2.dp,0.dp,16.2.dp,0.dp),
            value = password,
            onValueChange = { text ->
                password = text
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color(0xFFE84B4B),
                unfocusedIndicatorColor = Color(0xFFCFCCD9)
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        TextButton(
            modifier = Modifier.padding(15.dp,42.27.dp,15.dp,0.dp).background(color = Color(0xFFE84B4B), shape = RoundedCornerShape(5.dp)).fillMaxWidth().wrapContentHeight(),
            onClick = {
                onLoginClicked.invoke()
            },
            content = {
                Text(
                    text = "Log in",
                    fontSize = 15.sp,
                    color = Color(0xFFFFFFFF),
                    fontWeight = FontWeight.Bold
                )
            }
        )
    }
}