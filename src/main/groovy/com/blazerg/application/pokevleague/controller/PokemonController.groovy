package com.blazerg.application.pokevleague.controller

import com.blazerg.application.pokevleague.domain.entity.Pokemon
import com.blazerg.application.pokevleague.domain.repository.PokemonRepository
import com.blazerg.application.pokevleague.model.PokemonTeamResponse
import com.blazerg.application.pokevleague.service.PokemonService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@Api(value = 'Pokemon', description = 'The pokemon getting API')
@RestController
class PokemonController {

    @Autowired
    private PokemonService pokemonService
    @Autowired
    private PokemonRepository pokemonRepository

    @ApiOperation(
            notes = 'Method that get you a random pokemon.',
            response = PokemonTeamResponse,
            tags = ['Pokemon Team'],
            value = 'Find a random pokemon using the pokeApi'
    )

    @ApiResponses(value = [
            @ApiResponse(code = 200, message = 'Successful operation'),
            @ApiResponse(code = 400, message = 'Bad Request'),
            @ApiResponse(code = 404, message = 'Not Found'),
            @ApiResponse(code = 500, message = 'Server error')
    ])

    @RequestMapping(value="/pokemon", produces = "application/json")
    @ResponseBody
    String getExistingPoke() {
        println pokemonRepository.findAll().name
        String nombre = pokemonRepository.findAll().get(0).name
        nombre
    }

    @RequestMapping(value="/")
    String emptyUrlRedirect() {
        pokemonRepository.save(new Pokemon(name: "Charizard"))
        return "Hello World3!"
    }
}
