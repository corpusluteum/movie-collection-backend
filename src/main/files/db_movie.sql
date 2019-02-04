--
-- Database: `movie`
--


CREATE TABLE movie(
 movie_id serial PRIMARY KEY,
 name VARCHAR (50) UNIQUE NOT NULL,
 description VARCHAR (900) NOT NULL,
 releasedDate TIMESTAMP
);

CREATE TABLE player(
 player_id serial PRIMARY KEY,
 name VARCHAR (50) NOT NULL,
 surname VARCHAR (50) NOT NULL,
 description VARCHAR (900) NOT NULL
);

CREATE TABLE type(
 key serial PRIMARY KEY,
 value VARCHAR (50) UNIQUE NOT NULL
);

CREATE TABLE language(
 key serial PRIMARY KEY,
 value VARCHAR (50) UNIQUE NOT NULL
);


CREATE TABLE movie_player(
  movie_id integer NOT NULL,
  player_id integer NOT NULL,
  date timestamp without time zone,
  PRIMARY KEY (movie_id, player_id),
  CONSTRAINT movie_player_player_id_fkey FOREIGN KEY (player_id)
      REFERENCES player (player_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT movie_player_movie_id_fkey FOREIGN KEY (movie_id)
      REFERENCES movie (movie_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE movie_type(
  movie_id integer NOT NULL,
  key integer NOT NULL,
  date timestamp without time zone,
  PRIMARY KEY (movie_id, key),
  CONSTRAINT movie_type_type_fkey FOREIGN KEY (key)
      REFERENCES type (key) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT movie_type_movie_id_fkey FOREIGN KEY (movie_id)
      REFERENCES movie (movie_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE movie_language(
  movie_id integer NOT NULL,
  key integer NOT NULL,
  date timestamp without time zone,
 PRIMARY KEY (movie_id, key),
  CONSTRAINT movie_type_language_fkey FOREIGN KEY (key)
      REFERENCES language (key) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT movie_player_movie_id_fkey FOREIGN KEY (movie_id)
      REFERENCES movie (movie_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


insert into language (key, value) values (1, 'Türkçe');
insert into language (key, value) values (2, 'İngilizce');
insert into type (key, value) values (1, 'Korku');
insert into type (key, value) values (2, 'Gerilim');
insert into type (key, value) values (3, 'Macera');
insert into player (player_id, description, name, surname) values (1, 'Açıklama' ,'Oyuncu ', 'Soyadı');
insert into movie (movie_id, releaseddate, description, name) values (1, current_date , 'Açıklaması', 'Film Adı');
insert into movie_player (movie_id, player_id) values (1,1);
insert into movie_type (movie_id, key) values (1,1);
insert into movie_type (movie_id, key) values (1,2);
insert into movie_language (movie_id, key) values (1,1);