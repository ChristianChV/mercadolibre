plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ksp)
}

android {
    namespace = "christian.chamorro.product"
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
    implementation(libs.bundles.coil)
    implementation(libs.bundles.room)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.coroutines)

    ksp(libs.room.compiler)

    testImplementation(libs.bundles.testing)
    androidTestImplementation(libs.bundles.androidTesting)
}