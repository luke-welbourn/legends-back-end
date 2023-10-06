DROP DATABASE IF EXISTS legends;

CREATE DATABASE legends;

USE legends;

CREATE TABLE legends (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    lane VARCHAR(100),
    role VARCHAR(100),
    release_date VARCHAR(100),
    PRIMARY KEY(id)
);