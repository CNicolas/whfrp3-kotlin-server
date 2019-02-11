package com.cnicolas.whfrp3kotlinserver.home

import org.springframework.ui.ModelMap
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class SkillsController {
    @GetMapping("/skills")
    fun skills(model: ModelMap): ModelAndView {
        model["pageTitle"] = "Skills"
        return ModelAndView("skills", model)
    }
}
