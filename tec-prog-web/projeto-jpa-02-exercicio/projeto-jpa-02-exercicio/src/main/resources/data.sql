
-- caso a configuração "spring.jpa.defer-datasource-initialization" estiver true,
-- todas as instruções aqui serão executadas
-- PODEM haver mais de 1 insert, porém devem sempre terminar com ";"
insert into Salgadinho
(nome, nivel_sal, preco, apimentado)
values
('Sheirinhos', 4, 20.50, false),
('Cheetos', 3, 4.50, false),
('Queijos', 5, 1.50, false),
('Cheetos Hot Flaming', 3, 70.50, true),
('Fandangos', 2, 3.50, false);

-- insert numa 2a tabela;

-- insert numa 3a tabela;