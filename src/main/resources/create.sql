create table step(
	id int not null,
	title varchar(100),
	description varchar(255),
	constraint pkstep00 primary key(id)
);

insert into step(id, title, description) values (1, 'teste 1', 'teste 1');
insert into step(id, title, description) values (2, 'Titulo 2', 'Descricao 2');
insert into step(id, title, description) values (3, 'Titulo 3', 'Descricao 3');
insert into step(id, title, description) values (4, 'Titulo 4', 'Descricao 4');
insert into step(id, title, description) values (5, 'Titulo 5', 'Descricao 5');

