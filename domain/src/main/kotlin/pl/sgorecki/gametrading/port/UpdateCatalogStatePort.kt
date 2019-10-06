package pl.sgorecki.gametrading.port

import pl.sgorecki.gametrading.domain.Game

interface UpdateCatalogStatePort {
    fun addGameToCatalog(newGame: Game): Game
}