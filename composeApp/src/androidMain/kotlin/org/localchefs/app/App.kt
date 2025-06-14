package org.localchefs.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.localchefs.app.presentation.screens.ChefListScreen
import org.localchefs.app.presentation.screens.FoodAllergenScreen
import org.localchefs.app.presentation.screens.DietaryTagScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        
        NavHost(navController = navController, startDestination = "chefs") {
            composable("chefs") {
                ChefListScreen(
                    onFoodAllergensClick = {
                        navController.navigate("allergens")
                    },
                    onDietaryTagsClick = {
                        navController.navigate("dietary-tags")
                    }
                )
            }
            composable("allergens") {
                FoodAllergenScreen()
            }
            composable("dietary-tags") {
                DietaryTagScreen()
            }
        }
    }
}