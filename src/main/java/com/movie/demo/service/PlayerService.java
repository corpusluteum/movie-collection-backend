package com.movie.demo.service;

import com.movie.demo.dao.MovieDAO;
import com.movie.demo.dao.PlayerDAO;
import com.movie.demo.entity.Movie;
import com.movie.demo.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("playerService")
public class PlayerService {

    @Autowired
    private PlayerDAO dao;

    public List<Player> list() {
        return dao.list();
    }

    public Player findById(Integer id) {
        return dao.findById(id);
    }

    public Boolean savePlayer(Player player) {
        Boolean result = dao.save(player);
        return result;
    }

    public Boolean updatePlayer(Player player) {
        Player entity = dao.findById(player.getId());
        if(entity != null){
            entity.setName(player.getName());
            entity.setSurname(player.getSurname());
            entity.setDescription(player.getDescription());
            dao.update(entity);
            return true;
        }else{
            return false;
        }
    }

    public Boolean deleteById(Integer id) {
        Player entity = dao.findById(id);
        if(entity != null){
            dao.delete(entity);
            return true;
        }else{
            return false;
        }
    }

}
