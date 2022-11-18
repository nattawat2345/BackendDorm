package com.example.backenddorm.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Payments")
public class Payment implements Serializable {
    @Id
    private String _id;
    private double amount;
    private String payment_date;
    private String payment_time;
    private String payment_note;
    private String idInvoice;
    private String url;

    public Payment(String _id, double amount, String payment_date, String payment_time, String payment_note, String idInvoice, String url) {
        this._id = _id;
        this.amount = amount;
        this.payment_date = payment_date;
        this.payment_time = payment_time;
        this.payment_note = payment_note;
        this.idInvoice = idInvoice;
        this.url = url;
    }
}
