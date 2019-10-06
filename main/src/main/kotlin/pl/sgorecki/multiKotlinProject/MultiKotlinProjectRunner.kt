package pl.sgorecki.multiKotlinProject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultiKotlinProjectRunner

fun main(args: Array<String>) {
    runApplication<MultiKotlinProjectRunner>(*args)
}
