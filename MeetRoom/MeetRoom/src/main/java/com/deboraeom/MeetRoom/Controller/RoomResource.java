package com.deboraeom.MeetRoom.Controller;

import com.deboraeom.MeetRoom.DTO.MessageDTO;
import com.deboraeom.MeetRoom.DTO.RoomDTO;
import com.deboraeom.MeetRoom.Exception.RoomNotFound;
import com.deboraeom.MeetRoom.Service.RoomService;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/room")
@AllArgsConstructor
public class RoomResource {
    private RoomService roomService;

    @PostMapping
    public MessageDTO save(@RequestBody @Valid  RoomDTO roomDTO){
        return (roomService.saveRoom(roomDTO));
    }

    @GetMapping
    public List<RoomDTO> findAllRoom(){

        return roomService.findAllRoom();
    }

    @GetMapping("/{id}")
    public RoomDTO findOneRoomByID(@PathVariable Long id) throws RoomNotFound {
        return roomService.findRoomById(id);
    }

    @PutMapping
    public MessageDTO updateRoom(@RequestBody @Valid RoomDTO roomDTO) throws RoomNotFound {
        return  roomService.updateRoom(roomDTO);

    }

    @DeleteMapping("/{id}")
    public MessageDTO deleteRoom(@PathVariable long id) throws RoomNotFound {
        return roomService.deleteRoom(id);
    }
}
