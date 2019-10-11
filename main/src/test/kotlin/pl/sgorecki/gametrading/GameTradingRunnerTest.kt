package pl.sgorecki.gametrading

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class GameTradingRunnerTest {

    @Test
    fun contextLoads() {
    }

    @SpringBootApplication
    protected class NecessaryInModuleWithoutSpringApp
}
