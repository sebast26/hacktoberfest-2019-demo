package pl.sgorecki.gametrading.domain

import java.util.UUID

class Developer(private val id: DeveloperId, private val name: String)

class DeveloperId(val value: UUID)
