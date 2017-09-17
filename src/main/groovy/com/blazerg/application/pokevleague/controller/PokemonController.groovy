package com.blazerg.application.pokevleague.controller

import com.blazerg.application.pokevleague.domain.repository.PokemonRepository
import com.blazerg.application.pokevleague.model.PokemonTeamResponse
import com.blazerg.application.pokevleague.service.PokemonService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.view.RedirectView
import springfox.documentation.annotations.ApiIgnore

@Api(value = 'Pokemon', description = 'The pokemon league API')
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

    @GetMapping(value="/pokemon", produces = "application/json")
    @ResponseBody
    String getExistingPoke(){
        RestTemplate restTemplate = new RestTemplate()
        final HttpHeaders headers = new HttpHeaders()
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11")
        final HttpEntity<String> entity = new HttpEntity<String>(headers)

        Random random = new Random()
        def index = random.nextInt((791 - 1) + 1) + 1

        println(random)

        ResponseEntity<String> response = restTemplate.exchange("http://pokeapi.co/api/v2/pokemon/$index", HttpMethod.GET, entity, String.class)
        response.getBody()

    }

    @ApiIgnore
    @GetMapping(value="/")
    RedirectView emptyUrlRedirect() {
        return new RedirectView("https://poke-vleague.herokuapp.com/swagger-ui.html")
    }
}
