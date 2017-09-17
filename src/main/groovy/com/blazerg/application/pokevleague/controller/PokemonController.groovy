package com.blazerg.application.pokevleague.controller

import com.blazerg.application.pokevleague.domain.entity.Pokemon
import com.blazerg.application.pokevleague.domain.repository.PokemonRepository
import com.blazerg.application.pokevleague.service.PokemonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PokemonController {

    @Autowired
    private PokemonService pokemonService
    @Autowired
    private PokemonRepository pokemonRepository

    @RequestMapping(value="/pokemon", produces = "application/json")
    @ResponseBody
    String getExistingPoke() {
        String nombre = pokemonRepository.findAll().get(0).name
        nombre
    }

    @RequestMapping(value="/")
    String emptyUrlRedirect() {
        pokemonRepository.save(new Pokemon(name: "Charizard"))
        return "Hello World3!"
    }
}
