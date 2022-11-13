package com.example.backenddorm.repository;

import com.example.backenddorm.pojo.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository  extends MongoRepository<Report,String> {
}
