package com.deboraeom.MeetRoom.Repository;

import com.deboraeom.MeetRoom.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
