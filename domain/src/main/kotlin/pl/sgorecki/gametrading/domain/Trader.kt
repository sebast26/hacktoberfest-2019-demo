package pl.sgorecki.gametrading.domain

import java.util.UUID

class Trader(val traderId: TraderId, val name: String)

inline class TraderId(val value: UUID)