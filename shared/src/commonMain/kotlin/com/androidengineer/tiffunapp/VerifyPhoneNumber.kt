package com.androidengineer.tiffunapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import tiffunapp.shared.generated.resources.Res
import tiffunapp.shared.generated.resources.tiffun
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign

@Composable
fun VerifyPhoneNumber(
    onNextClick: (String, String, String) -> Unit,
    countryCode: String,
    phoneNumber: String,
    countryEmoji: String
) {
    Column (
        modifier = Modifier.background(color = Color.White).fillMaxSize()
    ){
        val multiColorText = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF6F7382),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Please enter verification code sent\n")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(0xFFE84B4B),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("${countryCode}xxxxxxxxxxxxx")
            }
        }
        Image(
            painterResource(Res.drawable.tiffun),
            contentDescription = "",
            modifier = Modifier.padding(13.07.dp,48.dp,0.dp,0.dp)
        )

        Text(
            modifier = Modifier.padding(15.dp,60.dp,0.dp,0.dp),
            text = "Please Verify",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        Text(
            modifier = Modifier.padding(13.dp,18.dp,0.dp,0.dp),
            text = multiColorText,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        OtpPinInput(
            onPinComplete = {

            },
            modifier = Modifier.padding(14.dp,33.dp,0.dp,0.dp)
        )

        TextButton(
            modifier = Modifier.padding(14.dp,20.dp,15.dp,0.dp).background(color = Color(0xFFE84B4B), shape = RoundedCornerShape(5.dp)).fillMaxWidth().wrapContentHeight(),
            onClick = {
                onNextClick.invoke(countryCode, phoneNumber, countryEmoji)
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

        Text(
            modifier = Modifier.wrapContentSize().padding(0.dp,33.dp,0.dp,0.dp).align(Alignment.CenterHorizontally),
            text = "Resend Code",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF7B8387)
        )

        Text(
            modifier = Modifier.wrapContentSize().padding(0.dp,3.41.dp,0.dp,0.dp).align(Alignment.CenterHorizontally),
            text = "00:30",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE84B4B)
        )
    }
}

@Composable
fun OtpPinInput(
    onPinComplete: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // 1. Maintain individual states for the 4 slots
    val codeLength = 4
    val pinValues = remember { mutableStateListOf("", "", "", "") }

    // 2. Generate focus controllers for each individual box
    val focusRequesters = remember { List(codeLength) { FocusRequester() } }

    Row(
        modifier = modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (index in 0 until codeLength) {
            TextField(
                value = pinValues[index],
                onValueChange = { newValue ->
                    // Prevent entering more than 1 character per box
                    val sanitizedText = newValue.trim().takeLast(1)

                    if (sanitizedText.isNotEmpty()) {
                        pinValues[index] = sanitizedText

                        // Auto-move cursor forward to the next input box
                        if (index < codeLength - 1) {
                            focusRequesters[index + 1].requestFocus()
                        }
                    } else {
                        // Handle manual clearing deletion gracefully
                        pinValues[index] = ""
                    }

                    // Trigger callback once all 4 digits are typed out completely
                    val completePin = pinValues.joinToString("")
                    if (completePin.length == codeLength) {
                        onPinComplete(completePin)
                    }
                },
                modifier = Modifier
                    .size(width = 64.dp, height = 68.dp) // Proportional sizing based on your Figma snapshot
                    .focusRequester(focusRequesters[index])
                    .border(
                        width = 1.dp,
                        color = Color(0xFFCFCCD9), // Soft border matching your UI structure
                        shape = RoundedCornerShape(8.dp)
                    )
                    // Edge Case Optimization: Catch hardware backspaces to step backward natively
                    .onKeyEvent { keyEvent ->
                        if (keyEvent.type == KeyEventType.KeyDown && keyEvent.key == Key.Backspace) {
                            if (pinValues[index].isEmpty() && index > 0) {
                                pinValues[index - 1] = "" // Clear preceding block
                                focusRequesters[index - 1].requestFocus() // Move cursor backward
                                true
                            } else {
                                false
                            }
                        } else {
                            false
                        }
                    },
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF363B52), // Text color matching your app theme
                    textAlign = TextAlign.Center
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword // Displays the safe numeric-only keypad pad
                ),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent, // Stripping native material lines away
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
    }

    // Launch initial focus assignment on first screen mount phase
    LaunchedEffect(Unit) {
        focusRequesters[0].requestFocus()
    }
}