SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE paymybuddy;
USE paymybuddy;

CREATE TABLE user (
`id` INT NOT NULL AUTO_INCREMENT,
`firstName` VARCHAR(255) DEFAULT NULL,
`lastName` VARCHAR(255) DEFAULT NULL,
`password` VARCHAR(255) DEFAULT NULL,
`username` VARCHAR(255) DEFAULT NULL,
`email` VARCHAR(255) NOT NULL,
`balance` DOUBLE DEFAULT 0,
 PRIMARY KEY (`id`)
);

INSERT INTO user (`id`,`firstName`,`lastName`, `username`, `password`,`email`,`balance`) VALUES
(1,'Ben Fousseni Christ','Kone','foussenichrist',  '123456','foussenichrist@gmail.com', 100000),
(2,'Marie Esther','Boua', 'boua', '123456','boua@gmail.com', 100000),
(3,'Marie Ange','Toure', 'ange', '123456','ange@gmail.com', 100000),
(4,'Grace','Kouacy', 'kouacy', '123456','kouacy@gmail.com', 100000),
(5,'Detty Romaric','Gueu', 'gueu', '123456','gueu@gmail.com', 100000);

CREATE TABLE contact (
`id` INT NOT NULL AUTO_INCREMENT,
`user_id` INT NOT NULL,
`owner_id` INT NOT NULL,
`name` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT FK_ContactUserId FOREIGN KEY (`user_id`) REFERENCES user(`id`),
CONSTRAINT FK_ContactOwnerId FOREIGN KEY (`owner_id`) REFERENCES user(`id`)
);

INSERT INTO contact (`id`, `user_id`, `owner_id`, `name`) VALUES
(1, 2, 1, "Best friend"),
(2, 3, 1, "Looser"),
(3, 4, 1, "Guy");

CREATE TABLE transaction (
`id` INT NOT NULL AUTO_INCREMENT,
`user_id` INT NOT NULL,
`contact_id` INT,
`amount` DOUBLE NOT NULL,
`description` VARCHAR(255) DEFAULT NULL,
`status` VARCHAR(255) NOT NULL,
`date` DATE,
`type` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT FK_TransactionUserId FOREIGN KEY (`user_id`) REFERENCES user(`id`),
CONSTRAINT FK_TransactionContactId FOREIGN KEY (`contact_id`) REFERENCES contact(`id`)
);

INSERT INTO transaction (`id`, `user_id`, `contact_id`, `amount`, `description`, `status`, `type`) VALUES
(1, 1, 1, 1000, 'Janv Party', 'DONE', 'TRANSFER'),
(2, 1, 2, 1000, 'Dec Party', 'DONE', 'TRANSFER'),
(3, 1, 1, 1000, 'CIE', 'DONE', 'DEPOSIT'),
(4, 1, null, 1000, 'SODECI', 'DONE', 'DEPOSIT');

COMMIT;
