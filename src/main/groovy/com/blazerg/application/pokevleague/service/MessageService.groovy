package com.blazerg.application.pokevleague.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
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

    @Autowired
    private Environment environment

    /**
     * It sends a message to a telegram bot
     * @param message to send
     */
    void sendNotificationToTelegram(String message) {

        RestTemplate restTemplate = new RestTemplate()
        Date accessDate = new Date()
        String finalMessage = message + " " + accessDate

        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED)

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>()
        params.add("chat_id",  environment.getProperty("CHAT_ID"))
        params.add("text", finalMessage)

        HttpEntity<LinkedMultiValueMap<String, Object>> request = new HttpEntity<>(params, headers)

        restTemplate.postForEntity(
                environment.getProperty("URL_TELEGRAM"),
                request, String.class
        )
    }
}
