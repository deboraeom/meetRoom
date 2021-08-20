package ServiceTest;

import Builder.RoomBuilderDTO;
import com.deboraeom.MeetRoom.DTO.MessageDTO;
import com.deboraeom.MeetRoom.DTO.RoomDTO;
import com.deboraeom.MeetRoom.Entity.Room;
import com.deboraeom.MeetRoom.Exception.RoomNotFound;
import com.deboraeom.MeetRoom.Mapper.RoomMapper;
import com.deboraeom.MeetRoom.Repository.RoomRepository;
import com.deboraeom.MeetRoom.Service.RoomService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    private final Long id = 1L;
    RoomMapper roomMapper = RoomMapper.INSTANCE;

    @Mock
    RoomRepository roomRepository;

    @InjectMocks
    RoomService roomService;



    @Test
    public  void  whenSendValidRoomReturnAMessageDTO(){
        RoomDTO roomDTOToSave = RoomBuilderDTO.builder().build().roomDTO();
        Room roomTOSave = roomMapper.toModel(roomDTOToSave);
        MessageDTO messageDTO = MessageDTO.builder()
                .message("Room Created successfully")
                .build();
        when(roomRepository.save(roomTOSave)).thenReturn(roomTOSave);
        assertThat(roomService.saveRoom(roomDTOToSave), CoreMatchers.is(equalTo(messageDTO)));


    }


   /* @Test
    public void whenRequestAllRoomReturnList(){
        RoomDTO roomDTOToSave = RoomBuilderDTO.builder().build().roomDTO();
        Room roomTOSave = roomMapper.toModel(roomDTOToSave);
        when(roomRepository.findAll()).thenReturn(Collections.singletonList(roomTOSave));
        assertThat(roomService.findAllRoom(),CoreMatchers.is(equalTo(Collections.singletonList(roomMapper.toDTO(roomTOSave)))));

    }*/

  /*  @Test
    public void whenRequestAllPersonReturnEmptyList(){
        RoomDTO roomDTO = RoomBuilderDTO.builder().build().roomDTO();
        Room roomTO = roomMapper.toModel(roomDTO);
        when(roomRepository.findAll()).thenReturn(Collections.emptyList());

        assertThat(roomService.findAllRoom(),CoreMatchers.is(equalTo(Collections.emptyList())));

    }
*/

    @Test
    public void whenRequestOneRoomReturnOneRoom() throws RoomNotFound {
        RoomDTO roomDTO = RoomBuilderDTO.builder().build().roomDTO();
        Room room = roomMapper.toModel(roomDTO);
        when(roomRepository.findById(id)).thenReturn(Optional.of(room));

        assertThat(roomService.findRoomById(id),CoreMatchers.is(equalTo(roomMapper.toDTO(room))));

    }

    @Test
    public void whenRequestANotRegisteredRoomThanReturnThrowsNotFoundPerson() throws RoomNotFound {
        RoomDTO roomDTO = RoomBuilderDTO.builder().build().roomDTO();
        Room room = roomMapper.toModel(roomDTO);
        when(roomRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(RoomNotFound.class,()->roomService.findRoomById(id));

    }

    @Test
    public void whenRequestDeleteARoomSucessfully() throws RoomNotFound {
        RoomDTO roomDTO = RoomDTO.builder().build();
        Room room = roomMapper.toModel(roomDTO);
        Long id=1L;
        when(roomRepository.findById(id)).thenReturn(Optional.of(room));
        doNothing().when(roomRepository).delete(room);
        roomService.deleteRoom(id);
        verify(roomRepository, times(1)).findById(id);
        verify(roomRepository, times(1)).delete(room);
    }


    @Test
    void whenRequestDeletedRoomButNotFound() throws RoomNotFound {
        RoomDTO personDTO = RoomDTO.builder().build();
        Room person = roomMapper.toModel(personDTO);
        Long id=1L;
        when(roomRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(RoomNotFound.class,()->roomService.deleteRoom(id));
    }

    @Test
    void whenRequestUpdateThenReturnMessageDTO() throws RoomNotFound {
        RoomDTO personDTOToUpdate = RoomBuilderDTO.builder().build().roomDTO();
        Room personTOUpdate = roomMapper.toModel(personDTOToUpdate);
        MessageDTO messageDTO = MessageDTO.builder()
                .message("Room update with successfully")
                .build();
        when(roomRepository.findById(personTOUpdate.getId())).thenReturn(Optional.of(personTOUpdate));
        when(roomRepository.save(personTOUpdate)).thenReturn(personTOUpdate);
        assertThat(roomService.updateRoom(personDTOToUpdate), CoreMatchers.is(equalTo(messageDTO)));

    }


    @Test
    void whenRequestUpdateWithNullIdThenReturnThrowsRoomNotFound() throws RoomNotFound {
        RoomDTO personDTOToUpdate = RoomBuilderDTO.builder().build().roomDTO();
        personDTOToUpdate.setId(null);
        assertThrows(RoomNotFound.class,()->roomService.updateRoom(personDTOToUpdate));

    }

    @Test
    void whenRequestUpdateANotRegisteredThenReturnThrowsRoomNotFound() throws RoomNotFound {
        RoomDTO personDTOToUpdate = RoomBuilderDTO.builder().build().roomDTO();
        personDTOToUpdate.setId(null);
        assertThrows(RoomNotFound.class,()->roomService.updateRoom(personDTOToUpdate));

    }
}
