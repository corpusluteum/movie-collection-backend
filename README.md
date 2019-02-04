# Movie Collection Backend with Spring MVC
---

Movie Collection is a web application that uses React for client and Spring MVC as backend service. 
Client is here : https://github.com/corpusluteum/moviecollectionui

**MySQL create script with initial data:** [db_movie.sql](files/db_movie.sql)

**TODO:**

* Add client side input validation, toast notification and loader effect
* Add RESTful fail checks both for client and server side
* May add service interfaces
* Add client tests


## Server Application

**Techs:** Spring Boot as RESTful backend, Maven, Hibernate, PostgreSQL
	
**RESTful API Address:** http://localhost:8080

**Simple endpoints - Movie**
 * HTTP GET 	: "localhost:8080/movielist/" getting all movies.
 * HTTP GET 	: "localhost:8080/movie/{id}" get an movie by id.
 * HTTP POST	: "localhost:8080/movie/" create a new movie.
 * HTTP PUT 	: "localhost:8080/movie/{id}" update an existing movie.
 * HTTP DELETE : "localhost:8080/movie/{id}" delete an movie by id.


**Maven Run Configurations**

`clean spring-boot:run`: clean and run Spring Boot application

`clean test`: clean and run tests
