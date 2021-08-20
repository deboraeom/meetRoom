package com.deboraeom.MeetRoom.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RoomNotFound extends Exception{

        public RoomNotFound(Long roomName) {
            super(String.format("Soda with name %s not found.", roomName));
        }

    }
