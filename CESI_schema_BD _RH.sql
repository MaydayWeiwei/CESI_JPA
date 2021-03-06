﻿---- Suppression des tables 
drop table if exists "employe";
drop table if exists "service"; 
---- Création des tables 
create table "service" ( 
id serial primary key, 
nom varchar(50) not null,
service_rattache_fk integer references "service",
responsable_fk integer not null ); 

create table "employe" ( 
id serial primary key,
nom varchar(100) not null,
prenom varchar(100) not null,
service_fk integer not null references "service",
statut varchar(10) not null,
date_debut Date not null,
date_fin Date ); 
-- Données de tests
--- Deux service…
insert into "service" values (DEFAULT, 'Service1', null, 1); insert into "service" values (DEFAULT, 'service2', 1, 3); 
--- ... et trois employes: employe1, employe2, employe3 et employe4
insert into "employe" values (DEFAULT, 'nom1', 'prenom1', 1, 'CDD', '01-01-2015','01-10-2015' ); insert into "employe" values (DEFAULT, 'nom2', 'prenom2', 1,'CDI', '01-01-2015'); insert into "employe" values (DEFAULT, 'nom3', 'prenom3', 2 ,'CDD', '01-01-2015','01-10-2015'); insert into "employe" values (DEFAULT, 'nom4', 'prenom4', 2,'CDD', '01-01-2015','01-10-2015');