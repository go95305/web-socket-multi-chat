package com.websocket.chat.controller;

import com.websocket.chat.model.ChatRoom;
import com.websocket.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;
    @GetMapping("/room")
    public String rooms() {
        return "/chat/room";
    }
    // 모든 채팅방 목록 반환(메인 페이지)
    @GetMapping("/rooms")
    public List<ChatRoom> room() {
        List<ChatRoom> chatRooms = chatRoomRepository.findAllRoom();
        chatRooms.stream().forEach(room -> room.setUserCount(chatRoomRepository.getUserCount(room.getRoomId())));
        return chatRooms;
    }
    // 채팅방 생성
    @PostMapping("/room")
    public ChatRoom createRoom(@RequestBody ChatRoom chatRoom) {
        return chatRoomRepository.createChatRoom(chatRoom);
    }

    // 특정 채팅방 입장
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatRoomRepository.findRoomById(roomId);
    }
}