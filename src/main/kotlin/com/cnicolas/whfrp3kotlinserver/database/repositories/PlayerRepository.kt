package com.cnicolas.whfrp3kotlinserver.database.repositories

import com.cnicolas.whfrp3kotlinserver.database.entities.Player
import org.springframework.data.repository.CrudRepository

interface PlayerRepository : CrudRepository<Player, Long> {
    override fun findAll(): List<Player> = findAll()

}
