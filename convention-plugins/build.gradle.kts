plugins {
    `kotlin-dsl`
}
val libs = project.extensions.getByName("libs") as org.gradle.accessors.dm.LibrariesForLibs

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = libs.versions.jvmTarget.get()
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.gradle)
    implementation(libs.gradlePlugin.ktlint)
}
