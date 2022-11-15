package com.example.backenddorm.repository;


import com.example.backenddorm.pojo.Invoices;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoicesRepository extends MongoRepository<Invoices, String> {
    @Query(value = "{room_number:'?0'}")
    public Invoices findByRoomNumber(String room_number);

    @Query(value = "{room_number:'?0'}")
    public List<Invoices> findRoomsByNumber(String room_number);


    @Query("{'room_number' : ?0, 'month' : ?1, 'year' : ?2}")
    public Invoices findInvoicesByNum(String room_number, String month, int year);

    @Query(value = "{'month' : ?0, 'year' : ?1}")
    public List<Invoices> findRoom(String month, int year);

    @Query(value = "{year:'?0'}")
    public Invoices findByYear(String year);

    @Query(value = "{month:'?0'}")
    public Invoices findByMonth(String month);
}

