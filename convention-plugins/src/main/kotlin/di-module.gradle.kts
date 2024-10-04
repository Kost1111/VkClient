import ext.kapt
import ext.libs
import gradle.kotlin.dsl.accessors._a25d2a17aee6a78326be890f959e61c8.implementation

plugins {
    id("android-module")
    id("kotlin-kapt")
}

dependencies {

    implementation(libs.findLibrary("dagger-dagger").get())
    kapt(libs.findLibrary("dagger-compiler").get())
}
