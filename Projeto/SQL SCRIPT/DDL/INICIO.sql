CREATE TABLE `estacionamento`.`inicio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ticket_cartao` INT NOT NULL,
  `carro` VARCHAR(100) NULL,
  `placa` VARCHAR(100) NULL,
  `cliente` VARCHAR(255) NULL,
  `dtEntrada` DATE NULL,
  `idCliente` INT NOT NULL,
  `idCaixa` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `estacionamento`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idCaixa`
    FOREIGN KEY (`idCaixa`)
    REFERENCES `estacionamento`.`caixa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
