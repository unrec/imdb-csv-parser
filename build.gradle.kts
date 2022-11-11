import io.gitlab.arturbosch.detekt.Detekt

version = "0.0.1-SNAPSHOT"
group = "com.unrec"
java.sourceCompatibility = JavaVersion.VERSION_11

plugins {
    kotlin("jvm") version "1.6.21"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    id("io.gitlab.arturbosch.detekt").version("1.21.0")
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

detekt {
    buildUponDefaultConfig = true
    config = files("$projectDir/detekt-config.yml")
    parallel = true
}

tasks.withType<Detekt>().configureEach {
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

repositories {
    mavenCentral()
}
