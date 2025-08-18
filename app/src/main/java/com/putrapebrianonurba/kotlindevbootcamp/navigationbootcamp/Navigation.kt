package com.putrapebrianonurba.kotlindevbootcamp.navigationbootcamp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationNavHost() {
    // NAV CONTROLLER
    val navController = rememberNavController()

    // NAV HOST
    NavHost(navController = navController, startDestination = "screen-one") {
        navigationGraph(navController)
    }
}

// NAV GRAPH
private fun NavGraphBuilder.navigationGraph(navController: NavController) {
    composable(route = "screen-one") {
        NavigationBootcamp1(navController)
    }

    composable(route = "screen-two") {
        NavigationBootcamp2(navController)
    }

    composable(route = "screen-three") {
        NavigationBootcamp3(navController)
    }
}

// DESTINATION, ACTIONS & NAV CONTROLLLER
@Composable
private fun NavigationBootcamp1(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen One", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(20.dp))

        Button(onClick = {
            navController.navigate(route = "screen-two")
        }) {
            Text("Go to Screen Two")
        }
    }
}

@Composable
private fun NavigationBootcamp2(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen Two", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(20.dp))

        OutlinedButton(onClick = {
            navController.popBackStack()
        }) {
            Text("Back")
        }

        Button(onClick = {
            navController.navigate(route = "screen-three")
        }) {
            Text("Go to Screen Three")
        }
    }
}

@Composable
private fun NavigationBootcamp3(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen One", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(20.dp))

        OutlinedButton(onClick = {
            navController.popBackStack()
        }) {
            Text("Back")
        }

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Go to Screen Two")
        }

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            onClick = { navController.popBackStack(navController.graph.startDestinationId, inclusive = false) }

        ) {
            Text("Go to Screen One")
        }

    }
}

// PREVIEW PROVIDER
@Preview(showBackground = true)
@Composable
private fun NavigationBootcampPreview1() {
    val navController = rememberNavController()
    NavigationBootcamp1(navController)
}

@Preview(showBackground = true)
@Composable
private fun NavigationBootcampPreview2() {
    val navController = rememberNavController()
    NavigationBootcamp2(navController)
}

@Preview(showBackground = true)
@Composable
private fun NavigationBootcampPreview3() {
    val navController = rememberNavController()
    NavigationBootcamp3(navController)
}

// Small Summary
/*
Schema
Screen A -> Screen B back to Screen A -> Screen 3 back to Screen B or go to screen A
*/
