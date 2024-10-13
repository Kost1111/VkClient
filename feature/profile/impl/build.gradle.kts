plugins {
    id("feature-module")
}

android.namespace = "com.vkClient.feature.profile.impl"



dependencies {

    implementation(projects.feature.profile.api)
    implementation(projects.core.util)
    implementation(projects.core.network)
    implementation(libs.bundles.networkDependencies)
}