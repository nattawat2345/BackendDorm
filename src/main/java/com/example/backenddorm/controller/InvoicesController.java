package com.example.backenddorm.controller;



import com.example.backenddorm.pojo.Contract;
import com.example.backenddorm.pojo.Invoices;
import com.example.backenddorm.service.InvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
public class InvoicesController {
    @Autowired
    private InvoicesService invoicesService;

    public InvoicesController(InvoicesService invoicesService) {
        this.invoicesService = invoicesService;
    }

    @RequestMapping(value ="/invoices", method = RequestMethod.GET)
    public List<Invoices> getInvoices(){
        return invoicesService.getInvoices();
    }

    @RequestMapping(value ="/addInvoice", method = RequestMethod.POST)
    public boolean addInvoice(@RequestBody Invoices invoice){
        try {
            invoicesService.addInvoice(invoice);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/updateInvoice", method = RequestMethod.PUT)
    public boolean updateInvoice(@RequestBody Invoices invoice){
        try {
            invoicesService.updateInvoice(invoice);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/deleteInvoice", method = RequestMethod.POST)
    public boolean deleteInvoice(@RequestBody Invoices invoice){
        try {
            invoicesService.deleteInvoice(invoice);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value ="/getInvoiceNum/{room_number}", method = RequestMethod.GET)
    public ResponseEntity<?> getInvoiceNum(@PathVariable("room_number") String room_number){
        try {
            Invoices invoices = invoicesService.getRoomByNumber(room_number);
            return ResponseEntity.ok(invoices);
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value ="/getInvoice/{room_number}/{month}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?> getInvoice(@PathVariable("room_number") String room_number, @PathVariable("month") String month, @PathVariable("year") int year){
        try {
            Invoices invoices = invoicesService.getInvoiceByNum(room_number, month, year);
            System.out.println(room_number+""+month+""+year);
            return ResponseEntity.ok(invoices);
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value ="/getRoomInvoice/{month}/{year}", method = RequestMethod.GET)
    public ResponseEntity<?> getRoomInvoice(@PathVariable("month") String month, @PathVariable("year") int year){
        try {
            List<Invoices> invoices = invoicesService.getRoomInvoice(month, year);
            return ResponseEntity.ok(invoices);
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value ="/updateStatusInvoice/{id}/{status}", method = RequestMethod.PUT)
    public boolean updateStatus(@PathVariable("id") String id, @PathVariable("status") String status){
        try {
            Optional<Invoices> invoices = invoicesService.getInvoiceById(id);
            if(invoices != null) {
                invoicesService.updateInvoice(new Invoices(invoices.get().get_id(), invoices.get().getMonth(), invoices.get().getYear(), invoices.get().getRoom_number(), invoices.get().getInvoice_date(), invoices.get().getCommon_fee(), invoices.get().getDorm_fee(), invoices.get().getElectricity_fee(), invoices.get().getWater_fee(), invoices.get().getExpenses(), invoices.get().getFine(), invoices.get().getAmount(), invoices.get().getTax(), invoices.get().getTotal(), invoices.get().getNote(), status));
                return true;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

