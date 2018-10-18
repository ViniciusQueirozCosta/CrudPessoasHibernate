use master
go

create database CrudPessoasJava
go

use CrudPessoasJava
go

create table Pessoas(
	id int primary key identity,
	nome varchar(30),
	rg varchar(10),
	cpf varchar(13)
	)
go