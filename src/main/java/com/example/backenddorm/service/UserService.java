package com.example.backenddorm.service;


import com.example.backenddorm.pojo.User;
import com.example.backenddorm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getUser(){
        return userRepository.findAll();
    }

    public boolean addUser(User user){
        try {
            userRepository.insert(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean updateReserve(User user){
        try {
//            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteReserve(User user){
        try {
            userRepository.delete(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public User getRoomByNumber (String room_number) {
        try {
            return userRepository.findByRoomNumber(room_number);
        } catch (Exception e) {
            return null;
        }
    }
}

