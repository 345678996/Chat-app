package com.chat.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.chat.app.exceptions.APIException;
import com.chat.app.model.Room;
import com.chat.app.repositories.RoomRepository;

public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room createRoom(Long roomId) {
        Room existingRoom = roomRepository.findByRoomId(roomId);
        if(existingRoom != null) {
            // Room exist
            throw new APIException("Room already exist!");
        }
        // Create new Room;
        Room room = new Room();
        room.setRoomId(roomId);

        Room savedRoom = roomRepository.save(room);
        
        return savedRoom;
    }

    @Override
    public Room joinRoom(Long roomId) {
        return null;
    }


}
