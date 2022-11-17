package com.example.backenddorm.repository;

import com.example.backenddorm.pojo.Parcel;
import com.example.backenddorm.pojo.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends MongoRepository<Parcel, String> {
    @Query(value = "{room_number:'?0'}")
    public Parcel findByRoomNumber(String room_number);
}