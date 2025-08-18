package com.putrapebrianonurba.kotlindevbootcamp.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.putrapebrianonurba.kotlindevbootcamp.R
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreenNavHost() {
    // Nav Controller
    val navController = rememberNavController()

    // Nav Host
    NavHost(navController = navController, startDestination = "splash") {
        animatedSplashScreenNavGraph(navController)
    }
}

private fun NavGraphBuilder.animatedSplashScreenNavGraph(navController: NavController) {
    // Splash Screen
    composable(route = "splash") {
        AnimatedSplashScreenBootcamp(navController = navController)
    }

    // Home
    composable(route = "home") {
        AnimatedSplashScreenHome()
    }
}


@Composable
private fun AnimatedSplashScreenBootcamp(navController: NavController) {
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        alpha.animateTo( 1f,
            animationSpec = tween(durationMillis = 1500)
        )

        // Navigating
        delay(2500)
        navController.popBackStack()
        navController.navigate(route = "home")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Loader Animation
        LoaderAnimationSplashScreen(
            modifier = Modifier
                .size(400.dp),
            animation = R.raw.sport_boy
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text("Lets Make an App!", fontSize = 36.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.alpha(alpha.value), color = if (isSystemInDarkTheme()) Color.White else Color.Black)
    }
}

@Composable
private fun AnimatedSplashScreenHome() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Home Screen", fontSize = 44.sp)
    }
}

@Composable
private fun LoaderAnimationSplashScreen(modifier: Modifier, animation: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(animation))

    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun AnimatedSplashScreenBootcampPreview() {
    val navController = rememberNavController()
    AnimatedSplashScreenBootcamp(navController)
}

// Yang di pelajari disini
/*
1. Launched Effect
2. Lottie Animation
3. Arrangement of files & Composable functions
*/