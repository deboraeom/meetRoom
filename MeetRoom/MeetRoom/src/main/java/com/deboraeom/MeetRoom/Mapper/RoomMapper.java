package com.deboraeom.MeetRoom.Mapper;

import com.deboraeom.MeetRoom.DTO.RoomDTO;
import com.deboraeom.MeetRoom.Entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
    final RoomMapper roomMapper = RoomMapper.INSTANCE;

    Room toModel(RoomDTO roomDTO);

    RoomDTO toDTO(Room room);
}
