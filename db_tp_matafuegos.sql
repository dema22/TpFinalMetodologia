CREATE DATABASE tp_final_matafuegos;
DROP DATABASE tp_final_matafuegos;
USE tp_final_matafuegos;

CREATE TABLE client (
	id_client int auto_increment not null,
    client_name varchar(50) not null,
    city varchar(50) not null,
    contact_number varchar(50) not null,
    constraint pk_id_client primary key (id_client)
);

CREATE TABLE fire_extinguisher_brand (
	id_brand int auto_increment not null,
    brand_name varchar(50) not null,
	constraint pk_id_brand primary key (id_brand)
);

CREATE TABLE fire_extinguisher (
	 id_fire_extinguisher int auto_increment not null,
     id_client int not null,
	 id_brand int not null,
     fire_extinguishing_agent varchar(30) not null,
     fire_extinguisher_capacity float not null, # kilos no ?
     date_fabrication date not null,
     loading_date date not null,
     date_hydraulic_test date not null,
     barcode varchar(13) not null,
     #opds?
     certification_bureau_veritas boolean not null,
     constraint pk_id_fire_extinguisher primary key (id_fire_extinguisher),
	 constraint fk_id_client foreign key (id_client) references client (id_client),
     constraint fk_id_brand foreign key (id_brand) references fire_extinguisher_brand (id_brand)
);

CREATE TABLE user_type (
	id_user_type int auto_increment not null,
    usertype_name varchar(50) not null,
    constraint pk_id_user_type primary key (id_user_type)
);

CREATE TABLE user (
	id int auto_increment not null,
    user_type int not null,
	username varchar(50) not null,
    name varchar(50),
    surname varchar(50),
    pass varchar(50) not null,
	constraint pk_id primary key (id),
	constraint fk_id_user_type foreign key (user_type) references user_type (id_user_type)
);




