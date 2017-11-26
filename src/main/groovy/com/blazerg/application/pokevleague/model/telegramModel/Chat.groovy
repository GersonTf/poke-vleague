package com.blazerg.application.pokevleague.model.telegramModel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.Canonical

@Canonical
@JsonIgnoreProperties(ignoreUnknown = true)
class Chat {

    def id
    String type
    String title
    String username
}
