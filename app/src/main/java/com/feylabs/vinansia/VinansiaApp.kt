package com.feylabs.vinansia

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.feylabs.vinansia.ui.screen.home.HomeScreen
import com.feylabs.vinansia.ui.screen.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VinansiaApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {


    Scaffold {defaultPadding->
        NavHost(
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(defaultPadding),
            navController = navController)
        {
            composable(Screen.Home.route){
                HomeScreen(navController = navController)
            }
        }

    }

}