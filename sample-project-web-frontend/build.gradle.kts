import com.github.gradle.node.yarn.task.YarnInstallTask
import com.github.gradle.node.yarn.task.YarnTask

plugins {
    id("com.github.node-gradle.node") version "5.0.0"

    java
}

repositories {
    mavenCentral()
}

val yarn = tasks.withType<YarnInstallTask>()

val buildTask = tasks.register<YarnTask>("vite") {
    dependsOn(yarn)

    args.set(listOf("run", "vite", "build"))

    environment.set(mapOf("BUILD_OUT_DIR" to "${rootProject.project("sample-project-web").projectDir}/build/resources/main/frontend"))

    outputs.upToDateWhen { false }
}

val testTask = tasks.register<YarnTask>("vitest") {
    dependsOn(yarn)

    args.set(listOf("run", "vitest"))

    outputs.upToDateWhen { false }
}

tasks.withType<Jar> {
    dependsOn(buildTask)
}

tasks.withType<Test> {
    dependsOn(testTask)
}
