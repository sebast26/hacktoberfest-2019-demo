package pl.sgorecki.gametrading.usecase

import pl.sgorecki.gametrading.domain.DeveloperId
import pl.sgorecki.gametrading.domain.GenreName
import pl.sgorecki.gametrading.domain.Mode
import pl.sgorecki.gametrading.domain.Platform
import pl.sgorecki.gametrading.domain.TraderId

interface AddGameToCatalogUseCase {
    fun addGameToCatalog(command: AddGameToCatalogCommand)
}

class AddGameToCatalogCommand(
    val gameName: String,
    val genreName: GenreName,
    val developerId: DeveloperId,
    val platform: Platform,
    val modes: List<Mode>,
    val traderId: TraderId,
    val notes: String
)
