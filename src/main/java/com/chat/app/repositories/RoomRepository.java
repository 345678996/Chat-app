package com.chat.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chat.app.model.Room;

public interface RoomRepository extends MongoRepository<Room, Long> {
    // Get room using roomId;
    Room findByRoomId(Long roomId);
}
