import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

version = "0.0.2"
group = "com.unrec"
description = "imdb-csv-parser"
java.sourceCompatibility = JavaVersion.VERSION_11

object Versions {
    const val KOTLIN = "1.6.21"
    const val JACKSON = "2.14.0"
}

plugins {
    kotlin("jvm") version "1.6.21"
    id("maven-publish")
}

dependencies {
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8", version = Versions.KOTLIN)
    testImplementation(group = "org.jetbrains.kotlin", name = "kotlin-test", version = Versions.KOTLIN)
    testImplementation(group = "io.kotest", name = "kotest-assertions-core-jvm", version = "5.5.1")

    implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin", version = Versions.JACKSON)
    implementation(group = "com.fasterxml.jackson.dataformat", name = "jackson-dataformat-csv", version = Versions.JACKSON)
    implementation(group = "com.fasterxml.jackson.datatype", name = "jackson-datatype-jsr310", version = Versions.JACKSON)
}


tasks.apply {
    test {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xjsr305=strict", "-Xinline-classes")
        }
    }
}

publishing {
    publications.create<MavenPublication>("artifact").from(components["java"])
    repositories.mavenLocal()
}

repositories {
    mavenCentral()
}
