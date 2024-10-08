plugins {
    id("feature-module")
}

android.namespace = "com.vkClient.feature.feed.impl"



dependencies {

    implementation(projects.feature.feed.api)
    implementation(projects.core.util)
    implementation(projects.core.network)

}