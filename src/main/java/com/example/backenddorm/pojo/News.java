package com.example.backenddorm.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document("News")
public class News implements Serializable {
    @Id
    private String _id;
    private String title;
    private String text;
    private String created_date;
    private int created_byId;
    private List<String> url;

    public News() {
    }

    public News(String _id, String title, String text, String created_date, int created_byId, List<String> url) {
        this._id = _id;
        this.title = title;
        this.text = text;
        this.created_date = created_date;
        this.created_byId = created_byId;
        this.url = url;
    }
}
