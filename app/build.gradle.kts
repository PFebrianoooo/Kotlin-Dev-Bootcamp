plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.putrapebrianonurba.kotlindevbootcamp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.putrapebrianonurba.kotlindevbootcamp"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // For Swipe To Delete & Dependency for TextMarquee (BOM)
    implementation(platform("androidx.compose:compose-bom:2025.05.00"))

    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Dependency for navigation
    implementation("androidx.navigation:navigation-compose:2.9.3")

    // Dependency for lottie
    implementation("com.airbnb.android:lottie-compose:6.6.7")

    // Dependency for pager
    implementation("com.google.accompanist:accompanist-pager:0.12.0")

    // Dependency for DataStore
    implementation ("androidx.datastore:datastore-preferences:1.1.1")

    // Dependency for Extended Icons
    implementation("androidx.compose.material:material-icons-extended:1.5.3")
}