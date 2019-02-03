package com.movie.demo.controller;

import com.movie.demo.entity.Movie;
import com.movie.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/movielist")
    public ResponseEntity<List<Movie>> getMovieList() {
        List<Movie> movieList = this.service.list();
        if(movieList == null){
            movieList = new ArrayList<>();
        }
        return new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
    }

    @GetMapping(value = "/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Integer id) {
        Movie movie = this.service.findById(id);

        if(movie == null){
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        this.service.saveMovie(movie);
        return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
    }

    @PutMapping(value = "/movie/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        this.service.updateMovie(movie);
        return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }

    @DeleteMapping(value = "/movie/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Integer id) {
        this.service.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
