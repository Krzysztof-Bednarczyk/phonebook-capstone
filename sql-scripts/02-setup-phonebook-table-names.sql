USE `phonebook_directory`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `contact_detail`;

CREATE TABLE `contact_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `occupation` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  `group` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contact_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`contact_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`contact_detail_id`) 
  REFERENCES `contact_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `phone_number`;

CREATE TABLE `phone_number` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(45) DEFAULT NULL,
  `contact_id` int DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `NUMBER_UNIQUE` (`number`),
  
  KEY `FK_CONTACT_idx` (`contact_id`),
  
  CONSTRAINT `FK_CONTACT` 
  FOREIGN KEY (`contact_id`) 
  REFERENCES `contact` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;