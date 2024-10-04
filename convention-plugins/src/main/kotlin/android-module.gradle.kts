import config.AppConfig
import ext.libDesugar
import ext.libs

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-conventions")
}

android {
    namespace = "com.vkclient"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        vectorDrawables.useSupportLibrary = true
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        targetCompatibility = JavaVersion.VERSION_18
        sourceCompatibility = JavaVersion.VERSION_18
    }
}

dependencies {
    coreLibraryDesugaring(libs.libDesugar)
}

