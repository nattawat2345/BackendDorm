package com.example.backenddorm.controller;

import com.example.backenddorm.pojo.Room;
import com.example.backenddorm.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/getall")
    public List<Room> getAllRoom() {
        List<Room> rooms = roomService.getAllRoom();
        return rooms;
    }

    @GetMapping("/getbyid")
    public Room getById(@RequestParam String id) {
        Room room = roomService.getById(id);
        return room;
    }
    @PostMapping("/add")
    public String addNewRoom(@RequestBody Room room){
        return roomService.addNewRoomType(room);
    }
    @PutMapping("/update")
    public String updateRoom(@RequestBody Room room){
        return roomService.updateRoomType(room);
    }
    @DeleteMapping("/delete")
    public String deleteRoom(@RequestParam String id){
        return  roomService.deleteRoomType(id);
    }
}
