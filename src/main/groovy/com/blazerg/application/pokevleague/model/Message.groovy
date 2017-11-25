package com.blazerg.application.pokevleague.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.Canonical

@Canonical
@JsonIgnoreProperties(ignoreUnknown = true)
class Message {
    def message_id
//    private User from;
    Integer date
    Chat chat
    String text
}