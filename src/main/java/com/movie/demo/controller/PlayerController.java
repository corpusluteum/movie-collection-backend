package com.movie.demo.controller;

import com.movie.demo.entity.Player;
import com.movie.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping("/playerlist")
    public ResponseEntity<List<Player>> getList() {
        List<Player> list = this.service.list();
        return new ResponseEntity<List<Player>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/player/{id}")
    public ResponseEntity<Player> getMovieById(@PathVariable("id") Integer id) {
        Player player = this.service.findById(id);

        if(player == null){
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Player>(player, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/player")
    public ResponseEntity<Player> addMovie(@RequestBody Player player) {
        this.service.savePlayer(player);
        return new ResponseEntity<Player>(player, HttpStatus.CREATED);
    }

    @PutMapping(value = "/player/{id}")
    public ResponseEntity<Player> updateMovie(@PathVariable Long id, @RequestBody Player player) {
        this.service.updatePlayer(player);
        return new ResponseEntity<Player>(player, HttpStatus.OK);
    }

    @DeleteMapping(value = "/player/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Integer id) {
        this.service.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
