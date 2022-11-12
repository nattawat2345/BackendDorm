package com.example.backenddorm.controller;




import com.example.backenddorm.pojo.Reserve;
import com.example.backenddorm.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReserveController {
    @Autowired
    private ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @RequestMapping(value ="/reserves", method = RequestMethod.GET)
    public List<Reserve> getInvoices(){
        return reserveService.getReserve();
    }

    @RequestMapping(value ="/addReserve", method = RequestMethod.POST)
    public boolean addReserve(@RequestBody Reserve reserve){
        try {
            reserveService.addReserve(reserve);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/updateReserve", method = RequestMethod.POST)
    public boolean updateReserve(@RequestBody Reserve reserve){
        try {
            reserveService.updateReserve(reserve);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/deleteReserve", method = RequestMethod.POST)
    public boolean deleteReserve(@RequestBody Reserve reserve){
        try {
            reserveService.deleteReserve(reserve);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/getReserveNum/{room_number}", method = RequestMethod.GET)
    public ResponseEntity<?> getReserveNum(@PathVariable("room_number") String room_number){
        try {
            Reserve reserve = reserveService.getRoomByNumber(room_number);
            return ResponseEntity.ok(reserve);
        }catch (Exception e){
            return null;
        }
    }
}

