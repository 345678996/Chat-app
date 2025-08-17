package com.chat.app.service;

import java.util.List;

import com.chat.app.model.Message;
import com.chat.app.model.Room;

public interface RoomService {

    Room createRoom(Long roomId);

    Room joinRoom(Long roomId);

    List<Message> getMessages(Long roomID);

}
