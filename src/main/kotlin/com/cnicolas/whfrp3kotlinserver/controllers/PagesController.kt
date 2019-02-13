package com.cnicolas.whfrp3kotlinserver.controllers

import com.cnicolas.whfrp3kotlinserver.database.repositories.PlayerRepository
import com.cnicolas.whfrp3kotlinserver.database.repositories.findByIdOrNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.ModelMap
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class PagesController(@Autowired private val playerRepository: PlayerRepository) {
    @GetMapping("/")
    fun home(model: ModelMap): ModelAndView {
        model["pageTitle"] = "Home"
        model["players"] = playerRepository.findAll()
        return ModelAndView("home", model)
    }

    @GetMapping("/skills")
    fun skills(model: ModelMap): ModelAndView {
        model["pageTitle"] = "Skills"
        return ModelAndView("skills", model)
    }

    @GetMapping("/actions")
    fun actions(model: ModelMap): ModelAndView {
        model["pageTitle"] = "Actions"
        return ModelAndView("actions", model)
    }

    @GetMapping("/player/{playerId}")
    fun player(model: ModelMap, @PathVariable("playerId") playerId: Long): ModelAndView {
        val player = playerRepository.findByIdOrNull(playerId)
        player?.let {
            model["pageTitle"] = "Player " + player.name
            model["player"] = player
            return ModelAndView("player", model)
        } ?: run {
            return ModelAndView("redirect:/")
        }
    }
}
