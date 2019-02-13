package com.cnicolas.whfrp3kotlinserver.controllers.player

import com.cnicolas.whfrp3kotlinserver.database.entities.Player
import com.cnicolas.whfrp3kotlinserver.database.repositories.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.view.RedirectView

@RestController
class PlayerController(@Autowired private val playerRepository: PlayerRepository) {

    @PostMapping("/player")
    fun createPlayer(@ModelAttribute player: Player): RedirectView {
        playerRepository.save(player)
        return RedirectView("/")
    }

    @PutMapping("/player")
    fun updatePlayer(model: ModelMap): ModelAndView {
        return ModelAndView("home", model)
    }
}
