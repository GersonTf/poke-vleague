package com.blazerg.application.pokevleague.model.telegramModel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.Canonical

@Canonical
@JsonIgnoreProperties(ignoreUnknown = true)
class User {
    def id
    String first_name
    boolean is_bot
}

