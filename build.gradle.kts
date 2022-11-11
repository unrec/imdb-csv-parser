version = "0.0.1-SNAPSHOT"
group = "com.unrec"
java.sourceCompatibility = JavaVersion.VERSION_11

plugins {
    kotlin("jvm") version "1.6.21"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

repositories {
    mavenCentral()
}
