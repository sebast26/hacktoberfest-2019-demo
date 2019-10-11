package pl.sgorecki.gametrading.persistence

import org.springframework.stereotype.Component
import pl.sgorecki.gametrading.domain.Trader
import pl.sgorecki.gametrading.domain.TraderId
import pl.sgorecki.gametrading.port.LoadTraderPort

@Component
internal class LoadTraderAdapter: LoadTraderPort {
    override fun findById(traderId: TraderId): Trader? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}