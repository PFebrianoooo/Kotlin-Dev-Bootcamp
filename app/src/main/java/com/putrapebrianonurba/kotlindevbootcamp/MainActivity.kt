package com.putrapebrianonurba.kotlindevbootcamp

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.putrapebrianonurba.kotlindevbootcamp.animation.AnimatedOnboardingLottieBootcampNavHost
import com.putrapebrianonurba.kotlindevbootcamp.animation.AnimatedSplashScreenNavHost
import com.putrapebrianonurba.kotlindevbootcamp.animation.LottieAnimationBootcamp
import com.putrapebrianonurba.kotlindevbootcamp.navigationbootcamp.LazyWithNavigationHost
import com.putrapebrianonurba.kotlindevbootcamp.navigationbootcamp.NavigationNavHost
import com.putrapebrianonurba.kotlindevbootcamp.navigationbootcamp.NavigationNavHostForArguments
import com.putrapebrianonurba.kotlindevbootcamp.navigationbootcamp.NestedNavigationNavHost
import com.putrapebrianonurba.kotlindevbootcamp.retrofit.view.ProductsView
import com.putrapebrianonurba.kotlindevbootcamp.scaffoldbootcamp.BottomBarBootcamp
import com.putrapebrianonurba.kotlindevbootcamp.scaffoldbootcamp.NavigationDrawerBootcamp
import com.putrapebrianonurba.kotlindevbootcamp.ui.theme.KotlinDevBootcampTheme
import com.putrapebrianonurba.kotlindevbootcamp.uidesign.cookie.CookieAppMain
import com.putrapebrianonurba.kotlindevbootcamp.uidesign.instagram.InstagramLayouts
import com.putrapebrianonurba.kotlindevbootcamp.uidesign.whatsapp.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // installSplashScreen()

        setContent {
            KotlinDevBootcampTheme {
                // BottomBarBootcamp()
                // NavigationNavHost()
                // NavigationNavHostForArguments()
                // NestedNavigationNavHost()
                // LazyWithNavigationHost()
                // NestedLazyColumnBootcamp()
                // SearchScreenBootcamp()
                // LottieAnimationBootcamp()
                // AnimatedSplashScreenNavHost()
                // AnimatedOnboardingLottieBootcampNavHost()
                // NavigationDrawerBootcamp()
                // MainScreen()
                // InstagramLayouts()
                // CookieAppMain()
                ProductsView()
            }
        }
    }
}

// Best Practice
// Cleaner, Readable & Avoid from BoilerPlate Code
@Composable
fun MainView() {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            SearchBar()
            ScrollableCategories()
            ListProduct()
        }
    }
}

@Composable
fun ScrollableCategories() {
    Text("Scrollable Categories")
}

@Composable
fun SearchBar() {
    Text("Search Bar")
}

@Composable
fun ListProduct() {
    Text("List Product")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinDevBootcampTheme {
        MainView()
    }
}

// Small Summary
/*
Main Activity
MainActivity adalah entry point utama dari aplikasi Android — yakni tempat pertama yang dijalankan ketika pengguna membuka aplikasi.
Pada arsitektur berbasis Jetpack Compose, MainActivity memegang peran penting sebagai pengatur awal tampilan (UI) aplikasi.

Pengeksekusian seluruh yang ada di dalam class main activity termasuk:
1. Oncreate()
2. SetContent {}
3. ThemeApllication
4. Composable (in case text)

Best Practice
1. Penggunaan dari container Surfase atau Scaffold baiknya pada composable function target, Yang memiliki keuntungan
   a. Create one for another
   b. Easy to maintenance
   c. Readable
   d. Clean
   Contoh diatas
*/