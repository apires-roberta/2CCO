-- ao criamos um arquivo de nome "data.sql" na pasta "resources"
-- caso a configuração "spring.jpa.defer-datasource-initialization" estiver true,
-- todas as instruções aqui serão executadas
-- PODEM haver mais de 1 insert, porém devem sempre terminar com ";"
insert into (fabricante) values('Honda'),('CaoaCherry'),('Fiat');

insert into (pais) values('Japao'),('China'),('Italia');

insert into Carro
(modelo, potencia) values
('Civic', 7.0),
('Tiggo', 8.5),
('Argo', 9,5);

-- insert numa 2a tabela;

-- insert numa 3a tabela;