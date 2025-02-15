CREATE DATABASE IF NOT EXISTS spring_form;

USE spring_form;

CREATE TABLE IF NOT EXISTS formtest
(id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
kilometers INTEGER,
price DOUBLE,
creation DATETIME,
email VARCHAR(255),
phonenumber VARCHAR(255),
good BOOLEAN,
season VARCHAR(255),
color VARCHAR(255),
image VARCHAR(255),
pdf VARCHAR(255),
PRIMARY KEY (id));