pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "VkClient"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

includeBuild("convention-plugins")
include(":app")
include(":feature:auth:api")
include(":feature:auth:impl")
include(":core:network")
