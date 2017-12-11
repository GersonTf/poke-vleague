package com.blazerg.application.pokevleague.controller

import com.blazerg.application.pokevleague.domain.repository.PokemonRepository
import com.blazerg.application.pokevleague.model.PokeResponse
import com.blazerg.application.pokevleague.model.PokemonTeamResponse
import com.blazerg.application.pokevleague.service.MessageService
import com.blazerg.application.pokevleague.service.PokemonService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.view.RedirectView
import springfox.documentation.annotations.ApiIgnore

@Api(value = 'Pokemon', description = 'The unofficial pokemon league API')
@RestController
class PokemonController {

    @Autowired
    private MessageService messageService

    @Autowired
    private PokemonService pokemonService
    @Autowired
    private PokemonRepository pokemonRepository

    @ApiOperation(
            notes = 'Method that get you a random single pokemon.',
            response = PokeResponse,
            tags = ['Single Pokemon'],
            value = 'Find a random pokemon for a new signing'
    )

    @ApiResponses(value = [
            @ApiResponse(code = 200, message = 'Successful operation'),
            @ApiResponse(code = 400, message = 'Bad Request'),
            @ApiResponse(code = 404, message = 'Not Found'),
            @ApiResponse(code = 500, message = 'Server error')
    ])

    @RequestMapping(value = "/pokemon/random", produces = "application/json",
            method = RequestMethod.GET)
    @ResponseBody
    PokeResponse getExistingPoke() {
        this.pokemonService.getExistingPoke()
    }

    @ApiOperation(
            notes = 'Method that get you a random pokemon team.',
            response = PokemonTeamResponse,
            tags = ['Pokemon Team'],
            value = 'Find a random team of six pokemon'
    )

    @ApiResponses(value = [
            @ApiResponse(code = 200, message = 'Successful operation'),
            @ApiResponse(code = 400, message = 'Bad Request'),
            @ApiResponse(code = 404, message = 'Not Found'),
            @ApiResponse(code = 500, message = 'Server error')
    ])

    @RequestMapping(value = "/team/random", produces = "application/json",
            method = RequestMethod.GET)
    @ResponseBody
    PokemonTeamResponse getExistingPokeTeam() {

        RestTemplate restTemplate = new RestTemplate()
        final HttpHeaders headers = new HttpHeaders()
        headers.set("User-Agent", "Mozilla/5.0")
        final HttpEntity<String> entity = new HttpEntity<String>(headers)

        List<PokeResponse> pokeTeam = new ArrayList<PokeResponse>()

        6.times {
            ResponseEntity<PokeResponse> response = restTemplate.exchange(
                    "https://pokeapi.co/api/v2/pokemon/${pokemonService.getRandomPokedexId()}",
                    HttpMethod.GET, entity, PokeResponse.class
            )
            pokeTeam.add(response.getBody())
        }

        new PokemonTeamResponse(pokeTeam: pokeTeam)
    }

    @ApiIgnore
    @GetMapping(value = "/")
    RedirectView emptyUrlRedirect() {

        this.messageService.sendNotificationToTelegram("Unknown user access")
        return new RedirectView("https://poke-vleague.herokuapp.com/swagger-ui.html")
    }
}
