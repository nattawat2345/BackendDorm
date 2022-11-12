package com.example.backenddorm.repository;

import com.example.backenddorm.pojo.Rent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends MongoRepository<Rent, String> {
    @Query(value = "{room_number:'?0'}")
    public Rent findByRoomNumber(String room_number);
}
