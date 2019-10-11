package pl.sgorecki.gametrading.persistence

import org.springframework.stereotype.Component
import pl.sgorecki.gametrading.domain.Game
import pl.sgorecki.gametrading.port.UpdateCatalogStatePort

@Component
internal class UpdateCatalogStateAdapter: UpdateCatalogStatePort {
    override fun addGameToCatalog(newGame: Game): Game {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}