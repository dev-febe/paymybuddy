--DROP TABLE users IF EXISTS;

CREATE TABLE IF NOT EXISTS `user`
(
    `id`        INTEGER PRIMARY KEY AUTO_INCREMENT,
    `firstName`  VARCHAR(255) DEFAULT NULL,
    `lastName`  VARCHAR(255) DEFAULT NULL,
    `password`  VARCHAR(255) DEFAULT NULL,
    `username`  VARCHAR(255) DEFAULT NULL,
    `email`     VARCHAR(255) NOT NULL,
    `balance`   DOUBLE       DEFAULT 0
);

INSERT INTO `user` (`id`,`firstName`,`lastName`, `username`, `password`,`email`,`balance`) VALUES
(1,'Ben Fousseni Christ','Kone','user',  '123456','foussenichrist@gmail.com', 100000),
(2,'Marie Esther','Boua', 'boua', '123456','boua@gmail.com', 100000),
(3,'Marie Ange','Toure', 'ange', '123456','ange@gmail.com', 100000),
(4,'Grace','Kouacy', 'kouacy', '123456','kouacy@gmail.com', 100000),
(5,'Detty Romaric','Gueu', 'gueu', '123456','gueu@gmail.com', 100000);

CREATE TABLE IF NOT EXISTS `contact`
(
    `id`       INTEGER PRIMARY KEY AUTO_INCREMENT,
    `user_id`  INTEGER      NOT NULL,
    `owner_id` INTEGER      NOT NULL,
    `name`     VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `transaction`
(
    `id`          INTEGER PRIMARY KEY AUTO_INCREMENT,
    `user_id`     INTEGER      NOT NULL,
    `contact_id`  INTEGER,
    `amount`      DOUBLE       NOT NULL,
    `description` VARCHAR(255) DEFAULT NULL,
    `status`      VARCHAR(255) NOT NULL,
    `date`        DATE,
    `type`        VARCHAR(255) NOT NULL
);

