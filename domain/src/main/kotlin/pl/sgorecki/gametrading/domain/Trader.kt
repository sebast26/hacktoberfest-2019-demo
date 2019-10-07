package pl.sgorecki.gametrading.domain

import java.util.UUID

class Trader(val traderId: TraderId, val name: String)

class TraderId(val value: UUID)
