package com.example.backenddorm.controller;

import com.example.backenddorm.pojo.Parcel;
import com.example.backenddorm.pojo.Payment;
import com.example.backenddorm.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ParcelController {
    @Autowired
    private ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @RequestMapping(value ="/parcel", method = RequestMethod.GET)
    public List<Parcel> getParcel(){
        return parcelService.getParcel();
    }

    @RequestMapping(value ="/addParcel", method = RequestMethod.POST)
    public boolean addParcel(@RequestBody Parcel parcel){
        try {
            parcelService.addParcel(parcel);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/updateParcel", method = RequestMethod.POST)
    public boolean updateParcel(@RequestBody Parcel parcel){
        try {
            parcelService.updateParcel(parcel);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/deleteParcel", method = RequestMethod.POST)
    public boolean deleteParcel(@RequestBody Parcel parcel){
        try {
            parcelService.deleteParcel(parcel);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/getParcelNum/{room_number}", method = RequestMethod.GET)
    public Parcel getParcelNum(@PathVariable("room_number") String room_number){
        try {
            Parcel parcel = parcelService.getRoomByNumber(room_number);
            return parcel;
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value ="/getParcelById/{id}", method = RequestMethod.GET)
    public Optional<Parcel> getParcelById(@PathVariable("id") String id){
        try {
            Optional<Parcel> parcel = parcelService.getParcelById(id);
            return parcel;
        }catch (Exception e){
            return null;
        }
    }
}
