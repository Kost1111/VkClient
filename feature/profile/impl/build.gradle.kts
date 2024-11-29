plugins {
    id("feature-module")
}

android.namespace = "com.vkClient.feature.profile.impl"



dependencies {

    implementation(projects.feature.profile.api)
    implementation(projects.core.util)
    implementation(projects.core.network)
    implementation(libs.bundles.networkDependencies)
    implementation(libs.android.sdk.core)
    implementation(libs.android.sdk.api)

    implementation("com.google.accompanist:accompanist-permissions:0.36.0")
    implementation( "io.coil-kt:coil-compose:2.7.0")
}