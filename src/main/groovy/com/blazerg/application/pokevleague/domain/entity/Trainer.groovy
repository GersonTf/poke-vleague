package com.blazerg.application.pokevleague.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'TRAINER')
class Trainer {

    @Column(name = 'TRAINERID')
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Long trainerId

    @Column(name = 'TRAINERNAME')
    String name
}
