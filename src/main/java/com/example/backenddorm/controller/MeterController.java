package com.example.backenddorm.controller;

import com.example.backenddorm.pojo.Meter;
import com.example.backenddorm.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeterController {
    @Autowired
    private MeterService meterService;

    public MeterController(MeterService meterService) {
        this.meterService = meterService;
    }
    @GetMapping("/getall")
    public List<Meter> getAllMeter() {
        List<Meter> meters = meterService.getAllMeter();
        return meters;
    }

    @GetMapping("/getbytype/{type}")
    public List<Meter> getByType(@PathVariable String type) {
        List<Meter> meters = meterService.getByType(type);
        return meters;
    }

    @GetMapping("/getbymonthandyear/{monthandyear}/{type}")
    public List<Meter> getByMonth(@PathVariable String monthandyear, @PathVariable String type) {
        List<Meter> meters = meterService.getByMonthAndYear(monthandyear,type);
        return meters;
    }
    @PostMapping("/add")
    public String addMeter(@RequestBody Meter meter) {
        return meterService.addMeter(meter);

    }

    @RequestMapping(value ="/getMeterInvoice/{room_number}/{type}/{monthYear}", method = RequestMethod.GET)
    public ResponseEntity<?> getMeterofInvoice(@PathVariable("room_number") String room_number, @PathVariable("type") String type, @PathVariable("monthYear") String monthYear){
        try {
            Meter meter = meterService.getMeterOfInvoice(room_number, type, monthYear);
            System.out.println(room_number+""+type+""+monthYear);
            return ResponseEntity.ok(meter);
        }catch (Exception e){
            return null;
        }
    }
}
