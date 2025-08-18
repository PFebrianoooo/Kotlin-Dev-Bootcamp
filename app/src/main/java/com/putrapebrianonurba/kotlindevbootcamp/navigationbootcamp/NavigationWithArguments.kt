package com.putrapebrianonurba.kotlindevbootcamp.navigationbootcamp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationNavHostForArguments() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first-screen") {
        navArgumentsGraph(navController)
    }
}

private fun NavGraphBuilder.navArgumentsGraph(navController: NavController) {
    composable(route = "first-screen") {
        NavigationWithArgumentsBootcamp(navController = navController)
    }
    composable(
        route = "second-screen?name={name}&age={age}",
        arguments = listOf(
            navArgument(name = "name") {
                type = NavType.StringType
                // defaultValue = "Unknown"
                nullable = true
            },
            navArgument(name = "age") {
                type = NavType.IntType
                defaultValue = 0
                // nullable = true
            }
        )
        ) { backStackData ->
        NavigationWithArgumentDetailBootcamp(
            backStackData.arguments?.getString("name"),
            backStackData.arguments?.getInt("age"),
            navController
        )
    }
}

@Composable
private fun NavigationWithArgumentsBootcamp(modifier: Modifier = Modifier, navController: NavController) {
    // State Variables
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Input Your Data", fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, modifier = modifier.padding(20.dp))

        Spacer(modifier = modifier.padding(20.dp))

        OutlinedTextField(value = name, onValueChange = { name = it }, placeholder = { Text("Your name") }, maxLines = 1)

        Spacer(modifier = modifier.padding(10.dp))

        OutlinedTextField(value = age, onValueChange = { age = it }, placeholder = { Text("Your Age") }, maxLines = 1)

        Spacer(modifier = modifier.padding(10.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            onClick = {
                navController.navigate(route = "second-screen?name=${name}&age=${age}")
                // navController.navigate(route = "second-screen/$name/$age")
            },
            enabled = if (name.isNotEmpty() && age.isNotEmpty()) true else false
        ) {
            Text("Go to Detail")
        }
    }
}

@Composable
private fun NavigationWithArgumentDetailBootcamp(name: String?, age: Int?, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Name: $name", fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(20.dp))
        Text("Age: $age", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(bottom = 20.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            onClick = { navController.popBackStack() }
        ) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NavigationWithArgumentsBootcampPreview() {
    val navController = rememberNavController()
    NavigationWithArgumentsBootcamp(navController = navController)
}

@Preview(showBackground = true)
@Composable
private fun NavigationWithArgumentsBootcampDetailPreview() {
    val navController = rememberNavController()
    NavigationWithArgumentDetailBootcamp("Unknown", 0, navController)
}

// Small Summary
/*
Ada 2 data yang bisa di passing
1. Required data
2. Optional data

Jika dalam required data data yang dimasukkan tidak ada isinya, maka aplikasi akan crash.
handle
1. Jangan hidupin tombol
2. Isi dengan value default dan nullable pada navArguments pilih salah satu aja
 */