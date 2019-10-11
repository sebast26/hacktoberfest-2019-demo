plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot") version "2.1.7.RELEASE"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":adapter:web"))
    implementation(project(":adapter:persistence"))
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("kotlin-reflect"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    runtime("com.h2database:h2:1.4.199")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}