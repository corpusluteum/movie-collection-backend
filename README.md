# Movie Collection RESTful Api with Spring

Movie Collection is a RESTful application that uses React for client and Spring Boot as backend service. 

Client is here : https://github.com/corpusluteum/moviecollectionui

**PoastgreSQL create script with initial data:** [db_movie.sql](files/db_movie.sql)

 File for database connection configuration: application.properties

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


## Client Application

This project template was built with [Create React App](https://github.com/facebookincubator/create-react-app). 

**Techs:** React, react-bootstrap, axios for http requests, and several react components.

**Installing dependencies**

run `npm install` in the client application root directory.

**Scripts**

`npm start` : Runs the app in development mode.

`npm run build` : Builds the app for production to the build folder.

**App URL:** http://localhost:3000
