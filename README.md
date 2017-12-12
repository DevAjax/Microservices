# Microservice App
Web application comprising of several components communicating to each other

## Components
  1. loginapi is AngularJS application, provides basic UI
  2. authapi is written in Node.js, provides authorization, uses mongoose framework with MongoDB.
  3. userapi is Spring Boot project written in Java, provides users data, uses MongoDB as database.
  
  
![appflow](https://i.imgur.com/FVftf2C.jpg)

## Settings
Before running components make sure your MongoDB is running at 27017 port. Tomcat will launch on 8080 port, Node.js server on 3001.
