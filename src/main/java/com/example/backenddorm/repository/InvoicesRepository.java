package com.example.backenddorm.repository;


import com.example.backenddorm.pojo.Invoices;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository extends MongoRepository<Invoices, String> {
    @Query(value = "{room_number:'?0'}")
    public Invoices findByRoomNumber(String room_number);
}

