/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn how to create Gradle builds at https://guides.gradle.org/creating-new-gradle-builds/
 */
plugins {
    application
    kotlin("jvm") version "1.2.61"
}

application {
    mainClassName = "main.MainKt"
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.hexworks.zircon:zircon.jvm.swing:2018.5.0-RELEASE")
}

repositories {
    jcenter()
}