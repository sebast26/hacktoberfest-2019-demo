package pl.sgorecki.gametrading.web

import java.util.UUID
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import pl.sgorecki.gametrading.domain.DeveloperId
import pl.sgorecki.gametrading.domain.GenreName
import pl.sgorecki.gametrading.domain.Mode
import pl.sgorecki.gametrading.domain.Platform
import pl.sgorecki.gametrading.domain.TraderId
import pl.sgorecki.gametrading.usecase.AddGameToCatalogCommand
import pl.sgorecki.gametrading.usecase.AddGameToCatalogUseCase

@RestController
class GameController(private val addGameToCatalogUseCase: AddGameToCatalogUseCase) {

    @PostMapping("/catalog/games")
    fun createGameInCatalog(@RequestBody game: GameResource) {
        val developerId = extractUuidOrThrow(game.developerId)
        val platform = extractPlatformOrThrow(game.platform)
        val modes = extractModesOrThrow(game.modes)
        val traderId = extractUuidOrThrow(game.traderId)

        val command = AddGameToCatalogCommand(
            gameName = game.name,
            genreName = GenreName(game.genre),
            developerId = DeveloperId(developerId),
            platform = platform,
            modes = modes,
            traderId = TraderId(traderId),
            notes = game.notes
        )

        addGameToCatalogUseCase.addGameToCatalog(command)
    }

    private fun extractUuidOrThrow(value: String) = UUID.fromString(value)

    private fun extractPlatformOrThrow(platform: String): Platform {
        return Platform.values().find { it.name == platform } ?: throw IllegalArgumentException("Invalid platform")
    }

    private fun extractModesOrThrow(modes: List<String>): List<Mode> {
        return modes.map { strMode ->
            run {
                Mode.values().find { it.name == strMode } ?: throw IllegalArgumentException("Invalid mode")
            }
        }
    }
}

data class GameResource(
    val name: String,
    val genre: String,
    val developerId: String,
    val platform: String,
    val modes: List<String>,
    val traderId: String,
    val notes: String
)
