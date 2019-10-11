package pl.sgorecki.gametrading

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultiKotlinProjectRunner

fun main(args: Array<String>) {
    runApplication<MultiKotlinProjectRunner>(*args)
}
