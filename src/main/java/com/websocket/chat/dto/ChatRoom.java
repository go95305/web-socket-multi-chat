package com.websocket.chat.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String name; //채팅방 이름
    private long userCount; // 채팅방 인원수
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> hashtagList; //해시태그
    private String publisher;//개설자
    private String fixedComment;

    public static ChatRoom create(String name,String publisher,List<String> hashtagList,String fixedComment) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        chatRoom.publisher=publisher;
        chatRoom.hashtagList = new ArrayList<>();
        chatRoom.hashtagList=hashtagList;
        chatRoom.fixedComment=fixedComment;
        return chatRoom;
    }
}