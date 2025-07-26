package com.example.websocket_study.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageDto {
    private Long roomId;         // 채팅방 ID
    private Long senderId;       // 보낸 멤버의 ID
    private Long receiverId;     // 받는 멤버의 ID (추후 그룹채팅엔 제외)
    private String content;      // 메시지 내용
    private String senderName;   // 보낸 멤버의 닉네임(편의상)
    private String timestamp;    // 메시지 보낸 시간 (ISO string 등)
}
