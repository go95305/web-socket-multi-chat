package com.websocket.chat.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ChatRoom implements Serializable {

    private static final long serialVersionUID = 6494678977089006639L;

    @Id
    @GeneratedValue
    private String roomId; //채팅방 ID
    private String roomName; //채팅방 이름
    private long userCount; // 채팅방 인원수
    private String publisher; //개설자


    public static ChatRoom create(String roomName,String publisher) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.roomName = roomName;
        chatRoom.publisher=publisher;
        chatRoom.userCount=0;
        return chatRoom;
    }
}