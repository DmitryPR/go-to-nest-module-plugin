plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.17.4"
    kotlin("jvm") version "1.9.10"
}

group = "net.eventpanel"
version = "1.0.2"

repositories {
    mavenCentral()
}

intellij {
    version.set("2023.2")
    type.set("IC")
    plugins.set(listOf())
}

tasks {
    patchPluginXml {
        sinceBuild.set("223")
        untilBuild.set("261.*")
    }
}