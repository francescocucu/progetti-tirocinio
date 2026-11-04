create database libreria;
use libreria;

create table libri (
id int primary key auto_increment,
titolo varchar (100) not null,
id_genere int,
foreign key (id_genere) references generi(id)
);
alter table libri
add column anno int;



create table generi (
id int primary key auto_increment,
nome varchar (100) not null
);

create table libri_autore (
id_libri int,
foreign key (id_libri) references libri(id),
id_autore int,
foreign key (id_autore) references autore(id)
);

create table autore (
id int primary key auto_increment,
nome varchar (100) not null,
cognome varchar (100) not null,
data_nascita int,
nazionalita varchar (100) 
);

create table copie (
id int primary key auto_increment,
numero_copie int not null,
case_editrici_id int,
foreign key (case_editrici_id) references case_editrici(id),
libri_id int,
foreign key (libri_id) references libri(id)
);


create table case_editrici (
id int primary key auto_increment,
nome varchar (100) not null
);


