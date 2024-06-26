// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.klint) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.google.hilt) apply false
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}