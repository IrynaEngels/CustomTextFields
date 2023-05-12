package com.irynaengels.dymanictextfieldproperties.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val PreviewRoute = "preview"
const val AttributeFormRoute = "attributeForm"

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AttributeFormRoute) {
        composable(PreviewRoute) {
            PreviewScreen(navController)
        }
        composable(AttributeFormRoute) {
            AttributeForm(navController)
        }
    }
}
