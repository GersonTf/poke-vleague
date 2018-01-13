package com.blazerg.application.pokevleague.service

import com.blazerg.application.pokevleague.model.PokeResponse
import com.blazerg.application.pokevleague.model.telegramModel.Update
import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

/**
 * this class handles the telegram's bot commands
 * for example, /getPoke sent by an user goes to the getPokeReceived method
 */
@Log
@Service
class TelegramHandlerService {

    @Autowired
    MessageService messageService

    @Autowired
    PokemonService pokemonService

    private static final def destinCodes = ["getPoke", "getPokeTeam", "getAyuda, createTeam"]

    void messageReceiver(String message, Update params) {
        if (destinCodes.contains(message)) {
            String methodName = message + "Received"
            invokeMethod(methodName, params)
        }
    }

    void getPokeReceived(Update params) {
        String chatId = params?.message?.getChat()?.getId()
        this.messageService.sendNotificationToTelegram(pokemonService.getExistingPoke().getName(), chatId)
    }

    void getPokeTeamReceived(Update params) {
        String chatId = params?.message?.getChat()?.getId()
        String finalMessage = ""
        6.times {
            finalMessage += pokemonService.getExistingPoke().getName() + ", "
        }
        this.messageService.sendNotificationToTelegram(finalMessage, chatId)
    }

    void createTeamReceived(Update params) {
        log.info("creating new team")
        ArrayList<PokeResponse> pokeTeam = new ArrayList<PokeResponse>()

        6.times {
            pokeTeam.add(pokemonService.getExistingPoke())
        }

        RestTemplate restTemplate = new RestTemplate()

        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)

        MultiValueMap<String, Object> headerParams = new LinkedMultiValueMap<String, Object>()
        headerParams.add("name", params.message.from)
        headerParams.add("pokeTeam", pokeTeam)

        HttpEntity<LinkedMultiValueMap<String, Object>> request = new HttpEntity<>(headerParams, headers)

        restTemplate.postForEntity(
                "https://poketeam-builder.herokuapp.com/trainers",
                request, String.class
        )

        log.info("new team created")
    }
}
