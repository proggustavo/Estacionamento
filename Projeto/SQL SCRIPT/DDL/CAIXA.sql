CREATE TABLE `estacionamento`.`caixa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ticket_cartao` INT NOT NULL, -- Verificar Possibilidade de Nenhum ser igual ao anterior, no banco com function
  `descricao` VARCHAR(255) NULL,
  `formaPgto` VARCHAR(50) NOT NULL DEFAULT 'Dinheiro',
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`id`)
  );
  
  -- Gerar relatorio com dados formatados no banco