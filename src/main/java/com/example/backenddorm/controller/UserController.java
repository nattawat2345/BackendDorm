package com.example.backenddorm.controller;



import com.example.backenddorm.pojo.User;
import com.example.backenddorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    public List<User> getUser(){
        return userService.getUser();
    }

    @RequestMapping(value ="/addUser", method = RequestMethod.POST)
    public boolean addReserve(@RequestBody User user){
        try {
            userService.addUser(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/updateUser", method = RequestMethod.POST)
    public boolean updateUser(@RequestBody User user){
        try {
            userService.updateReserve(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/deleteUser", method = RequestMethod.POST)
    public boolean deleteUser(@RequestBody User user){
        try {
            userService.deleteReserve(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/getUserNum/{room_number}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserNum(@PathVariable("room_number") String room_number){
        try {
            User user = userService.getRoomByNumber(room_number);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return null;
        }
    }
}

