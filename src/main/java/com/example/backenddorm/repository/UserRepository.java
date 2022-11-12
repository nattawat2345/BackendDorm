package com.example.backenddorm.repository;

import com.example.backenddorm.pojo.Reserve;
import com.example.backenddorm.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {
    @Query(value = "{room_number:'?0'}")
    public User findByRoomNumber(String room_number);
}
