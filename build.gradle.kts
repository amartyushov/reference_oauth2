plugins {
    java
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

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(25)
        }
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
}