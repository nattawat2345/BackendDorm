package com.example.backenddorm.controller;



import com.example.backenddorm.pojo.Rent;
import com.example.backenddorm.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentController {
    @Autowired
    private RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @RequestMapping(value ="/rent", method = RequestMethod.GET)
    public List<Rent> getRent(){
        return rentService.getRent();
    }

    @RequestMapping(value ="/addRent", method = RequestMethod.POST)
    public boolean addRent(@RequestBody Rent rent){
        try {
            rentService.addRent(rent);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/updateRent", method = RequestMethod.POST)
    public boolean updateRent(@RequestBody Rent rent){
        try {
            rentService.updateRent(rent);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/deleteRent", method = RequestMethod.POST)
    public boolean deleteRent(@RequestBody Rent rent){
        try {
            rentService.deleteRent(rent);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/updateStatus/{room_number}/{status}", method = RequestMethod.PUT)
    public boolean updateStatus(@PathVariable("room_number") String room_number,
                                @PathVariable("status") String status){
        try {
            Rent rent = rentService.getRoomByNumber(room_number);
            if(rent != null) {
                rentService.updateStatus(new Rent(rent.get_id(), rent.getRoom_number(), rent.getFloor(), rent.getBuild(), rent.getRoom_price(), rent.getRoom_type(),  rent.getCommon_fee(), status));
                return true;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

