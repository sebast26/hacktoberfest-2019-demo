package pl.sgorecki.gametrading.port

import pl.sgorecki.gametrading.domain.Trader
import pl.sgorecki.gametrading.domain.TraderId

interface LoadTraderPort {
    fun findById(traderId: TraderId): Trader?
}
