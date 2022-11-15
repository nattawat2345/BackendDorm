package com.example.backenddorm.service;

import com.example.backenddorm.pojo.Rent;
import com.example.backenddorm.pojo.Vehicle;
import com.example.backenddorm.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicle(){
        return vehicleRepository.findAll();
    }
    public boolean addVehicle(Vehicle vehicle){
        try {
            vehicleRepository.insert(vehicle);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean updateVehicle(Vehicle vehicle){
        try {
            vehicleRepository.save(vehicle);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteVehicle(Vehicle vehicle){
        try {
            vehicleRepository.delete(vehicle);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Vehicle> getRoomByNumber(String room_number){
        try {
            return vehicleRepository.findByRoomNumber(room_number);
        }catch (Exception e){
            return null;
        }
    }

    public boolean deleteAllVehicle(String id){
        try {
            vehicleRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
