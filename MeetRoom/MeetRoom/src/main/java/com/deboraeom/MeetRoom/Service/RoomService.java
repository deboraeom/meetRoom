package com.deboraeom.MeetRoom.Service;

import com.deboraeom.MeetRoom.DTO.MessageDTO;
import com.deboraeom.MeetRoom.DTO.RoomDTO;
import com.deboraeom.MeetRoom.Exception.RoomNotFound;
import com.deboraeom.MeetRoom.Mapper.RoomMapper;
import com.deboraeom.MeetRoom.Repository.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;



@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper = RoomMapper.INSTANCE;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;

    }

    public RoomDTO verifyById(Long id) throws RoomNotFound {
        return roomMapper.toDTO(roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFound(id)));
    }

    public MessageDTO saveRoom(RoomDTO roomDTO) {
        roomRepository.save(roomMapper.toModel(roomDTO));
        return MessageDTO.builder()
                .message("Room Created successfully")
                .build();
    }

    public List<RoomDTO> findAllRoom(){
        return roomRepository.findAll().stream()
                .map(roomMapper::toDTO).collect(Collectors.toList());

    }

    public RoomDTO findRoomById(Long id) throws RoomNotFound {
        return verifyById(id);
    }

    public MessageDTO deleteRoom(Long id) throws RoomNotFound {
        roomRepository.delete(roomMapper.toModel(verifyById(id)));
        return MessageDTO.builder()
                .message("Room Deleted successfully").build();
    }

    public MessageDTO updateRoom(RoomDTO roomDTO) throws RoomNotFound {
        if(isEmpty(roomDTO.getId())) throw  new RoomNotFound(0L );
        verifyById(roomDTO.getId());
        roomRepository.save(roomMapper.toModel(roomDTO));
        return MessageDTO.builder()
                .message("Room update with successfully")
                .build();

    }
}
