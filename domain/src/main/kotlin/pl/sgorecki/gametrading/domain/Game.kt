package pl.sgorecki.gametrading.domain

import java.time.OffsetDateTime
import java.util.UUID

class Game(
    private val id: GameId,
    private val name: String,
    private val genre: GenreName,
    private val developer: Developer,
    private val platform: Platform,
    private val modes: List<Mode>,
    private val addedAt: OffsetDateTime,
    private val trader: Trader,
    private val notes: String
)

class GameId(val value: UUID)
class GenreName(val value: String)

enum class Platform {
    WINDOWS, MACOS, LINUX
}

enum class Mode {
    SINGLE_PLAYER, MULTI_PLAYER
}
