import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    id("org.sonarqube") version "3.0"
}

sonarqube {
    properties {
        property("sonar.projectKey", "welldoer_TryKotlinWithSonar")
        property("sonar.organization", "welldoer-github")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

group = "net.blogjava.welldoer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test-junit5"))
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", "5.5.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}