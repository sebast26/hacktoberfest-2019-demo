package pl.sgorecki.gametrading.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import pl.sgorecki.gametrading.persistence.model.DeveloperEntity

interface DeveloperRepository : JpaRepository<DeveloperEntity, Long>