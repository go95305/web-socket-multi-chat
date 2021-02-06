package com.websocket.chat.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ChatRoom implements Serializable {

    private static final long serialVersionUID = 6494678977089006639L;

    private String roomId; //채팅방 ID
    private String name; // 방 이름
    private String publisher;// 방 개설자
    private long likeCount; //방 좋아요 개수
    private long userCount;
    private String hashtag;

    public static ChatRoom create(String name, String publisher, String hashtag) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        chatRoom.publisher = publisher;
        chatRoom.hashtag = hashtag;
        return chatRoom;
    }
}