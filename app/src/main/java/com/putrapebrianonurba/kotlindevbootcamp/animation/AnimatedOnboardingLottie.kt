package com.putrapebrianonurba.kotlindevbootcamp.animation

import android.content.Context
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.delay
import com.putrapebrianonurba.kotlindevbootcamp.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@Composable
fun AnimatedOnboardingLottieBootcampNavHost() {
    // Nav Controller
    val navController = rememberNavController()

    // Nav Host
    NavHost(navController = navController, startDestination = "splash") {
        animatedOnboardingLottieBootcampNavGraph(navController)
    }
}

@OptIn(ExperimentalPagerApi::class)
private fun NavGraphBuilder.animatedOnboardingLottieBootcampNavGraph(navController: NavController) {
    // Splash Screen
    composable(route = "splash") {
        AnimatedOnboardingLottieBefore(navController = navController)
    }
    // Onboarding
    composable(route = "onboard") {
        AnimatedOnboardingLottieBootcamp(navController = navController)
    }
    // Home
    composable(route = "home") {
        AnimatedOnboardingLottieAfter()
    }
}

@Composable
private fun AnimatedOnboardingLottieBefore(navController: NavController) {
    val context = LocalContext.current
    val dataStore = remember { DataStoreManager(context) }
    val onboardingShown by dataStore.onboardingShown.collectAsState(initial = false)
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        alpha.animateTo( 1f, animationSpec = tween(durationMillis = 800) )

        // Navigating
        delay(1500)
        navController.popBackStack(route = "splash", inclusive = true)
        if (onboardingShown) {
            navController.navigate("home")
        } else {
            navController.navigate("onboard")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Loader Animation
        LoaderAnimationOnboardingLottie(
            modifier = Modifier
                .size(400.dp),
            animation = R.raw.sport_boy
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text("Lets Travel", fontSize = 38.sp, fontWeight = FontWeight.Light, modifier = Modifier.alpha(alpha.value), color = if (isSystemInDarkTheme()) Color.White else Color.Black)
    }
}

@ExperimentalPagerApi
@Composable
private fun AnimatedOnboardingLottieBootcamp(navController: NavController) {
    val animationRaw = listOf( R.raw.intro_1, R.raw.intro_2, R.raw.intro_2 )
    val titles = listOf( "Explore the Skies", "Seaside Escapes", "Garden Gateways" )
    val descriptions = listOf(
        "Discover unbeeatable deals on air travel to the destination around the globe",
        "Embark on unforgetable journeys to renowned beachfront destination",
        "Experience the finest city and garden tours right at your fingertips with out app"
    )

    val pagerState = rememberPagerState(pageCount = animationRaw.size)

    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding().navigationBarsPadding(),
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.wrapContentSize()
        ) { currentPage ->
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(26.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(animationRaw[currentPage]))
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(280.dp),
                )

                Text(
                    titles[currentPage],
                    textAlign = TextAlign.Center,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    descriptions[currentPage],
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(animationRaw.size) {
                IndicatorPagerIsNotSelected(isSelected = it == pagerState.currentPage)
            }
        }
    }

    ButtonOverlay(
        pagerState = pagerState,
        animationCount = animationRaw.size,
        navController = navController
    )
}

@Composable
private fun AnimatedOnboardingLottieAfter() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Home Screen", fontSize = 44.sp)
    }
}

@Composable
private fun LoaderAnimationOnboardingLottie(modifier: Modifier, animation: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(animation))

    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier,
    )
}

@Composable
private fun IndicatorPagerIsNotSelected(isSelected: Boolean) {
    Box(modifier = Modifier
        .padding(2.dp)
        .height(10.dp)
        .width(if (isSelected) 30.dp else 15.dp)
        .clip(CircleShape)
        .background(if (isSelected) Color.Black else Color.Gray)
    ) {}
}

@ExperimentalPagerApi
@Composable
private fun ButtonOverlay(pagerState: PagerState, animationCount: Int, navController: NavController) {
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(30.dp)
    ) {
        if (pagerState.currentPage != animationCount - 1) {
            if (pagerState.currentPage != 0) {
                Text(
                    "Back",
                    modifier = Modifier
                        .align ( Alignment.BottomStart )
                        .clickable( onClick = {
                            scope.launch {
                                val prevPage = pagerState.currentPage - 1
                                pagerState.scrollToPage(prevPage)
                            }
                        }),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
            }

            Text(
                "Next",
                modifier = Modifier
                    .align ( Alignment.BottomEnd )
                    .clickable( onClick = {
                        scope.launch {
                            val nextPage = pagerState.currentPage + 1
                            pagerState.scrollToPage(nextPage)
                        }
                    }),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        } else {
            OutlinedButton(onClick = {
                scope.launch {
                    val context = navController.context
                    val dataStore = DataStoreManager(context)
                    dataStore.setOnboardingShown(true)
                }
                navController.popBackStack()
                navController.navigate(route = "home")
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
            ) {
                Text(
                    "Get Started",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isSystemInDarkTheme()) Color.Black else Color.White
                )
            }
        }
    }
}

// Data store manager
// Digunakan untuk membuat  preference keys, untuk membuat user pertama kali klik masuk ke onboard, untuk seterusnya langsung ke home
val Context.dataStore by preferencesDataStore("settings")

object PreferenceKeys {
    val ONBOARDING_SHOWN = booleanPreferencesKey("onboarding_shown")
}

class DataStoreManager(private val context: Context) {

    val onboardingShown: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[PreferenceKeys.ONBOARDING_SHOWN] ?: false }

    suspend fun setOnboardingShown(shown: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[PreferenceKeys.ONBOARDING_SHOWN] = shown
        }
    }
}


@Preview(showBackground = true)
@ExperimentalPagerApi
@Composable
private fun AnimatedOnboardingLottieBootcampPreview() {
    val navController = rememberNavController()
    AnimatedOnboardingLottieBootcamp(navController)
}

// Small Summary
/*
Kelebihan pada file ini
1. Menggunakan data store terbaru, menggantikan preferences data store
2. Pake kotlin flow
3. Pake coroutine
4. Suspend kotlin

Kekurangan pada file ini
1. Menggunakan liblary pada google, bukan bawaan compose
2. Splash ini sebenernya custom, bukan SplashScreen API bawaan Android 12+. Kalau mau pake bawaan, lo bisa pake SplashScreen.installSplashScreen() di MainActivity.


Belajar yang perlu di tingkatkan
1. Kotlin Flow
2. Kotlin Coroutines
3. Suspend Kotlin
*/
