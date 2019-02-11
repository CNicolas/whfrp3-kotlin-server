package com.cnicolas.whfrp3kotlinserver.controllers

import org.springframework.ui.ModelMap
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class PagesController {
    @GetMapping("/")
    fun home(model: ModelMap): ModelAndView {
        model["pageTitle"] = "Home"
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
}
