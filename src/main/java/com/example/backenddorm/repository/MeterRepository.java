package com.example.backenddorm.repository;

import com.example.backenddorm.pojo.Meter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterRepository extends MongoRepository<Meter,String> {
    @Query(value = "{utilities_type: '?0'}")
    public List<Meter> findByName(String type);

    @Query(value = "{monthAndYear: '?0', utilities_type: '?1'}")
    public List<Meter> findByMonthAndYear(String month, String type);

}
