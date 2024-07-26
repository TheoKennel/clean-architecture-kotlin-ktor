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
val junitVersion = "5.10.2"
val mockitoCoreVersion = "5.12.0"

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
    implementation("io.ktor:ktor-server-status-pages:$ktorVersion")
    // firebase
    implementation("com.google.firebase:firebase-admin:$firebaseVersion")
    // dotenv
    implementation("io.github.cdimascio:java-dotenv:$dotenvVersion")
    // tests
    testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")
    testImplementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.mockito:mockito-core:$mockitoCoreVersion")
}

kapt {
    correctErrorTypes = true
}
//
//application {
//    mainClass.set("MainKt")
//}

tasks.test {
    useJUnitPlatform()
}
