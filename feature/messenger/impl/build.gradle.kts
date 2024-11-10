plugins {
    id("feature-module")
}

android.namespace = "com.vkClient.feature.messenger.impl"



dependencies {

    implementation(projects.feature.messenger.api)
    implementation(projects.core.util)
    implementation(projects.core.network)
    implementation(libs.bundles.networkDependencies)

}