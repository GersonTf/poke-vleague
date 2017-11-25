package com.blazerg.application.pokevleague.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.Canonical

@Canonical
@JsonIgnoreProperties(ignoreUnknown = true)
class Message {
    int message_id
//    private User from;
    int date
//    private Chat chat;
    String text
}