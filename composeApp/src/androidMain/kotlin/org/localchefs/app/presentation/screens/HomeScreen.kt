package org.localchefs.app.presentation.screens

import android.Manifest
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.location.LocationServices
import org.localchefs.app.Constants.Navigation.CART
import org.localchefs.app.Constants.Navigation.CHEFS
import org.localchefs.app.Constants.Navigation.HOW_IT_WORKS
import org.localchefs.app.Constants.Navigation.READY_DISHES
import org.localchefs.app.Constants.Navigation.SIGNIN
import org.localchefs.app.Constants.Navigation.SIGNUP
import org.localchefs.app.R
import org.localchefs.app.rememberImeState
import java.util.Locale

@Composable
fun HomeScreen(
    onNavigationClick: (String) -> Unit,
    onSearchZip: (String, Int) -> Unit
) {
    var milesDropDownMenuExpanded by remember { mutableStateOf(false) }
    var milesDropDownMenuSelected by remember { mutableIntStateOf(0) }
    var zipCode by remember { mutableStateOf("") }
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    val orange = Color(0xFFFF7A00)
    val blueGray = Color(0xFF232F3E)
    val gridBrush = Brush.linearGradient(
        colors = listOf(blueGray, blueGray.copy(alpha = 0.95f)),
        start = Offset.Zero, // Top-left
        end = Offset.Infinite // Effectively bottom-right for the bounds of the canvas
    )

    val context = LocalContext.current
    var error by remember { mutableStateOf<String?>(null) }

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            if (granted) {
                val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location: Location? ->
                        if (location != null) {
                            val geocoder = Geocoder(context, Locale.getDefault())
                            println("Location: ${location.latitude}, ${location.longitude}")

                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                                geocoder.getFromLocation(
                                    location.latitude,
                                    location.longitude,
                                    1
                                ) { addresses: MutableList<Address> ->
                                    if (addresses.isNotEmpty()) {
                                        val postalCode = addresses[0].postalCode
                                        if (postalCode.length == 5) {
                                            zipCode = postalCode
                                            error = null
                                        } else {
                                            error = "Invalid postal code: $postalCode"
                                        }
                                    } else {
                                        error = "No address found for the location"
                                    }
                                }
                            } else {
                                val addresses = geocoder.getFromLocation(
                                    location.latitude,
                                    location.longitude,
                                    1
                                )
                                if (!addresses.isNullOrEmpty()) {
                                    val postalCode = addresses[0].postalCode
                                    if (postalCode.length == 5) {
                                        zipCode = postalCode
                                        error = null
                                    } else {
                                        error = "Invalid postal code: $postalCode"
                                    }
                                } else {
                                    error = "No address found for the location"
                                }
                            }
                        } else {
                            error = "Location not available"
                        }
                    }
                    .addOnFailureListener {
                        error = "Failed to get location: ${it.localizedMessage}"
                    }
            } else {
                error = "Location permission denied"
            }
        }
    )

    fun onFindLocationClick() {
        locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value) {
            scrollState.animateScrollTo(scrollState.maxValue, tween(250))
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gridBrush)
            .verticalScroll(scrollState)
    ) {
        // Hero Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Local Chefs",
                color = orange,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Authentic Food from Home Chefs",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = "Browse menus, reserve meals, or book special services like catering, meal prep, or hibachi. Pre-schedule for tomorrow—or grab what's freshly made today.",
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 12.dp, bottom = 20.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { onNavigationClick(CHEFS) },
                    colors = ButtonDefaults.buttonColors(containerColor = orange),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("All Chefs", color = Color.White)
                }
                Spacer(modifier = Modifier.width(12.dp))
                OutlinedButton(
                    onClick = { onNavigationClick(READY_DISHES) },
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, color = orange),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Ready Dishes", color = Color.White)
                }
            }
            // ZIP Code Search Box
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.25f))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_location_pin),
                            contentDescription = "Location Icon",
                            tint = Color.Black,
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Find Home Chefs Near You",
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        OutlinedTextField(
                            value = zipCode,
                            onValueChange = { newValue ->
                                if (newValue.length <= 5) {
                                    zipCode = newValue
                                }
                            },
                            placeholder = {
                                Text(
                                    color = Color.White.copy(alpha = 0.5f),
                                    text = "Enter ZIP Code"
                                )
                            },
                            singleLine = true,
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(10.dp),
                            // input field type
                            keyboardOptions = KeyboardOptions(
                                autoCorrectEnabled = true,
                                keyboardType = KeyboardType.Number,
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = orange,
                                unfocusedBorderColor = Color.White.copy(alpha = 0.5f),
                                cursorColor = orange,
                                focusedLabelColor = orange
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(0.4f)
                                .background(Color.White, shape = RoundedCornerShape(10.dp))
                        ) {
                            TextButton(
                                onClick = { milesDropDownMenuExpanded = true },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                            ) {
                                Text(
                                    text = "$milesDropDownMenuSelected miles",
                                    color = Color.Black,
                                    fontSize = 14.sp
                                )
                            }
                            DropdownMenu(
                                expanded = milesDropDownMenuExpanded,
                                onDismissRequest = { milesDropDownMenuExpanded = false },
                                modifier = Modifier.width(120.dp)
                            ) {
                                listOf(
                                    5,
                                    10,
                                    20,
                                    50
                                ).forEach { distance ->
                                    DropdownMenuItem(
                                        text = { Text("$distance miles") },
                                        onClick = {
                                            milesDropDownMenuSelected = distance
                                            milesDropDownMenuExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                    if (error != null) {
                        Text(
                            text = error ?: "Invalid ZIP Code",
                            color = Color.Red,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 8.dp),
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Button(
                            onClick = { onSearchZip(zipCode, milesDropDownMenuSelected) },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = orange),
                            enabled = zipCode.length == 5,
                            modifier = Modifier
                                .height(56.dp)
                                .weight(1f)
                        ) {
                            Text("Search ZIP", color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(
                            onClick = {
                                onFindLocationClick()
                            },
                            modifier = Modifier
                                .background(orange, shape = RoundedCornerShape(10.dp))
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_near_me),
                                contentDescription = "Use My Location",
                                tint = Color.White,
                            )
                        }
                    }
                }
            }
        }
    }
}

// setup preview:
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onNavigationClick = { _ -> },
        onSearchZip = { _, _ -> }
    )
}