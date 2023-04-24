package com.example.backenddorm.service;

import com.example.backenddorm.pojo.Machine;
import com.example.backenddorm.pojo.Parcel;
import com.example.backenddorm.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public List<Machine> getMachine(){
        return machineRepository.findAll();
    }

    public List<Machine> getMachineByStatus(String status){
        try {
            List<Machine> machine = machineRepository.findByStatus(status);
            return machine;
        }catch (Exception e){
            return null;
        }
    }

    public List<Machine> getMachineByType(String type){
        try {
            List<Machine> machine = machineRepository.findByType(type);
            return machine;
        }catch (Exception e){
            return null;
        }
    }

    public boolean updateMachine(Machine machine){
        try {
            machineRepository.save(machine);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
