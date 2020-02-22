  CREATE TABLE `estacionamento`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(100) NOT NULL,
  `rg` VARCHAR(50) NULL,
  `email` VARCHAR(255) NULL DEFAULT 'Não Informado',
  `fone` VARCHAR(100) NOT NULL,
  `bloqueado` TINYINT NULL DEFAULT 0,
  `idCarro` INT NOT NULL,
  `idEndereco` INT NOT NULL,
  `idPlano` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `idEndereco`
    FOREIGN KEY (`idEndereco`)
    REFERENCES `estacionamento`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idCarro`
    FOREIGN KEY (`idCarro`)
    REFERENCES `estacionamento`.`carro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idPlano`
    FOREIGN KEY (`idPlano`)
    REFERENCES `estacionamento`.`plano` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

  
  CREATE TABLE `estacionamento`.`plano` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `plano` VARCHAR(255) NOT NULL DEFAULT 'Mensal Comum',
  `dtVencimento` DATE NOT NULL,
  `formaPgto` VARCHAR(50) NULL DEFAULT 'Dinheiro',
  PRIMARY KEY (`id`));

  
  CREATE TABLE `estacionamento`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(255) NULL,
  `numero` INT NULL,
  `bairro` VARCHAR(255) NULL,
  `cidade` VARCHAR(255) NULL,
  `complemento` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));
