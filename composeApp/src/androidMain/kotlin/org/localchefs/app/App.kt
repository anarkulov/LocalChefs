package org.localchefs.app

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.localchefs.app.Constants.Navigation.CART
import org.localchefs.app.Constants.Navigation.CHEFS
import org.localchefs.app.Constants.Navigation.HOME
import org.localchefs.app.Constants.Navigation.HOW_IT_WORKS
import org.localchefs.app.Constants.Navigation.READY_DISHES
import org.localchefs.app.Constants.Navigation.SIGNIN
import org.localchefs.app.Constants.Navigation.SIGNUP
import org.localchefs.app.presentation.screens.ChefListScreen
import org.localchefs.app.presentation.screens.HomeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        val context = LocalContext.current
        val activity = context as ComponentActivity
        val orange = Color(0xFFFF7A00)
        val blueGray = Color(0xFF232F3E)
        val signInButtonInteractionSource = remember { MutableInteractionSource() }
        val isSignInButtonPressed by signInButtonInteractionSource.collectIsPressedAsState()
        var menuExpanded by remember { mutableStateOf(false) }
        val snackbarHostState = remember { SnackbarHostState() }

        val isDarkMode = isSystemInDarkTheme()

        DisposableEffect(isDarkMode) {
            activity.enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.light(
                    Color.Red.hashCode(),
                    Color.Green.hashCode()
                ),
                navigationBarStyle = if (!isDarkMode)
                    SystemBarStyle.light(
                        Color.Gray.hashCode(),
                        Color.Yellow.hashCode()
                    ) else SystemBarStyle.dark(Color.White.hashCode())
            )
            onDispose { }
        }

        Scaffold(
            snackbarHost = {
                SnackbarHost(snackbarHostState)
            },
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    // Logo
                    Image(
                        painter = painterResource(id = R.drawable.ic_logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = { navController.navigate(CART) },
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                Color.White,
                                shape = RoundedCornerShape(10.dp)
                            )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cart),
                            contentDescription = "Cart",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    OutlinedButton(
                        onClick = { navController.navigate(SIGNIN) },
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(
                            1.dp,
                            color = if (isSignInButtonPressed) Color(0xFFEF4444) else Color.Gray
                        ),
                        interactionSource = signInButtonInteractionSource,
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (isSignInButtonPressed) Color(0xFFEF4444) else Color.White,
                            contentColor = if (isSignInButtonPressed) Color.White else Color(
                                0xFF222E3A
                            ),
                        ),
                        modifier = Modifier
                            .padding(horizontal = 4.dp),
                    ) {
                        Text("Sign In")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { navController.navigate(SIGNUP) },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = orange),
                    ) {
                        Text("Sign Up", color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    IconButton(onClick = { menuExpanded = true }) {
                        Icon(
                            if (menuExpanded) Icons.Default.Close else Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }

                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false },
                        shadowElevation = 0.dp,
                        tonalElevation = 0.dp,
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 4.dp,
                            bottomEnd = 4.dp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                    ) {
                        DropdownMenuItem(
                            text = { Text("Home") },
                            onClick = {
                                navController.navigate(HOME)
                                menuExpanded = false
                            })
                        DropdownMenuItem(
                            text = { Text("Chefs") },
                            onClick = {
                                navController.navigate(CHEFS)
                                menuExpanded = false
                            })
                        DropdownMenuItem(
                            text = { Text("Ready Today") },
                            onClick = {
                                navController.navigate(READY_DISHES)
                                menuExpanded = false
                            })
                        DropdownMenuItem(
                            text = { Text("How It Works") },
                            onClick = {
                                navController.navigate(HOW_IT_WORKS)
                                menuExpanded = false
                            })
                        HorizontalDivider(Modifier.padding(8.dp))
                        DropdownMenuItem(
                            text = { Text("Feedback") },
                            onClick = { menuExpanded = false })
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = HOME,
                Modifier.padding(innerPadding)
            ) {
                composable(HOME) {
                    HomeScreen(
                        onNavigationClick = { destination ->
                            Toast.makeText(
                                context,
                                "Navigating to $destination",
                                Toast.LENGTH_SHORT
                            ).show()
                            when (destination) {
//                            Constants.Navigation.SIGNIN -> navController.navigate(Constants.Navigation.SIGNIN)
//                            Constants.Navigation.SIGNUP -> navController.navigate(Constants.Navigation.SIGNUP)
//                            Constants.Navigation.CART -> navController.navigate(Constants.Navigation.CART)
                                Constants.Navigation.CHEFS -> navController.navigate(Constants.Navigation.CHEFS)
//                            Constants.Navigation.READY_DISHES -> navController.navigate(Constants.Navigation.READY_DISHES)
//                            Constants.Navigation.HOW_IT_WORKS -> navController.navigate(Constants.Navigation.HOW_IT_WORKS)
                            }
                        },
                        onSearchLocation = { latitude, longitude, miles ->
                            navController.navigate(
                                "$CHEFS?latitude=$latitude&longitude=$longitude&miles=$miles"
                            )
                        }
                    )
                }
                // Add other composable destinations here
                composable(
                    route = "$CHEFS?latitude={latitude}&longitude={longitude}&miles={miles}",
                    arguments = listOf(
                        navArgument("latitude") {
                            type = NavType.FloatType
                            defaultValue = 0f
                        },
                        navArgument("longitude") {
                            type = NavType.FloatType
                            defaultValue = 0f
                        },
                        navArgument("miles") {
                            type = NavType.IntType
                            defaultValue = 0
                        }
                    )
                ) {
                    val latitude = it.arguments?.getFloat("latitude") ?: 0f
                    val longitude = it.arguments?.getFloat("longitude") ?: 0f
                    val miles = it.arguments?.getInt("miles") ?: 0
                    ChefListScreen(
                        latitude = latitude,
                        longitude = longitude,
                        miles = miles,
                        onChefSelected = { chefId ->
                            Toast.makeText(context, "Selected Chef ID: $chefId", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
                }
                composable(READY_DISHES) {
                    Text(
                        text = "Ready Dishes",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                composable(SIGNIN) {
                    Text(
                        text = "Sign In",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                composable(SIGNUP) {
                    Text(
                        text = "Sign Up",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                composable(HOW_IT_WORKS) {
                    Text(
                        text = "How It Works",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                composable(CART) {
                    Text(
                        text = "Cart",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }

    }
}