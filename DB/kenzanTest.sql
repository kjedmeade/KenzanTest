-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kenzantest
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `kenzantest` ;

-- -----------------------------------------------------
-- Schema kenzantest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kenzantest` DEFAULT CHARACTER SET utf8 ;
USE `kenzantest` ;

-- -----------------------------------------------------
-- Table `employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee` ;

CREATE TABLE IF NOT EXISTS `employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `middle_initial` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `dob` DATETIME NULL,
  `doe` DATETIME NULL,
  `status` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS kenzanuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'kenzanuser'@'localhost' IDENTIFIED BY 'kenzanuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'kenzanuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `employee`
-- -----------------------------------------------------
START TRANSACTION;
USE `kenzantest`;
INSERT INTO `employee` (`id`, `first_name`, `middle_initial`, `last_name`, `dob`, `doe`, `status`) VALUES (1, 'Mary', 'G', 'Gran', '1989-09-09', '2021-02-02', 1);

COMMIT;

