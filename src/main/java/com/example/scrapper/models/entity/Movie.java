package com.example.scrapper.models.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "movies")
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

  public Movie(){

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }
}
