package Builder;

import com.deboraeom.MeetRoom.DTO.RoomDTO;

import lombok.Builder;

@Builder
public class RoomBuilderDTO {
    @Builder.Default
    private Long id= 1L;

    @Builder.Default
    private String name= "Java";

    @Builder.Default
    private String date="11/08/2021";

    @Builder.Default
    private String startHour="14hrs";

    @Builder.Default
    private String endHour="16hrs";

    @Builder.Default
    private String responsible="Ariadna";

    public RoomDTO roomDTO(){
        return new RoomDTO(id,
                name,
                date,
                startHour,
                endHour,
                responsible);
    }
}
