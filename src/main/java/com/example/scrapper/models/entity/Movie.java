package com.example.scrapper.models.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(indexName = "items")
public class Movie {
    @Id
    private String id;
    private String title;
    private String rating;

    public Movie(String id, String title, String rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }
    
}
