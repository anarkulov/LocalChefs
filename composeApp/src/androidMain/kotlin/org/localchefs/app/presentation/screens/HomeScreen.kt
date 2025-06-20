package org.localchefs.app.presentation.screens

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.launch
import org.localchefs.app.Constants.Navigation.CHEFS
import org.localchefs.app.Constants.Navigation.READY_DISHES
import org.localchefs.app.R
import org.localchefs.app.domain.location.AndroidGeocoderWrapper
import org.localchefs.app.rememberImeState
import org.localchefs.app.shared.presentation.home.HomeViewModel

@Composable
fun HomeScreen(
    onNavigationClick: (String) -> Unit,
    onSearchLocation: (Float, Float, Int) -> Unit
) {
    val context = LocalContext.current
    val viewModel: HomeViewModel = viewModel()
    val state by viewModel.state.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val imeState = rememberImeState()

    val orange = Color(0xFFFF7A00)
    val blueGray = Color(0xFF232F3E)
    val gridBrush = Brush.linearGradient(
        colors = listOf(blueGray, blueGray.copy(alpha = 0.9f)),
        start = Offset.Zero,
        end = Offset.Infinite
    )

    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value) scrollState.animateScrollTo(scrollState.maxValue)
    }

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            if (granted) {
                coroutineScope.launch {
                    viewModel.findUserLocation(AndroidGeocoderWrapper(context))
                }
            } else {
                val act = context as Activity
                if (ActivityCompat.shouldShowRequestPermissionRationale(act, Manifest.permission.ACCESS_FINE_LOCATION)) {
                    viewModel.showRationaleDialog(true)
                } else {
                    viewModel.showSettingsDialog(true)
                }
            }
        }
    )

    fun onFindLocationClick() {
        when {
            ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == android.content.pm.PackageManager.PERMISSION_GRANTED -> {
                coroutineScope.launch {
                    viewModel.findUserLocation(AndroidGeocoderWrapper(context))
                }
            }
            else -> locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    fun onFindCoordinatesByZipcode() {
        coroutineScope.launch {
            val success = viewModel.searchCoordinatesByZip(
                zip = state.zipCode,
                geocoder = AndroidGeocoderWrapper(context)
            )
            if (success) viewModel.triggerLocationSearch(onSearchLocation)
        }
    }

    // loading bar
    if (state.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f)),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

    // Dialog
    if (state.showRationaleDialog) {
        AlertDialog(
            onDismissRequest = { viewModel.showRationaleDialog(false) },
            title = { Text("Location Permission Needed") },
            text = { Text("We need your location to find chefs near you.") },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.showRationaleDialog(false)
                    locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }) { Text("Allow") }
            },
            dismissButton = {
                TextButton(onClick = { viewModel.showRationaleDialog(false) }) { Text("Cancel") }
            }
        )
    }
    if (state.showSettingsDialog) {
        AlertDialog(
            onDismissRequest = { viewModel.showSettingsDialog(false) },
            title = { Text("Permission Denied") },
            text = { Text("Please enable location permission in settings.") },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.showSettingsDialog(false)
                    context.startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                        data = Uri.fromParts("package", context.packageName, null)
                    })
                }) { Text("Open Settings") }
            },
            dismissButton = {
                TextButton(onClick = { viewModel.showSettingsDialog(false) }) { Text("Cancel") }
            }
        )
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
                            value = state.zipCode,
                            onValueChange = { newValue ->
                                if (newValue.length <= 5) {
                                    viewModel.updateZipCode(newValue)
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
                                onClick = { viewModel.toggleDistanceMenu() },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                            ) {
                                Text(
                                    text = "${state.selectedDistance} miles",
                                    color = Color.Black,
                                    fontSize = 14.sp
                                )
                            }
                            DropdownMenu(
                                expanded = state.isDistanceMenuExpanded,
                                onDismissRequest = { viewModel.toggleDistanceMenu() },
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
                                            viewModel.setDistance(distance)
                                        }
                                    )
                                }
                            }
                        }
                    }
                    if (state.error != null) {
                        Text(
                            text = state.error!!,
                            color = Color.Red,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 8.dp),
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Button(
                            onClick = {
                                onFindCoordinatesByZipcode()
                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = orange),
                            enabled = viewModel.isValidZipCode(),
                            modifier = Modifier
                                .height(56.dp)
                                .weight(1f)
                        ) {
                            Text("Search", color = Color.White)
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
        onSearchLocation = { _, _, _ -> }
    )
}