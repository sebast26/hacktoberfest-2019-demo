package pl.sgorecki.gametrading

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(
    basePackageClasses = [DomainService::class],
    includeFilters = [ComponentScan.Filter(DomainService::class)]
)
internal class DomainServiceConfiguration