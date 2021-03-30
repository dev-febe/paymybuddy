SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE paymybuddy;
USE paymybuddy;

CREATE TABLE user (
`id` INT NOT NULL,
`firstName` VARCHAR(255) DEFAULT NULL,
`lastName` VARCHAR(255) DEFAULT NULL,
`password` VARCHAR(255) DEFAULT NULL,
`email` VARCHAR(255) NOT NULL,
`balance` DOUBLE DEFAULT 0,
 PRIMARY KEY (`id`)
);

INSERT INTO user (`id`,`firstName`,`lastName`,`password`,`email`,`balance`) VALUES
(1,'Ben Fousseni Christ','Kone','123456','foussenichrist@gmail.com', 100000),
(2,'Marie Esther','Boua','123456','boua@gmail.com', 100000),
(3,'Marie Ange','Toure','123456','ange@gmail.com', 100000),
(4,'Grace','Kouacy','123456','kouacy@gmail.com', 100000),
(5,'Detty Romaric','Gueu','123456','gueu@gmail.com', 100000);

CREATE TABLE contact (
`id` INT NOT NULL,
`user_id` INT NOT NULL,
`owner_id` INT NOT NULL,
`name` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT FK_ContactUserId FOREIGN KEY (`user_id`) REFERENCES user(`id`),
CONSTRAINT FK_ContactOwnerId FOREIGN KEY (`owner_id`) REFERENCES user(`id`)
);

CREATE TABLE transaction (
`id` INT NOT NULL,
`user_id` INT NOT NULL,
`amount` DOUBLE NOT NULL,
`description` VARCHAR(255) DEFAULT NULL,
`status` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT FK_TransactionUserId FOREIGN KEY (`user_id`) REFERENCES user(`id`)
);

CREATE TABLE deposit (
`id` INT NOT NULL,
`transaction_id` INT NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT FK_DepositTransactionId FOREIGN KEY (`transaction_id`) REFERENCES transaction(`id`)
);

CREATE TABLE transfer (
`id` INT NOT NULL,
`transaction_id` INT NOT NULL,
`contact_id` INT NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT FK_TransferTransactionId FOREIGN KEY (`transaction_id`) REFERENCES transaction(`id`),
CONSTRAINT FK_TransferContactId FOREIGN KEY (`contact_id`) REFERENCES contact(`id`)
);
COMMIT;
