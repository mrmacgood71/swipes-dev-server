package it.swipes.swipesdev.config

import it.swipes.swipesdev.chat.LINK_CHAT
import it.swipes.swipesdev.chat.TOPIC
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
open class WebSocketConfig: WebSocketMessageBrokerConfigurer {

    override fun configureMessageBroker(config: MessageBrokerRegistry) {
        config.enableSimpleBroker(TOPIC)

        config.setApplicationDestinationPrefixes(LINK_CHAT);
        config.setUserDestinationPrefix("/user");
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {

        registry.addEndpoint(LINK_CHAT)
            .setAllowedOrigins("*")
            .withSockJS()
    }


}