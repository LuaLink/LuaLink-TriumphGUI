import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
  id("java")
  id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "xyz.galaxyy.lualink.addons.triumphgui"

version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  maven("https://codeberg.org/api/packages/LuaLink/maven")
  maven("https://repo.purpurmc.org/snapshots")
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.9.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  compileOnly("org.purpurmc.purpur:purpur-api:1.20.4-R0.1-SNAPSHOT")
  compileOnly("xyz.galaxyy.lualink:lualink:1.20.4-SNAPSHOT")
  implementation("dev.triumphteam:triumph-gui:3.1.7")
}

tasks.withType<ShadowJar> {
  relocate("dev.triumphteam.gui", "xyz.galaxyy.lualink.addons.triumphgui.gui")
}

tasks.test { useJUnitPlatform() }
