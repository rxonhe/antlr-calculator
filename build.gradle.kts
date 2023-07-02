import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
    id("antlr")
}

group = "com.choinhet"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}


repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("com.javiersc.kotlin:kotlin-stdlib:0.1.0-alpha.11")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    implementation("org.antlr:antlr4:4.12.0")
    antlr("org.antlr:antlr4:4.12.0")
}

sourceSets {
    main {
        java {
            srcDirs("src/main/java", "src/main/antlr4")
        }
    }
}
tasks.register<AntlrTask>("generateCalculatorGrammarSource") {
    maxHeapSize = "64m"
    group = "build"
    source = fileTree("src/main/antlr4")
    arguments = listOf(
        "-visitor",
        "-long-messages",
        "-package", "com.choinhet.calculator",
        "src/main/antlr4/com/choinhet/Calculator.g4"
    )
    outputDirectory = file("${project.buildDir}/generated-src/antlr/main")
}

tasks.named("generateTestGrammarSource").get().enabled = false

tasks.withType<KotlinCompile>().configureEach {
    dependsOn("generateCalculatorGrammarSource")
    source("src/main/java", "${project.buildDir}/generated-src/antlr/main")
}
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
