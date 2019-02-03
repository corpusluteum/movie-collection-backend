package com.movie.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="movie_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name="name", nullable=false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="releasedDate")
    private Date date;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_player", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = { @JoinColumn(name = "player_id") })
    @Fetch (FetchMode.SELECT)
    private List<Player> playerList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_type", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = { @JoinColumn(name = "key") })
    @Fetch (FetchMode.SELECT)
    private List<Type> typeList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_language", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = { @JoinColumn(name = "key") })
    @Fetch (FetchMode.SELECT)
    private List<Language> languages;


    public Movie() {}

    public Movie(Integer id, String name, String description, Date date, List<Player> playerList, List<Language> languages, List<Type> typeList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.playerList = playerList;
     /*   this.typeList = typeList;
        this.languages = languages;*/
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}
