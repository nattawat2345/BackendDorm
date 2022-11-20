package com.example.backenddorm.repository;

import com.example.backenddorm.pojo.Rent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends MongoRepository<Rent, String> {
    @Query(value = "{room_number:'?0'}")
    public Rent findByRoomNumber(String room_number);

    @Query(value = "{room_status:'?0'}", count = true)
    public Integer countRoom(String room_status);

    @Query(value = "{room_type: '?0',room_status:'?1'}")
    public List<Rent> countRoomType(String type, String status);
}