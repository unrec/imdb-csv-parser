import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

version = "0.0.1-SNAPSHOT"
group = "com.unrec"
description = "imdb-csv-parser"
java.sourceCompatibility = JavaVersion.VERSION_11

object Versions {
    const val KOTLIN = "1.6.21"
    const val JACKSON = "2.14.0"
}

plugins {
    kotlin("jvm") version "1.6.21"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
}

dependencies {
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8", version = Versions.KOTLIN)
    testImplementation(group = "org.jetbrains.kotlin", name = "kotlin-test", version = Versions.KOTLIN)
    testImplementation(group = "io.kotest", name = "kotest-assertions-core-jvm", version = "5.5.1")

    implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin", version = Versions.JACKSON)
    implementation(group = "com.fasterxml.jackson.dataformat", name = "jackson-dataformat-csv", version = Versions.JACKSON)
    implementation(group = "com.fasterxml.jackson.datatype", name = "jackson-datatype-jsr310", version = Versions.JACKSON)
}

detekt {
    buildUponDefaultConfig = true
    config = files("$projectDir/detekt-config.yml")
    parallel = true
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

    withType<Detekt>().configureEach {
        jvmTarget = "1.8"

        reports {
            txt.required.set(false)
            html.required.set(true)
            with(xml) {
                required.set(true)
                outputLocation.set(file("$buildDir/reports/detekt/detekt.xml"))
            }
        }
    }
}

repositories {
    mavenCentral()
}
