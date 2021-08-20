package ControllerService;

import Builder.RoomBuilderDTO;
import com.deboraeom.MeetRoom.Controller.RoomResource;
import com.deboraeom.MeetRoom.DTO.MessageDTO;
import com.deboraeom.MeetRoom.DTO.RoomDTO;
import com.deboraeom.MeetRoom.Exception.RoomNotFound;
import com.deboraeom.MeetRoom.Service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Collections;


import static Util.JavaConvertionUtil.asJsonString;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RoomResourceTest {
    private static final String ROOM_API_URL_PATH = "/api/v1/room";

    private MockMvc mockMvc;


    @Mock
    private RoomService roomService;


    @InjectMocks
    private RoomResource roomController;

    @BeforeEach
    void setUp(){
        mockMvc= MockMvcBuilders.standaloneSetup(roomController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPOSTIsCalledWithoutRequiredFieldThenAnErrorIsReturned() throws Exception{
        RoomDTO roomDTO = RoomBuilderDTO.builder().build().roomDTO();
        roomDTO.setName(null);

        mockMvc.perform(post(ROOM_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(roomDTO)))
                .andExpect(status().isBadRequest());

    }


    @Test
    void whenPOSTIsCalledThenRoomIsCreated() throws Exception{

        RoomDTO roomDTO= RoomBuilderDTO.builder().build().roomDTO();
        MessageDTO messageDTO = MessageDTO.builder().message("Room Created successfully").build();
        when(roomService.saveRoom(roomDTO)).thenReturn(messageDTO);
        mockMvc.perform(post(ROOM_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(roomDTO)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.message", is(messageDTO.getMessage())));
    }

/*    @Test
    void whenGetListIsCalledThenReturnAListAndReturnStatusOk() throws Exception {
        RoomDTO roomDTO= RoomBuilderDTO.builder().build().roomDTO();
        when(roomService.findAllRoom()).thenReturn(Collections.singletonList(roomDTO));
        mockMvc.perform(get(ROOM_API_URL_PATH))
                .andExpect(status().isOk());
    }

    @Test
    void whenGetListIsCalledThenReturnAListEmptyAndReturnStatusOk() throws Exception {

        when(roomService.findAllRoom()).thenReturn(Collections.emptyList());
        mockMvc.perform(get(ROOM_API_URL_PATH))
                .andExpect(status().isOk());


    }*/

    @Test
    void whenGetRoomByNameIsCalledThenReturnARoomAndReturnStatusOk() throws Exception {
        RoomDTO roomDTO= RoomBuilderDTO.builder().build().roomDTO();
        when(roomService.findRoomById(roomDTO.getId())).thenReturn(roomDTO);
        mockMvc.perform(get(ROOM_API_URL_PATH+ "/" + roomDTO.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(roomDTO.getName())));

    }

    @Test
    void whenGetRoomByNameIsCalledThenThrowsBecauseDoesntExist() throws Exception {
        RoomDTO sodaDTO= RoomBuilderDTO.builder().build().roomDTO();
        when(roomService.findRoomById(sodaDTO.getId())).thenThrow(RoomNotFound.class);
        mockMvc.perform(get(ROOM_API_URL_PATH+ "/" + sodaDTO.getId()))
                .andExpect(status().isBadRequest());
    }


    @Test
    void whenDeleteRequestThenRoomIsDeletedAndReturnStatusNotContent()throws Exception{
        Long id =1L;
        MessageDTO messageDTO=MessageDTO.builder().message("Room Deleted successfully")
                .build();
        when(roomService.deleteRoom(id)).thenReturn(messageDTO);
        mockMvc.perform(delete(ROOM_API_URL_PATH+ "/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is(messageDTO.getMessage())))
                .andExpect(status().isOk());

    }

    @Test
    void whenDeleteRequestButRoomDoesntExistThenReturnStatusBadRequs()throws Exception{
        Long id =1L;

        when(roomService.deleteRoom(id)).thenThrow(RoomNotFound.class);
        mockMvc.perform(delete(ROOM_API_URL_PATH+ "/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    void whenPutIsCalledWithoutRequiredFieldThenAnErrorIsReturned() throws Exception{
        RoomDTO roomDTO = RoomBuilderDTO.builder().build().roomDTO();
        roomDTO.setId(null);
        when(roomService.updateRoom(roomDTO)).thenThrow(RoomNotFound.class);
        mockMvc.perform(put(ROOM_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(roomDTO)))
                .andExpect(status().isBadRequest());

    }


    @Test
    void whenPUtIsCalledThenRoomIsCreated() throws Exception{

        RoomDTO roomDTO = RoomBuilderDTO.builder().build().roomDTO();
        roomDTO.setName(null);
        mockMvc.perform(put(ROOM_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(roomDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenPUTIsCalledThenRoomIsCreated() throws Exception{

        RoomDTO roomDTO= RoomBuilderDTO.builder().build().roomDTO();
        MessageDTO messageDTO = MessageDTO.builder().message("Room Update successfully").build();
        when(roomService.updateRoom(roomDTO)).thenReturn(messageDTO);
        mockMvc.perform(put(ROOM_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(roomDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is(messageDTO.getMessage())))
                .andDo(print());
    }
}
