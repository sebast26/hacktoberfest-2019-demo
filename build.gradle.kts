import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    kotlin("jvm") version "1.3.31" apply false
    kotlin("plugin.spring") version "1.3.31" apply false
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

extra["kotlin.version"] = "1.3.11"

allprojects {
    group = "pl.sgorecki.multiKotlinProject"
    version = "0.0.1-SNAPSHOT"

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "java-library")

    repositories {
        jcenter()
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.1.7.RELEASE")
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    tasks.withType<Test> {
        testLogging {
            events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        }
    }

    val ktlint by configurations.creating

    dependencies {
        ktlint("com.pinterest:ktlint:0.34.2")
    }

    val ktlintCheck by tasks.creating(JavaExec::class) {
        description = "Check Kotlin code style."
        classpath = ktlint
        group = "verification"
        main = "com.pinterest.ktlint.Main"
        args = listOf("src/**/*.kt")
    }
    tasks.getByName("check") {
        dependsOn(ktlintCheck)
    }

    tasks.create<JavaExec>("ktlintFormat") {
        description = "Fix Kotlin code style deviations."
        classpath = ktlint
        group = "formatting"
        main = "com.pinterest.ktlint.Main"
        args = listOf("-F", "src/**/*.kt")
    }
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}
