create sequence seq_step;
create sequence seq_task;

create table step(
	id bigint default seq_step.nextval not null,
	title varchar(100),
	isFinally boolean default false not null,
	constraint pkstep00 primary key(id)
);

insert into step(title) values ('Etapa 1');
insert into step(title) values ('Etapa 2');
insert into step(title) values ('Etapa 3');
insert into step(title) values ('Etapa 4');
insert into step(title) values ('Etapa 5');
insert into step(title, isFinally) values ('Finalizado', true);

create table task(
	id bigint default seq_step.nextval not null,
	title varchar(100),
	description varchar(255),
	stepId int not null,
	color varchar(20),
	constraint pktask00 primary key(id),
	constraint fktask01 foreign key(stepId) references step(id)
);
