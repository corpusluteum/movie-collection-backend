package com.movie.demo.service;

import com.movie.demo.dao.MovieDAO;
import com.movie.demo.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("movieService")
public class MovieService {

    @Autowired
    private MovieDAO dao;

    public List<Movie> list() {
        return dao.list();
    }

    public Movie findById(Integer id) {
        return dao.findById(id);
    }

    public Boolean saveMovie(Movie movie) {
        Boolean result = dao.save(movie);
        return result;
    }

    public Boolean updateMovie(Movie movie) {
        Movie entity = dao.findById(movie.getId());
        if(entity != null){
            entity.setName(movie.getName());
            entity.setDescription(movie.getDescription());
            entity.setPlayerList(movie.getPlayerList());
            entity.setDate(movie.getDate());
            entity.setLanguages(movie.getLanguages());
            entity.setTypeList(movie.getTypeList());
            dao.update(entity);
            return true;
        }else{
            return false;
        }
    }

    public Boolean deleteById(Integer id) {
        Movie entity = dao.findById(id);
        if(entity != null){
            dao.delete(entity);
            return true;
        }else{
            return false;
        }
    }
}
