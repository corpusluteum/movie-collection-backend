package com.movie.demo.dao;

import com.movie.demo.entity.Movie;
import org.springframework.stereotype.Repository;

@Repository("movieDAO")
public class MovieDAO extends AbstractDAO<Integer, Movie> {

    public Movie findById(Integer id) {
        Movie movie = getByKey(id);
        return movie;
    }

    public Boolean save(Movie movie) {
        Boolean result = persist(movie);
        return result;
    }
}