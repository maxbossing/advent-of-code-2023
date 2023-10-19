plugins {
    kotlin("jvm") version "1.9.10"
    application
}

group = "de.maxbossing"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.ajalt.mordant", "mordant", "2.2.0")
}

kotlin {
    jvmToolchain(8)
}

sourceSets {
    main {
        resources.srcDirs("input")
    }
}
