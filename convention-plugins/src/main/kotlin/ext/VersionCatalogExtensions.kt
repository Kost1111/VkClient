@file:Suppress("UnstableApiUsage")

package ext

import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

//Desugar
internal val VersionCatalog.libDesugar: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("desugar")

//Compose
internal val VersionCatalog.libComposeBom: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-compose-bom")
internal val VersionCatalog.libComposeUi: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-ui")
internal val VersionCatalog.libComposeUiGraphics: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-ui-graphics")
internal val VersionCatalog.libComposePreview: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-ui-tooling-preview")
internal val VersionCatalog.libComposeTooling: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-ui-tooling")
internal val VersionCatalog.libComposeMaterial3: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-material3")

//Kotlin
internal val VersionCatalog.libKotlinCompilerExt: String
    get() = findVersionOrThrow("kotlinCompilerExtension")


private fun VersionCatalog.findLibraryOrThrow(name: String) =
    findLibrary(name)
        .orElseThrow { NoSuchElementException("Library $name not found in version catalog") }
private fun VersionCatalog.findVersionOrThrow(name: String) =
    findVersion(name)
        .orElseThrow { NoSuchElementException("Version $name not found in version catalog") }
        .requiredVersion

internal fun DependencyHandler.kapt(dependencyNotation: Provider<MinimalExternalModuleDependency>) =
    add("kapt", dependencyNotation)