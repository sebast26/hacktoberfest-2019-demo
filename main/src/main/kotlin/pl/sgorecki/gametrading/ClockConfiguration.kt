package pl.sgorecki.gametrading

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Clock

@Configuration
class ClockConfiguration {
    @Bean
    fun realClock(): Clock = Clock.systemUTC()
}