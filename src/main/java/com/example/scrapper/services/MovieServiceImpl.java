package com.example.scrapper.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scrapper.models.entity.Movie;
import com.example.scrapper.models.repository.MovieRepo;
import com.opencsv.CSVWriter;

@Service
public class MovieServiceImpl implements MovieService {
  @Autowired
  private MovieRepo movieRepo;

  @Override
  public Iterable<Movie> scrapperMovie(String uri) throws Exception {
      try {
        org.jsoup.nodes.Document document = Jsoup.connect(uri).get();
        List<Movie> movies = new ArrayList<>();

        for (org.jsoup.nodes.Element row : document.select("li.ipc-metadata-list-summary-item")) {
          UUID uuid = UUID.randomUUID();
          final String id = uuid.toString();
          final String title = row.select("h3.ipc-title__text").text();
          final String titleWithoutNumber = title.replaceFirst("^\\d+\\.\\s*", "");
          final String rating = row.select("span.ratingGroup--imdb-rating").text();

          movies.add(new Movie(id, titleWithoutNumber, rating));
        }

        if (!movies.isEmpty()) {
//          movieRepo.saveAll(movies);
          saveMoviesToCsv(movies, "movies.csv");
          return movies;
        }else {
          return Collections.emptyList();
        }
      } catch (IOException e) {
        e.printStackTrace();
        throw new IOException("Failed to scrape data from the provided URI");
      }finally {
        throw new Exception();
      }
    }

  public void saveMoviesToCsv(List<Movie> movies, String filename) throws Exception{
    try(CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
      String[] header = { "ID", "TITLE", "RATING" };
      writer.writeNext(header);

      for(Movie movie : movies){
        String[] data = { movie.getId(), movie.getTitle(), movie.getRating()};
        writer.writeNext(data);
      }

      writer.close();
    }catch(Exception e){
      e.getMessage();
    }
  }
}

