package sample.project.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringNodeGradleBuildApplication

fun main(args: Array<String>) {
    runApplication<SpringNodeGradleBuildApplication>(*args)
}
