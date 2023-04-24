package com.example.backenddorm.controller;

import com.example.backenddorm.pojo.Machine;
import com.example.backenddorm.pojo.Parcel;
import com.example.backenddorm.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MachineController {

    @Autowired
    private MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @RequestMapping(value ="/machines", method = RequestMethod.GET)
    public List<Machine> getMachine(){
        return machineService.getMachine();
    }

    @RequestMapping(value ="/getMachineByStatus/{status}", method = RequestMethod.GET)
    public List<Machine> getMachineByStatus(@PathVariable("status") String status){
        try {
            List<Machine> machine = machineService.getMachineByStatus(status);
            return machine;
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value ="/getMachineByType/{type}", method = RequestMethod.GET)
    public List<Machine> getMachineByType(@PathVariable("type") String type){
        try {
            List<Machine> machine = machineService.getMachineByType(type);
            return machine;
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value ="/updateMachine", method = RequestMethod.POST)
    public boolean updateMachine(@RequestBody Machine machine){
        try {
            machineService.updateMachine(machine);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
