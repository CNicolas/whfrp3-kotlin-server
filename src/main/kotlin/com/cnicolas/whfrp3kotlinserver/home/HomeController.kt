package com.cnicolas.whfrp3kotlinserver.home

import org.springframework.ui.ModelMap
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class HomeController {
    @GetMapping("/")
    fun home(model: ModelMap): ModelAndView {
        model["pageTitle"] = "Home"
        return ModelAndView("home", model)
    }
}
