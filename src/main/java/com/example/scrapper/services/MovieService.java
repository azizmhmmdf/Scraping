package com.example.scrapper.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.scrapper.models.entity.Movie;

@Service
public interface MovieService {
    Iterable<Movie> scrapperItem(String uri) throws IOException;
}
