package com.putrapebrianonurba.kotlindevbootcamp.navigationbootcamp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController


// NAV HOST/ NAV GRAPH COMMON
private object Graph {
    const val AUTH = "auth_graph"
    const val HOME = "home_graph"
}

@Composable
fun NestedNavigationNavHost() {
    // NAV CONTROLLER
    val navController = rememberNavController()

    // NAV HOST
    // NavHost(navController = navController, startDestination = "login") {
    NavHost(navController = navController, startDestination = Graph.AUTH) {
        authNavGraph(navController)
        homeNavGraph(navController)
    }
}

// Auth Nav Graph
private sealed class AuthScreen(val route: String) {
    object Login: AuthScreen("login")
    object ForgetPassword: AuthScreen("forget-password")
    object Register: AuthScreen("register")
}

private fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(startDestination = AuthScreen.Login.route, route = Graph.AUTH) {
        composable(AuthScreen.Login.route) { Login(navController) }
        composable(AuthScreen.ForgetPassword.route) { ForgetPassword(navController) }
        composable(AuthScreen.Register.route) { Register(navController) }
    }
}

// Home Nav Graph
private sealed class HomeScreen(val route: String) {
    object Home: HomeScreen("home")
    object HomeDetail: HomeScreen("home-detail")
    object StoreDetail: HomeScreen("store-detail")
}
private fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(startDestination = HomeScreen.Home.route, route = Graph.HOME) {
        composable(HomeScreen.Home.route) { Home(navController) }
        composable(HomeScreen.HomeDetail.route) { HomeDetail(navController) }
        composable(HomeScreen.StoreDetail.route) { StoreDetail(navController) }
    }
}

@Composable
private fun Login(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Login", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(20.dp))

        Button(
            onClick = {
                // Ini yang negbuat jadi 1 kali login aja
                navController.navigate(Graph.HOME) {
                    popUpTo(Graph.AUTH) { inclusive = false }
                }
            }
        ) {
            Text("Login -> Go to Home")
        }

        Button(
            onClick = { navController.navigate(route = AuthScreen.ForgetPassword.route) }
        ) {
            Text("Forget Password")
        }

        Button(
            onClick = { navController.navigate(route = AuthScreen.Register.route) }
        ) {
            Text("Register")
        }
    }
}

@Composable
private fun ForgetPassword(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Forget Password", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(20.dp))

        Button( onClick = { navController.popBackStack(AuthScreen.Login.route, inclusive = false) } ) {
            Text("Set Password -> Go to Login")
        }
    }
}

@Composable
private fun Register(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Register", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(20.dp))

        Button(
            onClick = {
                // Ini yang negbuat jadi 1 kali login aja
                navController.navigate(Graph.HOME) {
                    popUpTo(Graph.AUTH) { inclusive = false }
                }
            }
        ) {
            Text("Register Success -> Go to Home")
        }
    }
}

@Composable
private fun Home(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Home", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(20.dp))

        Button(
            onClick = {
                navController.navigate(route = HomeScreen.HomeDetail.route)
            }
        ) {
            Text("Go to Home Detail")
        }

        Button(
            onClick = {
                navController.navigate(route = HomeScreen.StoreDetail.route)
            }
        ) {
            Text("Go to Store Detail")
        }
    }
}

@Composable
private fun HomeDetail(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Home Detail", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(20.dp))

        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("Go to Home")
        }
    }
}

@Composable
private fun StoreDetail(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Store Detail", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(20.dp))

        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("Go to Home")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NestedNavigationBootcampPreview() {
    val navController = rememberNavController()
    Home(navController)
}

// Small Summary
/*
Nested Navigation
Nested navigation, alih alih kita membuat seperti nav with arguments or nav genera. Apabila user membuka kembali aplikasi. Akan menuju ke first screen lagi
oleh karena itu, kita perlu nested graph untuk membuatnya separate

<Graph Schema>
    NavController
         │
         ▼
    NavHost (NestedNavigationNavHost)
     ├── authNavGraph(navController)        <-- Graph.AUTH
     │     ├── Login(navController)         <-- AuthScreen.Login
     │     ├── ForgetPassword(navController) <-- AuthScreen.ForgetPassword
     │     └── Register(navController)      <-- AuthScreen.Register
     │
     └── homeNavGraph(navController)        <-- Graph.HOME
           ├── Home(navController)          <-- HomeScreen.Home
           ├── HomeDetail(navController)    <-- HomeScreen.HomeDetail
           └── StoreDetail(navController)   <-- HomeScreen.StoreDetail

PENJELASAN:
1. NavController adalah "otaknya" — semua perpindahan screen lewat sini.
2. NavHost (NestedNavigationNavHost) jadi entry point navigasi, start di Graph.AUTH.
3. authNavGraph memuat seluruh screen login, lupa password, dan register.
4. Dari salah satu screen di auth (misalnya Login), user bisa pindah ke Graph.HOME.
5. homeNavGraph memuat seluruh screen setelah login, seperti home, detail, dan store detail.
5. Pindah antar-screen di dalam graph tidak keluar dari graph (misalnya Home → HomeDetail tetap di Graph.HOME)

*/