@file:Suppress("UnstableApiUsage")

val libs = project.extensions.getByName("libs") as org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("com.android.library")
    kotlin("android")

}

android {
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }

    compileSdk = libs.versions.androidCompileSdkVersion.get().toInt()

    defaultConfig {
        compileSdk = libs.versions.androidCompileSdkVersion.get().toInt()
        multiDexEnabled = true
        minSdk = 26
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    coreLibraryDesugaring(libs.desugar)
}

