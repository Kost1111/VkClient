val libs = project.extensions.getByName("libs") as org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("android-module")
    id("kotlin-kapt")
}

dependencies {
    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)
}
