package pl.sgorecki.gametrading.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import pl.sgorecki.gametrading.persistence.model.TraderEntity

interface TraderRepository : JpaRepository<TraderEntity, Long>