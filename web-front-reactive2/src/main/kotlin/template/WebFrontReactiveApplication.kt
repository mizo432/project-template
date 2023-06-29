package template.modules

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebFrontReactiveApplication

fun main(args: Array<String>) {
    runApplication<WebFrontReactiveApplication>(*args)
}
