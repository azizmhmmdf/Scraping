package com.example.scrapper.models.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.example.scrapper.models.entity.Movie;

public interface MovieRepo extends ElasticsearchRepository<Movie, String> {
    
}
