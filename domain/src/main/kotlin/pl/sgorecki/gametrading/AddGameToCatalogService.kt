package pl.sgorecki.gametrading

import java.time.Clock
import java.time.ZoneOffset
import java.util.UUID
import pl.sgorecki.gametrading.domain.Developer
import pl.sgorecki.gametrading.domain.DeveloperId
import pl.sgorecki.gametrading.domain.Game
import pl.sgorecki.gametrading.domain.GameId
import pl.sgorecki.gametrading.domain.GenreName
import pl.sgorecki.gametrading.domain.Trader
import pl.sgorecki.gametrading.domain.TraderId
import pl.sgorecki.gametrading.port.LoadDeveloperPort
import pl.sgorecki.gametrading.port.LoadTraderPort
import pl.sgorecki.gametrading.port.UpdateCatalogStatePort
import pl.sgorecki.gametrading.usecase.AddGameToCatalogCommand
import pl.sgorecki.gametrading.usecase.AddGameToCatalogUseCase

@DomainService
internal class AddGameToCatalogService(
    private val loadDeveloperPort: LoadDeveloperPort,
    private val loadTraderPort: LoadTraderPort,
    private val updateCatalogStatePort: UpdateCatalogStatePort,
    private val clock: Clock
) : AddGameToCatalogUseCase {

    override fun addGameToCatalog(command: AddGameToCatalogCommand) {
        requireGenreExists(command.genreName)
        val developer = requireDeveloperExists(command.developerId)
        val trader = requireTraderExists(command.traderId)

        val newGame = Game(
            GameId(UUID.randomUUID()),
            command.gameName,
            command.genreName,
            developer,
            command.platform,
            command.modes,
            clock.instant().atOffset(ZoneOffset.UTC),
            trader,
            command.notes
        )

        val game = updateCatalogStatePort.addGameToCatalog(newGame)
    }

    private fun requireGenreExists(genreName: GenreName) {
    }

    private fun requireDeveloperExists(developerId: DeveloperId): Developer {
        return loadDeveloperPort.findById(developerId) ?: throw IllegalStateException("Developer do not exist")
    }

    private fun requireTraderExists(traderId: TraderId): Trader {
        return loadTraderPort.findById(traderId) ?: throw IllegalStateException("Trader do not exist")
    }
}
