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
include(":core:network")
include(":feature:feed")
include(":feature:feed:api")
include(":feature:feed:impl")
include(":core:util")
include(":feature:profile:api")
include(":feature:profile:impl")
include(":feature:messenger:api")
include(":feature:messenger:impl")
