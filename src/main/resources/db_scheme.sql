CREATE DATABASE IF NOT EXISTS `crm_srm_system` /*!40100 DEFAULT CHARACTER SET latin1*/;  
USE `crm_srm_system`;  

DROP TABLE IF EXISTS `sell`;
DROP TABLE IF EXISTS `buy`;
DROP TABLE IF EXISTS `cl_manager`;
DROP TABLE IF EXISTS `sup_manager`;
DROP TABLE IF EXISTS `good`;
DROP TABLE IF EXISTS `client`;
DROP TABLE IF EXISTS `supplier`;

CREATE TABLE IF NOT EXISTS `client` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `about` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `client`(`id`, `name`, `about`) VALUES(1, 'Алеша', 'Топ покупатель');

CREATE TABLE IF NOT EXISTS `supplier` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `about` VARCHAR(200) NOT NULL,
	PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `supplier`(`id`, `name`, `about`) VALUES(1, 'Артуша', 'Топ продавец');

CREATE TABLE IF NOT EXISTS `good` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `about` VARCHAR(200) NOT NULL,
  `price` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `good`(`id`, `name`, `about`, `price`) VALUES(1, 'Супер компьютер', 'Топ комп', 20.0);

CREATE TABLE IF NOT EXISTS `cl_manager` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idClient` INT UNSIGNED NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(13) NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `idClient` FOREIGN KEY (`idClient`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (`id`)
 )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `cl_manager`(`id`, `idClient`, `name`, `email`, `phone`) VALUES(1, 1, 'Топ клиент мэнеджер', 'qwe@gmail.com', '80291234567');

CREATE TABLE IF NOT EXISTS `sell` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idGoodSell` INT UNSIGNED NOT NULL,
  `idCl_manager` INT UNSIGNED NOT NULL,
  `date` DATE NOT NULL,
  `quantity` FLOAT NOT NULL,
  `discount` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `idGoodSell` FOREIGN KEY (`idGoodSell`) REFERENCES `good` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idCl_manager` FOREIGN KEY (`idCl_manager`) REFERENCES `cl_manager` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
 )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `sell`(`id`, `idGoodSell`, `idCl_manager`, `date`, `quantity`, `discount`) VALUES(1, 1, 1, '2016-09-21', 2.0, 10.0);

CREATE TABLE IF NOT EXISTS `sup_manager` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idSupplier` INT UNSIGNED NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(13) NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `idSupplier` FOREIGN KEY (`idSupplier`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (`id`)
 )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `sup_manager`(`id`, `idSupplier`, `name`, `email`, `phone`) VALUES(1, 1, 'Топ прод мэнеджер', 'zxc@gmail.com', '80291234567');

CREATE TABLE IF NOT EXISTS `buy` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idGoodBuy` INT UNSIGNED NOT NULL,
  `idSup_manager` INT UNSIGNED NOT NULL,
  `date` DATE NOT NULL,
  `quantity` FLOAT NOT NULL,
  `discount` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `idGoodBuy` FOREIGN KEY (`idGoodBuy`) REFERENCES `good` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idSup_manager` FOREIGN KEY (`idSup_manager`) REFERENCES `sup_manager` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
 )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `buy`(`id`, `idGoodBuy`, `idSup_manager`, `date`, `quantity`, `discount`) VALUES(1, 1, 1, '2016-09-21', 2.0, 10.0);
