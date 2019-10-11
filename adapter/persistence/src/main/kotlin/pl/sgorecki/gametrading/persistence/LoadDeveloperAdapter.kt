package pl.sgorecki.gametrading.persistence

import org.springframework.stereotype.Component
import pl.sgorecki.gametrading.domain.Developer
import pl.sgorecki.gametrading.domain.DeveloperId
import pl.sgorecki.gametrading.port.LoadDeveloperPort

@Component
internal class LoadDeveloperAdapter: LoadDeveloperPort {
    override fun findById(developerId: DeveloperId): Developer? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}