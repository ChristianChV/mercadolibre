plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "christian.chamorro.search"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":commons:network"))
    implementation(project(":commons:core"))

    implementation(libs.androidx.appcompat)

    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.hilt)
    implementation(libs.bundles.coil)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.coroutines)
    implementation(libs.androidx.dataStore)

    implementation(platform(libs.kotlin.bom))
    implementation(platform(libs.androidx.compose.bom))

    testImplementation(libs.bundles.testing)
    androidTestImplementation(libs.bundles.androidTesting)
}
