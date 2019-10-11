package pl.sgorecki.gametrading.persistence.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class TraderEntity(@Id var id: Long, var name: String) {
    constructor() : this(0, "")
}
