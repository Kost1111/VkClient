plugins {
    id("kotlin")
}

val libs = project.extensions.getByName("libs") as org.gradle.accessors.dm.LibrariesForLibs

dependencies {
    implementation(libs.kotlin.coroutines)
    implementation(libs.javax.inject)
}
