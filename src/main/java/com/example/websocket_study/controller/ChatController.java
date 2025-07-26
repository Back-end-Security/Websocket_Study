package com.example.websocket_study.controller;


import com.example.websocket_study.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebSocket 데이터를 처리를 수행한 Controller.
 *
 * @author : kimgt
 * @fileName : ChatController
 */

@RequiredArgsConstructor
@RestController
public class ChatController {

    // 특정 사용자에게 메시지를 보내는데 사용되는 STOMP을 이용한 템플릿
    private final SimpMessagingTemplate template;

    // 클라이언트가 메시지 보낼 endpoint → /pub/chat/message
    @MessageMapping("/chat/message")
    public void sendMessage(ChatMessageDto message) {
        System.out.println("메시지 수신됨: " + message.getContent());
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
