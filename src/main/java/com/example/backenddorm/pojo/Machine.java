package com.example.backenddorm.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("WashingMachine")
public class Machine implements Serializable {

    @Id
    private String _id;
    private String name;
    private String status;
    private String time;
    private String build;
    private String type;

    public Machine(String _id, String name, String status, String time, String build, String type) {
        this._id = _id;
        this.name = name;
        this.status = status;
        this.time = time;
        this.build = build;
        this.type = type;
    }
}
