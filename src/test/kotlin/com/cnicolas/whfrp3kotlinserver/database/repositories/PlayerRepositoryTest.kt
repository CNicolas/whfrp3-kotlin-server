package com.cnicolas.whfrp3kotlinserver.database.repositories

import com.cnicolas.whfrp3kotlinserver.database.entities.Player
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
class PlayerRepositoryTest(@Autowired val entityManager: TestEntityManager,
                           @Autowired val playerRepository: PlayerRepository) {
    @Test
    fun `When findAll then return players`() {
        val player = Player("PlayerName")
        entityManager.persist(player)
        entityManager.flush()

        val players = playerRepository.findAll()
        assertThat(players).isNotEmpty
        assertThat(players[0].name).isEqualTo("PlayerName")
    }

    @Test
    fun `When save then findAll returns 1 player`() {
        val player = Player("PlayerName")
        playerRepository.save(player)

        val players = playerRepository.findAll()
        assertThat(players).isNotEmpty
        assertThat(players[0].name).isEqualTo("PlayerName")
    }
}
