package com.blazerg.application.pokevleague.service

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

/**
 * this service connects to a telegram by sending messages
 */
@Service
class MessageService {

    /**
     * It sends a message to a telegram bot
     * @param message to send
     */
    void sendNotificationToTelegram(String message){

        RestTemplate restTemplate = new RestTemplate()
        Date accessDate = new Date()

        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>()
        map.add("chat_id", "-279181328")
        map.add("text", "$message $accessDate")

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers)

        restTemplate.postForEntity(
                "https://api.telegram.org/bot496020190:AAHQSbdhA6mm02D7jpFDIK1Qjtq4lsYz2Js/sendMessage",
                request , String.class )

    }
}
