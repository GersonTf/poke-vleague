package com.blazerg.application.pokevleague.service

import com.blazerg.application.pokevleague.domain.repository.PokemonRepository
import com.blazerg.application.pokevleague.model.PokeResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository

    PokeResponse getExistingPoke() {

        RestTemplate restTemplate = new RestTemplate()
        final HttpHeaders headers = new HttpHeaders()
        headers.set("User-Agent", "Mozilla/5.0")
        final HttpEntity<String> entity = new HttpEntity<String>(headers)

        def index = getRandomPokedexId()

        ResponseEntity<PokeResponse> response = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/$index", HttpMethod.GET, entity, PokeResponse.class)
        response.getBody()

    }

    Integer getRandomPokedexId() {
        Random random = new Random()
        random.nextInt((721 - 1) + 1) + 1
    }

}
