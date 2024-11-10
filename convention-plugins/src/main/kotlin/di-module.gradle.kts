val libs = project.extensions.getByName("libs") as org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("android-module")
    id("kotlin-kapt")
}

android {
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)
}
