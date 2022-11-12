package com.example.backenddorm.controller;

import com.example.backenddorm.pojo.Room;
import com.example.backenddorm.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
