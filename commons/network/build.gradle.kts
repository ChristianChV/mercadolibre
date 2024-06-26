plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.google.hilt)
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "christian.chamorro.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.appcompat)

    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.hilt)
    implementation(libs.bundles.room)
    implementation(libs.androidx.compose.bom)
    implementation(platform(libs.kotlin.bom))
    implementation(platform(libs.androidx.compose.bom))

    kapt(libs.hilt.compiler)
    kapt(libs.hilt.annotation)

    testImplementation(libs.bundles.testing)
    androidTestImplementation(libs.bundles.androidTesting)
}
