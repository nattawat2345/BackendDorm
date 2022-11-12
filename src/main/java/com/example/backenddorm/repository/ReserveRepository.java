package com.example.backenddorm.repository;



import com.example.backenddorm.pojo.Reserve;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository  extends MongoRepository<Reserve, String> {
    @Query(value = "{room_number:'?0'}")
    public Reserve findByRoomNumber(String room_number);
}
