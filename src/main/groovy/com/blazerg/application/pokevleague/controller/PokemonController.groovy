package com.blazerg.application.pokevleague.controller

import com.blazerg.application.pokevleague.service.PokemonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PokemonController {

    @Autowired
    PokemonService pokemonService

    @RequestMapping(value="/pokemon", produces = "application/json")
    @ResponseBody
    String getExistingPoke() {
        return "Hello World2!"
    }

    @RequestMapping(value="/")
    String emptyUrlRedirect() {
        return "Hello World3!"
    }
}
