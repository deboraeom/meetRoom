package com.deboraeom.MeetRoom.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="room")
@Entity(name="Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "date", nullable = false)
    private String date;
    @Column(name = "startHour", nullable = false)
    private String startHour;
    @Column(name = "endHour", nullable = false)
    private String endHour;
    @Column(name = "responsible", nullable = false)
    private String responsible;


}
