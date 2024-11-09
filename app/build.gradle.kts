plugins {
    kotlin("jvm")
    application
}

group = "com.example.posapp"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.20")
    
    // Database
    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.41.1")
    implementation("org.xerial:sqlite-jdbc:3.42.0.0")
    
    // UI
    implementation("com.formdev:flatlaf:3.1.1")
    implementation("com.formdev:flatlaf-intellij-themes:3.1.1")
    
    // Testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("com.example.posapp.MainKt")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.example.posapp.MainKt"
    }
    
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}