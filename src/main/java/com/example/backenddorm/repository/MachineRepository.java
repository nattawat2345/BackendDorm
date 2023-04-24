package com.example.backenddorm.repository;

import com.example.backenddorm.pojo.Machine;
import com.example.backenddorm.pojo.Parcel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends MongoRepository<Machine, String> {
    @Query(value = "{status:'?0'}")
    public List<Machine> findByStatus(String status);

    @Query(value = "{type:'?0'}")
    public List<Machine> findByType(String type);
}
