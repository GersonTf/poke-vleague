package com.blazerg.application.pokevleague.model.telegramModel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.Canonical

@Canonical
@JsonIgnoreProperties(ignoreUnknown = true)
class Update {

    def update_id
    Message message
}
