package com.chat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.model.Message;
import com.chat.app.model.Room;
import com.chat.app.service.RoomService;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;
    //Create Room
    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createdRoom = roomService.createRoom(room.getRoomId());
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    // get room and then join room
    @GetMapping("{roomId}")
    public ResponseEntity<Room> joinRoom(@PathVariable Long roomId) {
        Room room = roomService.joinRoom(roomId);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    // Get messages of a room
    @GetMapping("{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Long roomId) {
        List<Message> messages = roomService.getMessages(roomId);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

}
