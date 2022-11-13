package com.example.backenddorm.service;

import com.example.backenddorm.pojo.Room;
import com.example.backenddorm.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }
    public Room getById(String id){
        Optional<Room> roomOptinal = roomRepository.findById(id);
        if (roomOptinal.isEmpty()) {
            return null;
        }
        else {
            return roomOptinal.get();
        }
    }
    public String addNewRoomType(Room room){
        try {
            roomRepository.insert(room);
            return "Add new room type successfully";
        }catch (Exception e){
            return "Add new room type failed";
        }
    }
    public String updateRoomType(Room room){
        try {
            roomRepository.save(room);
            return "update room type successfully";
        }catch (Exception e){
            return "update room type failed";
        }
    }

    public String deleteRoomType(String id){
        try {
            roomRepository.deleteById(id);
            return "delete room type successfully";
        }catch (Exception e){
            return "delete room type failed";
        }
    }

}
