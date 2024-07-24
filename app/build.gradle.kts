import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
    id("io.ktor.plugin") version "2.3.12"
    id("org.jetbrains.kotlin.kapt") version "1.9.0"
}

repositories {
    mavenCentral()
}

val ktorVersion = "2.3.12"
val daggerVersion = "2.46"
val coroutineVersion = "1.5.2"
val kotlinVersion = "1.9.0"
val firebaseVersion = "8.1.0"
val dotenvVersion = "5.2.2"
val gsonVersion = "2.11.0"

dependencies {
    // coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    // dagger
    implementation("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    // ktor
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-config-yaml:$ktorVersion")
    implementation("io.ktor:ktor-serialization-gson:$ktorVersion")
    // tests
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
    // firebase
    implementation("com.google.firebase:firebase-admin:$firebaseVersion")
    //dotenv
    implementation("io.github.cdimascio:java-dotenv:$dotenvVersion")
}

kapt {
    correctErrorTypes = true
}

application {
    mainClass.set("MainKt")
}
