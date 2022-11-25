package com.example.backenddorm.repository;

import com.example.backenddorm.pojo.Meter;
import com.example.backenddorm.pojo.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository  extends MongoRepository<Report,String> {
    @Query(value = "{status: ?0}")
    public List<Report> findByStatus (boolean status);
}
