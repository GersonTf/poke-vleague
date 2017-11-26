package com.blazerg.application.pokevleague.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * this class handles the telegram's bot commands
 * for example, /getPoke sent by an user goes to the getPokeReceived method
 */
@Service
class TelegramHandlerService {

    @Autowired
    MessageService messageService

    @Autowired
    PokemonService pokemonService

    void messageReceiver(String message, String chatId) {
        String methodName = message.substring(1) + "Received"
        invokeMethod(methodName, chatId)
    }

    void getPokeReceived(String chatId) {
        this.messageService.sendNotificationToTelegram(pokemonService.getExistingPoke().getName(), chatId)
    }

    void getPokeTeamReceived(String chatId){
        6.times {
            this.messageService.sendNotificationToTelegram(pokemonService.getExistingPoke().getName(), chatId)
        }
    }
}
