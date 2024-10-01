plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(libs.kotlin.stdlib)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.mockito.core.v400)
    testImplementation(libs.mockito.kotlin.v400)
}