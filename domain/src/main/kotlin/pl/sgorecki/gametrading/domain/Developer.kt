package pl.sgorecki.gametrading.domain

import java.util.UUID

class Developer(private val id: DeveloperId, private val name: String)

inline class DeveloperId(val value: UUID)