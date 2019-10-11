package pl.sgorecki.gametrading

import java.time.Clock
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClockConfiguration {
    @Bean
    fun realClock(): Clock = Clock.systemUTC()
}
