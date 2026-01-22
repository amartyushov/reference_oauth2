rootProject.name = "reference_oauth2"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("jvm") version "2.3.0"
    }
}

include("scenarios:authorization-code")