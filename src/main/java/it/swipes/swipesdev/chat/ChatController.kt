package it.swipes.swipesdev.chat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.messaging.simp.SimpMessagingTemplate;
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset

@RestController
@RequestMapping(LINK_CHAT)
class ChatController(
        @Autowired
        private val simpleMessagingTemplate: SimpMessagingTemplate
) {
    fun chatSocket(res: Message) {
        sendMessageToUsers(res)
    }

    private fun sendMessageToUsers(message: Message) {
        if (message.receiver != null) {
            simpleMessagingTemplate.convertAndSendToUser(message.receiver!!, CHAT_TOPIC, message)
        } else {
            simpleMessagingTemplate.convertAndSend(CHAT_TOPIC)

            val response = Message(message.text, "Echo bot", LocalDate.now(ZoneOffset.UTC))
            simpleMessagingTemplate.convertAndSend(response)

        }
    }
}