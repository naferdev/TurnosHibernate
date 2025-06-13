-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema turnosHibernate
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema turnosHibernate
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `turnosHibernate` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `turnosHibernate` ;

-- -----------------------------------------------------
-- Table `turnosHibernate`.`provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`provincia` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `turnosHibernate`.`localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`localidad` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `provincia_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK37mbpxuicwnbo878s9djjgr39` (`provincia_id` ASC) VISIBLE,
  CONSTRAINT `FK37mbpxuicwnbo878s9djjgr39`
    FOREIGN KEY (`provincia_id`)
    REFERENCES `turnosHibernate`.`provincia` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2383
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `turnosHibernate`.`direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`direccion` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `altura` INT NULL DEFAULT NULL,
  `calle` VARCHAR(255) NULL DEFAULT NULL,
  `localidad_id` BIGINT NULL DEFAULT NULL,
  `provincia_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKbrm0ogdtkt096len14mgaaau7` (`localidad_id` ASC) VISIBLE,
  INDEX `FKseb5v97ehmni2n3520nfkvgt4` (`provincia_id` ASC) VISIBLE,
  CONSTRAINT `FKbrm0ogdtkt096len14mgaaau7`
    FOREIGN KEY (`localidad_id`)
    REFERENCES `turnosHibernate`.`localidad` (`id`),
  CONSTRAINT `FKseb5v97ehmni2n3520nfkvgt4`
    FOREIGN KEY (`provincia_id`)
    REFERENCES `turnosHibernate`.`provincia` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `turnosHibernate`.`lugar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`lugar` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `horario_apertura` TIME NOT NULL,
  `horario_cierre` TIME NOT NULL,
  `direccion_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKgtqu2fopmyxtqlj5uogjfsf2v` (`direccion_id` ASC) VISIBLE,
  CONSTRAINT `FKsdgewt2f0kqu3iy4isf8d6wrl`
    FOREIGN KEY (`direccion_id`)
    REFERENCES `turnosHibernate`.`direccion` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `turnosHibernate`.`especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`especialidad` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `turnosHibernate`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`persona` (
  `tipo_persona` VARCHAR(31) NOT NULL,
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `dni` INT NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `nro_cliente` VARCHAR(255) NULL DEFAULT NULL,
  `matricula` INT NULL DEFAULT NULL,
  `contacto_id` BIGINT NULL DEFAULT NULL,
  `especialidad_id` BIGINT NULL DEFAULT NULL,
  `lugar_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK4xwp2yc83bltjjw2pexbfwxjg` (`contacto_id` ASC) VISIBLE,
  INDEX `FKfw94751duiddbf1ijs0ujv15j` (`especialidad_id` ASC) VISIBLE,
  INDEX `FK11fuc740ev17502osx4wqp0do` (`lugar_id` ASC) VISIBLE,
  CONSTRAINT `FK11fuc740ev17502osx4wqp0do`
    FOREIGN KEY (`lugar_id`)
    REFERENCES `turnosHibernate`.`lugar` (`id`),
  CONSTRAINT `FKeshasyrps3v2q0j2ym4tdog3h`
    FOREIGN KEY (`contacto_id`)
    REFERENCES `turnosHibernate`.`contacto` (`id`),
  CONSTRAINT `FKfw94751duiddbf1ijs0ujv15j`
    FOREIGN KEY (`especialidad_id`)
    REFERENCES `turnosHibernate`.`especialidad` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `turnosHibernate`.`contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`contacto` (
  `id` BIGINT NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `movil` INT NULL DEFAULT NULL,
  `telefono` INT NULL DEFAULT NULL,
  `direccion_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKrtntr7i44nqj48bj19enfuyrj` (`direccion_id` ASC) VISIBLE,
  CONSTRAINT `FK6cpk9miyo76k8rlfp5t52qn1`
    FOREIGN KEY (`id`)
    REFERENCES `turnosHibernate`.`persona` (`id`),
  CONSTRAINT `FKrp3ckrkkkng6y86iilywrx5lq`
    FOREIGN KEY (`direccion_id`)
    REFERENCES `turnosHibernate`.`direccion` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `turnosHibernate`.`disponibilidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`disponibilidad` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `duracion` BIGINT NULL DEFAULT NULL,
  `inicio` DATETIME(6) NULL DEFAULT NULL,
  `ocupado` BIT(1) NULL DEFAULT NULL,
  `profesional_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK3f2l88cp2wh1pp450gyjcan9k` (`profesional_id` ASC) VISIBLE,
  CONSTRAINT `FK3f2l88cp2wh1pp450gyjcan9k`
    FOREIGN KEY (`profesional_id`)
    REFERENCES `turnosHibernate`.`persona` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 707
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `turnosHibernate`.`servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`servicio` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(255) NULL DEFAULT NULL,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `precio` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `turnosHibernate`.`servicios_lugares`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`servicios_lugares` (
  `servicio_id` BIGINT NOT NULL,
  `lugar_id` BIGINT NOT NULL,
  PRIMARY KEY (`servicio_id`, `lugar_id`),
  INDEX `FKcr4fn0g9gaxf8yqw88014od47` (`lugar_id` ASC) VISIBLE,
  CONSTRAINT `FK91vavajv9vacic9hdqxbg25cq`
    FOREIGN KEY (`servicio_id`)
    REFERENCES `turnosHibernate`.`servicio` (`id`),
  CONSTRAINT `FKcr4fn0g9gaxf8yqw88014od47`
    FOREIGN KEY (`lugar_id`)
    REFERENCES `turnosHibernate`.`lugar` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `turnosHibernate`.`servicios_profesionales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`servicios_profesionales` (
  `servicio_id` BIGINT NOT NULL,
  `profesional_id` BIGINT NOT NULL,
  PRIMARY KEY (`servicio_id`, `profesional_id`),
  INDEX `FKlcl041uhyftxydpsjc9bog6wr` (`profesional_id` ASC) VISIBLE,
  CONSTRAINT `FKa8glcou7mq230b62rjkxk1f4f`
    FOREIGN KEY (`servicio_id`)
    REFERENCES `turnosHibernate`.`servicio` (`id`),
  CONSTRAINT `FKlcl041uhyftxydpsjc9bog6wr`
    FOREIGN KEY (`profesional_id`)
    REFERENCES `turnosHibernate`.`persona` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `turnosHibernate`.`turno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turnosHibernate`.`turno` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cliente_id` BIGINT NOT NULL,
  `disponibilidad_id` BIGINT NOT NULL,
  `profesional_id` BIGINT NOT NULL,
  `servicio_id` BIGINT NOT NULL,
  `lugar_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKc06nje2j44neqi27wrcrgko9c` (`disponibilidad_id` ASC) VISIBLE,
  INDEX `FK4jlt8t4pw0h36h9pcavondeja` (`cliente_id` ASC) VISIBLE,
  INDEX `FKnela4ptk3syvvgq48y6ipq6ey` (`profesional_id` ASC) VISIBLE,
  INDEX `FKk0ocq8hmjgn0m8xaxj6oxvopv` (`servicio_id` ASC) VISIBLE,
  INDEX `FKntb03585mn6pckrtigqc3cr6d` (`lugar_id` ASC) VISIBLE,
  CONSTRAINT `FK4jlt8t4pw0h36h9pcavondeja`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `turnosHibernate`.`persona` (`id`),
  CONSTRAINT `FKk0ocq8hmjgn0m8xaxj6oxvopv`
    FOREIGN KEY (`servicio_id`)
    REFERENCES `turnosHibernate`.`servicio` (`id`),
  CONSTRAINT `FKl77fl8uqfccgr96ggsu1eub8v`
    FOREIGN KEY (`disponibilidad_id`)
    REFERENCES `turnosHibernate`.`disponibilidad` (`id`),
  CONSTRAINT `FKnela4ptk3syvvgq48y6ipq6ey`
    FOREIGN KEY (`profesional_id`)
    REFERENCES `turnosHibernate`.`persona` (`id`),
  CONSTRAINT `FKntb03585mn6pckrtigqc3cr6d`
    FOREIGN KEY (`lugar_id`)
    REFERENCES `turnosHibernate`.`lugar` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 32
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
