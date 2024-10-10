import com.android.build.api.dsl.LibraryBuildType

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin.android)
    id("di-module")
}

android {
    namespace = "com.core.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        forEach {
            provideVkAccessToken(it)
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.bundles.networkDependencies)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}

fun provideVkAccessToken(buildType: LibraryBuildType) {
    buildType.buildConfigField(
        "String",
        "VK_ACCESS_TOKEN",
        "\"f8db2900f8db2900f8db290053fbc4ff4cff8dbf8db29009e248e25ee62dd1b78a96cb7\""
    )
}