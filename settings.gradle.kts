rootProject.name = "quarkus-gradle-avro-mcve"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    includeBuild("./gradle/build-logic")
}

include("application", "adapters")
