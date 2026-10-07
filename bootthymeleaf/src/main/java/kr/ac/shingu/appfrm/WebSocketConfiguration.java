package kr.ac.shingu.appfrm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import kr.ac.shingu.appfrm.control.WebSocketHandler;
import kr.ac.shingu.appfrm.service.ChatService;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {
    private final Logger log = LoggerFactory.getLogger(WebSocketConfiguration.class);
    private final ChatService chatService;

    public WebSocketConfiguration(ChatService chatService) {
        this.log.debug("WebSocketConfiguration");
        this.chatService = chatService;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        this.log.debug("registerWebSocketHandlers");
        registry.addHandler(new WebSocketHandler(this.chatService), "/chat/ws").setAllowedOrigins("*");
    }
}
