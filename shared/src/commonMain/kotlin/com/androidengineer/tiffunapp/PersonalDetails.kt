package com.androidengineer.tiffunapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun PersonalDetails(
    onNextClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var organization by remember { mutableStateOf("") }
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
            modifier = Modifier.padding(15.dp,24.dp,0.dp,0.dp),
            text = "Personal Details",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        Text(
            modifier = Modifier.padding(14.dp,29.dp,0.dp,0.dp),
            text = "Name",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        TextField(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(15.dp,5.dp,46.dp,0.dp),
            value = name,
            onValueChange = { text ->
                name = text
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color(0xFFE84B4B),
                unfocusedIndicatorColor = Color(0xFFCFCCD9)
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Text(
            modifier = Modifier.padding(15.dp,30.dp,0.dp,0.dp),
            text = "Email",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        TextField(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(15.dp,5.dp,46.dp,0.dp),
            value = email,
            onValueChange = { text ->
                email = text
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color(0xFFE84B4B),
                unfocusedIndicatorColor = Color(0xFFCFCCD9)
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Text(
            modifier = Modifier.padding(15.dp,3.dp,0.dp,0.dp),
            text = "Your work email, if you have any",
            fontSize = 12.sp
        )

        Text(
            modifier = Modifier.padding(15.dp,26.dp,0.dp,0.dp),
            text = "Organization",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        TextField(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(15.dp,5.dp,46.dp,0.dp),
            value = organization,
            onValueChange = { text ->
                organization = text
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color(0xFFE84B4B),
                unfocusedIndicatorColor = Color(0xFFCFCCD9)
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Text(
            modifier = Modifier.padding(15.dp,26.dp,0.dp,0.dp),
            text = "Password",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        TextField(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(15.dp,5.dp,46.dp,0.dp),
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
                onNextClick.invoke()
            },
            content = {
                Text(
                    text = "Next",
                    fontSize = 15.sp,
                    color = Color(0xFFFFFFFF),
                    fontWeight = FontWeight.Bold
                )
            }
        )
    }
}