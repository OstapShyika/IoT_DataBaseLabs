CREATE SCHEMA IF NOT EXISTS `iot_labs_db` ;
USE `iot_labs_db` ;

DROP TABLE IF EXISTS `iot_labs_db`.`owner_place` ;
DROP TABLE IF EXISTS `iot_labs_db`.`place_trip` ;
DROP TABLE IF EXISTS `iot_labs_db`.`owner` ;
DROP TABLE IF EXISTS `iot_labs_db`.`country_trip` ;
DROP TABLE IF EXISTS `iot_labs_db`.`transport` ;
DROP TABLE IF EXISTS `iot_labs_db`.`review` ;
DROP TABLE IF EXISTS `iot_labs_db`.`trip` ;
DROP TABLE IF EXISTS `iot_labs_db`.`user` ;
DROP TABLE IF EXISTS `iot_labs_db`.`place` ;
DROP TABLE IF EXISTS `iot_labs_db`.`country` ;

CREATE TABLE IF NOT EXISTS `iot_labs_db`.`user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `iot_labs_db`.`trip` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `user_id` INT NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `iot_labs_db`.`country` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(56) NOT NULL,
    `description` VARCHAR(500) NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `iot_labs_db`.`place` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `country_id` INT NOT NULL,
    `pricing` INT NOT NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `iot_labs_db`.`transport` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(45) NOT NULL,
    `route` VARCHAR(120) NOT NULL,
    `place_id` INT NOT NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `iot_labs_db`.`review` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `rating` INT NOT NULL,
    `description` VARCHAR(500) NULL,
    `user_id` INT NOT NULL,
    `place_id` INT NOT NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `iot_labs_db`.`country_trip` (
    `country_id` INT NOT NULL,
    `trip_id` INT NOT NULL,
    PRIMARY KEY (`country_id`, `trip_id`)
    );

CREATE TABLE IF NOT EXISTS `iot_labs_db`.`owner` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `surname` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `iot_labs_db`.`owner_place` (
    `owner_id` INT NOT NULL,
    `place_id` INT NOT NULL,
    PRIMARY KEY (`owner_id`, `place_id`)
    );

CREATE TABLE IF NOT EXISTS `iot_labs_db`.`place_trip` (
    `place_id` INT NOT NULL,
    `trip_id` INT NOT NULL,
    `id` INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
    );

ALTER TABLE `iot_labs_db`.`trip`
    ADD CONSTRAINT `fk_trip_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `iot_labs_db`.`user` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE `iot_labs_db`.`place`
    ADD CONSTRAINT `fk_place_country1`
        FOREIGN KEY (`country_id`)
            REFERENCES `iot_labs_db`.`country` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE `iot_labs_db`.`transport`
    ADD CONSTRAINT `fk_transport_place1`
        FOREIGN KEY (`place_id`)
            REFERENCES `iot_labs_db`.`place` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE `iot_labs_db`.`review`
    ADD CONSTRAINT `fk_review_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `iot_labs_db`.`user` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT `fk_review_place1`
        FOREIGN KEY (`place_id`)
            REFERENCES `iot_labs_db`.`place` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE `iot_labs_db`.`country_trip`
    ADD CONSTRAINT `fk_country_trip_country`
        FOREIGN KEY (`country_id`)
            REFERENCES `iot_labs_db`.`country` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT `fk_country_trip_trip1`
        FOREIGN KEY (`trip_id`)
            REFERENCES `iot_labs_db`.`trip` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE `iot_labs_db`.`owner_place`
    ADD CONSTRAINT `fk_owner_place_owner1`
        FOREIGN KEY (`owner_id`)
            REFERENCES `iot_labs_db`.`owner` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT `fk_owner_place_place1`
        FOREIGN KEY (`place_id`)
            REFERENCES `iot_labs_db`.`place` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE `iot_labs_db`.`place_trip`
    ADD CONSTRAINT `fk_place_trip_place1`
        FOREIGN KEY (`place_id`)
            REFERENCES `iot_labs_db`.`place` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT `fk_place_trip_trip1`
        FOREIGN KEY (`trip_id`)
            REFERENCES `iot_labs_db`.`trip` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;


ALTER TABLE `iot_labs_db`.`owner`
    ADD INDEX owner_name_surname_idx (name, surname);

ALTER TABLE `iot_labs_db`.`place`
    ADD INDEX place_name_country_id_idx (name, country_id);

-- -----------------------------------------------------
-- Inserts
-- -----------------------------------------------------

INSERT INTO `iot_labs_db`.`user` (username, email)
VALUES ('Ostab', 'sajhb@gmail.com'),
       ('Anna', 'vdfj@gmail.com'),
       ('Vasya', 'xfvkjbd@gmail.com'),
       ('Putia', 'ikjwfdgyii@gmail.com'),
       ('Achko', 'sojdcbikf@gmail.com'),
       ('Vosil', 'sjdcjxsdcs@gmail.com'),
       ('Nigos', 'oyjohyy@gmail.com'),
       ('Igar', 'kgjbibtg@gmail.com'),
       ('Billy', 'vffber@gmail.com'),
       ('Yasha', 'rlkvfneo@gmail.com');

INSERT INTO `iot_labs_db`.`country` (name, description) VALUES
('Ukraina', 'jdfs'),
('Niderlandy', 'dfisijb'),
('Rassieya', 'dfisijb'),
('USA', 'dfisijb'),
('OAE', 'dfisijb'),
('Ni', 'dfisijb'),
('Ger', 'dfisijb'),
('Many', 'dfisijb'),
('Niger', 'dfisijb'),
('Nigeriya', 'dfisijb');

INSERT INTO `iot_labs_db`.`trip` (name, user_id) VALUES
('Chornobyl', 2),
('MaZZkVa', 4),
('VOlgOdOnZZZk', 1),
('sOsal', 4),
('VlaZZZimirr', 8),
('XXX', 8),
('Niga', 8),
('Balakliya', 6),
('KyiV', 9),
('Nimechchynna', 8);

INSERT INTO `iot_labs_db`.`country_trip` (country_id, trip_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(1, 2),
(2, 1),
(8, 6),
(4, 4),
(8, 8),
(6, 9),
(3, 8);

INSERT INTO `iot_labs_db`.`place` (name, country_id, pricing) VALUES
('Lviv', 2, 73),
('S1', 3, 33),
('S2', 2, 44),
('DanietZZZZk', 8, 10),
('ZZZdan', 8, 4),
('Jest', 6, 2),
('Dobroi', 5, 6),
('VOli', 4, 7),
('Bil', 9, 5),
('Yash', 3, 5);

INSERT INTO `iot_labs_db`.`place_trip` (place_id, trip_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(1, 2),
(2, 1),
(8, 6),
(4, 4),
(8, 8),
(6, 9),
(3, 8);

INSERT INTO `iot_labs_db`.`owner` (name, surname) VALUES
('Onno', 'RyXNh'),
('AZZtebb', 'ttt'),
('Nigga', 'Naiomnik'),
('Polskiy', 'Naiomnik'),
('Batalyon', 'Rusich'),
('Sosal', 'Hui'),
('Onnpo', 'Jhbjde'),
('Blyadimir', 'Budkin'),
('Vlodimer', 'Puding'),
('Valodia', 'PiZZZdabol');

INSERT INTO `iot_labs_db`.`owner_place` (place_id, owner_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(1, 2),
(2, 1),
(8, 6),
(4, 4),
(8, 8),
(6, 9),
(3, 8);

INSERT INTO `iot_labs_db`.`transport` (type, route, place_id) VALUES
('Car', 'MaZZkVa', 8),
('Tank', 'MaZZkVa', 8),
('Tank', 'MaZZkVa', 8),
('Tank', 'MaZZkVa', 8),
('Tank', 'MaZZkVa', 8),
('Tank', 'MaZZkVa', 8),
('Tank', 'MaZZkVa', 8),
('Tank', 'MaZZkVa', 8),
('Tank', 'MaZZkVa', 8),
('Tank', 'MaZZkVa', 8);

INSERT INTO `iot_labs_db`.`review` (rating, description, user_id, place_id) VALUES
(1488, 'blanosavnhjherh', 6, 8),
(69, 'blachjherh', 6, 8),
(404, 'blagrdshjherh', 5, 4),
(14, 'blachjherh', 6, 8),
(88, 'blachadderh', 7, 5),
(0, 'blachjherh', 6, 8),
(34, 'blachjherh', 6, 8),
(13, 'blachjherh', 2, 7),
(8, 'blachjherh', 4, 8),
(6, 'blachjherh', 1, 1);
