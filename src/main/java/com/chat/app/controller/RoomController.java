package com.chat.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.model.Room;
import com.chat.app.service.RoomService;

@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;
    //Create Room
    @PostMapping("/api/v1")
    public ResponseEntity<Room> createRoom(@RequestBody Long roomId) {
        Room createdRoom = roomService.createRoom(roomId);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    // get room and then join room
    public ResponseEntity<Room> joinRoom(@RequestBody Long roomId) {
        Room room = roomService.joinRoom(roomId);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

}
