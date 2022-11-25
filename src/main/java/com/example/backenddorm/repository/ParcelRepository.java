package com.example.backenddorm.repository;

import com.example.backenddorm.pojo.Parcel;
import com.example.backenddorm.pojo.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelRepository extends MongoRepository<Parcel, String> {
    @Query(value = "{room_number:'?0'}")
    public List<Parcel> findByRoomNumber(String room_number);
    @Query(value = "{status:'?0'}")
    public List<Parcel> findByStatus(String status);
    @Query(value = "{status:'?0'}", count = true)
    public Integer countParcel(String status);
}