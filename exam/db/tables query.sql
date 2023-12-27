create table пользователи(
Id serial PRIMARY KEY,
фамилия varchar(40) not null, 
имя varchar(40) not null, 
отчество varchar(40) not null, 
логин varchar(40) not null,
пароль varchar(40) not null,
роль varchar(40) not null 
);