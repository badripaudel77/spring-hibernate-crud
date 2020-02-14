# spring-hibernate-crud
SPRING + HIBERNATE + MYSQL CRUD APPLICATION


This project contains all the required starter files ( jar files for spring, hibernate, and xml files ) for basic crud type app. Im not using maven for dependency management so all jar jar files have been downloaded manually.

SPRING AND HIBERNATE CRUD APP
USES THE MANUALLY DOWNLOADED JAR FILES
MYSQL AS DATABASE
DOES ADD, DELETE , UPDATE AND FETCH THE RECORD FROM THE TABLE DEFINED IN DB 5)TO RUN THIS PROJECT CLONE IT AND RUN THE SQL FILE ATTACHED IN HERE
sql file query is : to create database first run : create database spring_hib_crud;

then to create table run the following :

CREATE TABLE customer ( id int(11) NOT NULL, first_name varchar(45) NOT NULL, last_name varchar(45) NOT NULL, email varchar(45) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO customer (id, first_name, last_name, email) VALUES (13, 'Badri', 'Paudel', 'badripaudel77@gmail.com'), (15, 'Alisha ', 'Paudel', 'alisha45@gmail.com'), (18, 'Gita', 'Bhattarai', 'gita12.ncit@edu.np'), (19, 'Ganesh', 'Stha', 'ganesh56@gmail.com'), (32, 'Woo', 'Jian', 'Woo@gmail.com'), (35, 'Hari', 'Vai', 'hari12@gmail.com');

ALTER TABLE customer ADD PRIMARY KEY (id);
