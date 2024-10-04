pluginManagement {
    includeBuild("convention-plugins")
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

include(":app")
include(":feature:auth:api")
include(":feature:auth:impl")
