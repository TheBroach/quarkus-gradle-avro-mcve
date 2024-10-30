plugins {
    id("kotlin-conventions")
    alias(libs.plugins.quarkus.gradle)
}

dependencies {
    implementation(enforcedPlatform(libs.quarkus.platform))
    implementation(libs.quarkus.arc)
    implementation(libs.quarkus.kotlin.extension)
    implementation(libs.quarkus.kotlin.stdlib)
    implementation(libs.quarkus.apicurio.avro)
}

tasks.quarkusDependenciesBuild {
    dependsOn(tasks.jandex)
}

tasks.compileKotlin {
    dependsOn(tasks.`compileQuarkus-test-generated-sourcesKotlin`)
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
