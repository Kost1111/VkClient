import ext.libComposeBom
import ext.libComposeMaterial3
import ext.libComposePreview
import ext.libComposeTooling
import ext.libComposeUi
import ext.libComposeUiGraphics
import ext.libKotlinCompilerExt
import ext.libs

plugins {
    id("android-module")
}

android {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion =  libs.libKotlinCompilerExt
}

dependencies {
    implementation(platform(libs.libComposeBom))
    implementation(libs.libComposeUi)
    implementation(libs.libComposeUiGraphics)
    implementation(libs.libComposePreview)
    implementation(libs.libComposeMaterial3)

    debugImplementation(libs.libComposeTooling)
}

