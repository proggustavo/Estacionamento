CREATE TABLE `estacionamento`.`carro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(100) NULL,
  `modelo` VARCHAR(100) NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `cartao` INT UNSIGNED NULL,
  PRIMARY KEY (`id`));
