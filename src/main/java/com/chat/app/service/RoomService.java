package com.chat.app.service;

import com.chat.app.model.Room;

public interface RoomService {

    Room createRoom(Long roomId);

    Room joinRoom(Long roomId);

}
