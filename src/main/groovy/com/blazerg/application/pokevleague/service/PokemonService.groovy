package com.blazerg.application.pokevleague.service

import com.blazerg.application.pokevleague.domain.repository.PokemonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository
}
