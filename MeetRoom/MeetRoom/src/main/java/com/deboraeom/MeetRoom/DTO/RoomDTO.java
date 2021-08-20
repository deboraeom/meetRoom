package com.deboraeom.MeetRoom.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private Long id;


    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String date;

    @NotNull
    @NotEmpty
    private String startHour;

    @NotNull
    @NotEmpty
    private String endHour;

    @NotNull
    @NotEmpty
    private String responsible;
}
