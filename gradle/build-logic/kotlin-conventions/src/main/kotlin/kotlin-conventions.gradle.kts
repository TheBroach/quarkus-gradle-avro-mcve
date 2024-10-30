import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    kotlin("jvm")
    kotlin("plugin.allopen")
    id("org.kordamp.gradle.jandex")
}

val libs = the<LibrariesForLibs>()

dependencies {
    implementation(libs.kotlin.logging)
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        javaParameters.set(true)
    }
}

allOpen {
    annotation("jakarta.enterprise.context.ApplicationScoped")
}