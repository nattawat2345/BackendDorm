package com.example.backenddorm.service;



import com.example.backenddorm.pojo.Reserve;
import com.example.backenddorm.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Reserve> getRoomByNumber (String room_number) {
        try {
            return reserveRepository.findByRoomNumber(room_number);
        } catch (Exception e) {
            return null;
        }
    }

    public Reserve getRoomByNum (String room_number) {
        try {
            return reserveRepository.findByNum(room_number);
        } catch (Exception e) {
            return null;
        }
    }

    public Optional<Reserve> getRoomById (String id) {
        try {
            return reserveRepository.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean updateStatus(Reserve reserve){
        try {
            reserveRepository.save(reserve);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Reserve getRoomByStatus (String status) {
        try {
            return reserveRepository.findByStatusRoom(status);
        } catch (Exception e) {
            return null;
        }
    }
}

