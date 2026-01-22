import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "2.1.10"
    id("org.springframework.boot") version "4.0.1" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
}

allprojects {
    group = "com.scenarios.oauth2"
    version = "0.1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(25))
        }
    }

    dependencies {
        implementation(kotlin("stdlib"))
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.withType<JavaCompile> {
        options.apply {
            compilerArgs.addAll(listOf(
                "--enable-preview",
                "-Xlint:preview",
                "-parameters"
            ))
        }
    }

    tasks.withType<Test> {
        jvmArgs("--enable-preview")
        useJUnitPlatform()
    }

    tasks.withType<JavaExec> {
        jvmArgs("--enable-preview")
    }

    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_23)
            freeCompilerArgs.add("-Xjvm-enable-preview")
        }
    }
}

// spring 7.0.2
// spring boot 4.0.1
// gradle 9.1.0
// java 25
// kotlin compiler 2.1.10 (./gradlew -q dependencies --configuration kotlinCompilerClasspath)

/**
 * eventually java and kotlin versions mean:
 * Compiler JVM	Java 25
 * Runtime JVM	Java 25
 * Kotlin bytecode	Java 23
 * Java bytecode	Java 23
 */