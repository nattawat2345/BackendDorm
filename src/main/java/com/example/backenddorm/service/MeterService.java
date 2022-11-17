package com.example.backenddorm.service;

import com.example.backenddorm.pojo.Invoices;
import com.example.backenddorm.pojo.Meter;
import com.example.backenddorm.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterService {
    @Autowired
    private MeterRepository meterRepository;

    public MeterService(MeterRepository meterRepository) {
        this.meterRepository = meterRepository;
    }
    public List<Meter> getAllMeter(){
        return meterRepository.findAll();
    }

    public String addMeter(Meter meter){
        try{
            meterRepository.insert(meter);
            return "Add meter successfully";
        }catch (Exception e){
            return "Can't add meter";
        }
    }
    public List<Meter> getByType(String type){
        return meterRepository.findByName(type);
    }

    public Meter getMeterOfInvoice (String room_number, String type, String monthYear){
        try {
            return meterRepository.findMeterInvoice(room_number, type, monthYear);
        }catch (Exception e){
            return null;
        }
    }
}
