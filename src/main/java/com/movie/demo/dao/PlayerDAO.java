package com.movie.demo.dao;

import com.movie.demo.entity.Player;
import org.springframework.stereotype.Repository;

@Repository("playerDAO")
public class PlayerDAO extends AbstractDAO<Integer, Player> {

    public Player findById(Integer id) {
        Player player = getByKey(id);
        return player;
    }

    public Boolean save(Player player) {
        Boolean result = persist(player);
        return result;
    }
}
