plugins {
    id("com.android.application")
    kotlin("android")
    id("lint")
}

android {
    namespace = "com.vkclient"
    compileSdk = libs.versions.androidCompileSdkVersion.get().toInt()

    defaultConfig {
        applicationId = "com.vkclient"
        compileSdk = libs.versions.androidCompileSdkVersion.get().toInt()
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        minSdk = 26
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.android.sdk.core)
    implementation(libs.android.sdk.api)
    coreLibraryDesugaring(libs.desugar)


    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    debugImplementation(libs.androidx.ui.tooling)
    androidTestImplementation(platform(libs.androidx.compose.bom))


    implementation(projects.feature.auth.api)
    implementation(projects.feature.auth.impl)
}