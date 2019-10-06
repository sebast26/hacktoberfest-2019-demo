package pl.sgorecki.gametrading.port

import pl.sgorecki.gametrading.domain.Developer
import pl.sgorecki.gametrading.domain.DeveloperId

interface LoadDeveloperPort {
    fun findById(developerId: DeveloperId): Developer?
}