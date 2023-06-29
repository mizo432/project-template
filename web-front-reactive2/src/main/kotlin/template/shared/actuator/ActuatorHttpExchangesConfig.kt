package template.shared.actuator

import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ActuatorHttpExchangesConfig {
    private val EXCHANGE_CAPACITY: Int = 2000

    @Bean
    fun httpExchangeRepository(): HttpExchangeRepository? {
        val repository = InMemoryHttpExchangeRepository()
        repository.setCapacity(EXCHANGE_CAPACITY)
        return repository
    }

}