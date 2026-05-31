package com.androidengineer.tiffunapp

import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import tiffunapp.shared.generated.resources.Res
import tiffunapp.shared.generated.resources.tiffun
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle

@Preview
@Composable
fun UserPhoneNumber() {
    var phoneNumber by remember { mutableStateOf("")}
    val multiColorText = buildAnnotatedString {
        // 1. Standard dark gray text portion
        withStyle(
            style = SpanStyle(
                color = Color(0xFF6F7382), // Gray color matching your placeholders
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        ) {
            append("By pressing Next, I agree to Tiffun's ")
        }

        // 2. The legal text portion styled in your specific Red branding
        withStyle(
            style = SpanStyle(
                color = Color(0xFFE84B4B), // Your custom red color from your TextField indicator
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold // Optional: bolder text makes it stand out as interactive
            )
        ) {
            append("terms and conditions")
        }
    }
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
            text = "Lets get started",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        Text(
            modifier = Modifier.padding(16.31.dp,11.79.dp,0.dp,0.dp),
            text = "Please create your account to get started",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6F7382)
        )

        Row (
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(17.dp,47.21.dp,0.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            CountryPicker(
                onCountrySelected = {

                }
            )

            VerticalDivider(
                modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp).height(29.dp),
                thickness = 0.6.dp,
                color = Color(0xFFC4C4C4)
            )

            TextField(
                modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                value = phoneNumber,
                onValueChange = { text ->
                    phoneNumber = text
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
        }

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth().padding(17.dp,15.dp,17.dp,0.dp),
            thickness = 0.6.dp,
            color = Color(0xFFCFCCD9)
        )

        TextButton(
            modifier = Modifier.padding(15.dp,49.dp,15.dp,40.dp).background(color = Color(0xFFE84B4B), shape = RoundedCornerShape(5.dp)).fillMaxWidth().wrapContentHeight(),
            onClick = {},
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
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(17.dp,46.dp,17.dp,0.dp),
            text = multiColorText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

// Clean Domain Model
data class CountryInfo(
    val code: String,       // e.g. "PK"
    val phoneCode: String,  // e.g. "+92"
    val flagEmoji: String   // e.g. "🇵🇰"
)

// State Saver for configuration changes (like screen rotation)
val CountryInfoSaver = mapSaver(
    save = { mapOf("code" to it.code, "phoneCode" to it.phoneCode, "flagEmoji" to it.flagEmoji) },
    restore = { CountryInfo(it["code"] as String, it["phoneCode"] as String, it["flagEmoji"] as String) }
)

// Optimized Single-Instance Data Provider
object CountryRepository {
    val countries: List<CountryInfo> = listOf(
        CountryInfo("PK", "+92", "🇵🇰"),
        CountryInfo("US", "+1", "🇺🇸"),
        CountryInfo("GB", "+44", "🇬🇧"),
        CountryInfo("AE", "+971", "🇦🇪"),
        CountryInfo("SA", "+966", "🇸🇦"),
        CountryInfo("CA", "+1", "🇨🇦"),
        CountryInfo("AU", "+61", "🇦🇺"),
        CountryInfo("DE", "+49", "🇩🇪"),
        CountryInfo("FR", "+33", "🇫🇷"),
        CountryInfo("IT", "+39", "🇮🇹"),
        CountryInfo("ES", "+34", "🇪🇸"),
        CountryInfo("PT", "+351", "🇵🇹"),
        CountryInfo("IN", "+91", "🇮🇳"),
        CountryInfo("CN", "+86", "🇨🇳"),
        CountryInfo("JP", "+81", "🇯🇵"),
        CountryInfo("BR", "+55", "🇧🇷"),
        CountryInfo("ZA", "+27", "🇿🇦"),
        CountryInfo("NZ", "+64", "🇳🇿"),
        CountryInfo("SG", "+65", "🇸🇬"),
        CountryInfo("MY", "+60", "🇲🇾"),
        CountryInfo("ID", "+62", "🇮🇩"),
        CountryInfo("TR", "+90", "🇹🇷"),
        CountryInfo("NL", "+31", "🇳🇱"),
        CountryInfo("CH", "+41", "🇨🇭"),
        CountryInfo("SE", "+46", "🇸🇪"),
        CountryInfo("NO", "+47", "🇳🇴"),
        CountryInfo("FI", "+358", "🇫🇮"),
        CountryInfo("DK", "+45", "🇩🇰"),
        CountryInfo("IE", "+353", "🇮🇪"),
        CountryInfo("MX", "+52", "🇲🇽"),
        CountryInfo("AR", "+54", "🇦🇷"),
        CountryInfo("CO", "+57", "🇨🇴"),
        CountryInfo("EG", "+20", "🇪🇬"),
        CountryInfo("NG", "+234", "🇳🇬"),
        CountryInfo("KE", "+254", "🇰🇪"),
        CountryInfo("BD", "+880", "🇧🇩"),
        CountryInfo("LK", "+94", "🇱🇰"),
        CountryInfo("PH", "+63", "🇵🇭"),
        CountryInfo("TH", "+66", "🇹🇭"),
        CountryInfo("VN", "+84", "🇻🇳")
    ).sortedBy { it.code } // Pre-sorted at initialization phase
}

@Composable
fun CountryPicker(
    onCountrySelected: (CountryInfo) -> Unit,
    modifier: Modifier = Modifier
) {
    // rememberSaveable ensures the selection survives configuration changes or system theme switches
    var selectedCountry by rememberSaveable(stateSaver = CountryInfoSaver) {
        mutableStateOf(CountryRepository.countries.first { it.code == "PK" })
    }
    var isDropdownExpanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        // Trigger Box
        Row(
            modifier = Modifier
                .clickable { isDropdownExpanded = true }
                .padding(vertical = 8.dp, horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = selectedCountry.flagEmoji,
                fontSize = 20.sp
            )
            Text(
                text = selectedCountry.phoneCode,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Overlay Picker Window
        DropdownMenu(
            expanded = isDropdownExpanded,
            onDismissRequest = { isDropdownExpanded = false },
            modifier = Modifier.heightIn(max = 260.dp) // Bound height limit natively
        ) {
            CountryRepository.countries.forEach { country ->
                DropdownMenuItem(
                    text = {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = country.flagEmoji, fontSize = 18.sp)
                            Text(
                                text = "${country.code} (${country.phoneCode})",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    },
                    onClick = {
                        selectedCountry = country
                        isDropdownExpanded = false
                        onCountrySelected(country) // Emit update up to parent cleanly
                    },
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}