package com.example.scrapper.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scrapper.models.entity.Movie;
import com.example.scrapper.services.MovieServiceImpl;

@RestController
@RequestMapping("/api/srapper")
public class MovieController {
    @Autowired
    private MovieServiceImpl itemService;

    @GetMapping
    public Iterable<Movie> scrapper() throws IOException{
        final String uri = "https://www.imdb.com/chart/top/";
        return itemService.scrapperItem(uri);
    }
}
