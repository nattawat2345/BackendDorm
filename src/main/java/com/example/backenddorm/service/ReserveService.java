package com.example.backenddorm.service;



import com.example.backenddorm.pojo.Reserve;
import com.example.backenddorm.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository reserveRepository;

    public ReserveService(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    public List<Reserve> getReserve(){
        return reserveRepository.findAll();
    }

    public boolean addReserve(Reserve reserve){
        try {
            reserveRepository.insert(reserve);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean updateReserve(Reserve reserve){
        try {
            reserveRepository.save(reserve);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteReserve(Reserve reserve){
        try {
            reserveRepository.delete(reserve);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Reserve getRoomByNumber (String room_number) {
        try {
            return reserveRepository.findByRoomNumber(room_number);
        } catch (Exception e) {
            return null;
        }
    }
}

