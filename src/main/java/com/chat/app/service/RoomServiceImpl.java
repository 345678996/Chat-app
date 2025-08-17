package com.chat.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.app.exceptions.APIException;
import com.chat.app.model.Message;
import com.chat.app.model.Room;
import com.chat.app.repositories.RoomRepository;

@Service
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
        Room existingRoom = roomRepository.findByRoomId(roomId);
        if(existingRoom == null) {
            throw new APIException("Room does not exist, Please create one");
        } 
        return existingRoom;
    }

    @Override
    public List<Message> getMessages(Long roomID) {
        Room existingRoom = roomRepository.findByRoomId(roomID);
        if(existingRoom == null) {
            throw new APIException("Room does not exist!");
        }
        List<Message> messages = existingRoom.getMessages();
        return messages;
    }


}
