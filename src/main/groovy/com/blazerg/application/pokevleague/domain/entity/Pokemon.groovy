package com.blazerg.application.pokevleague.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'POKEMON')
class Pokemon {

    @Column(name = 'POKEDEXID')
    @GeneratedValue
    @Id
    Long pokedexId

    @Column(name = 'POKENAME')
    String name
}
