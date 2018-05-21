 /*
 * Procesos.sql
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */
 
/**
 * Author:  Deklok
 * Created: May 8, 2018
 */

CREATE DATABASE Plataforma;

USE Plataforma;

CREATE TABLE Usuario (
    idUsuario int NOT NULL auto_increment,
    CURP varchar(25),
    nombre varchar(25),
    apellidoPaterno varchar(25),
    apellidoMaterno varchar(25),
    fechaNacimiento DATE,
    genero varchar(15),
    matricula varchar(30),
    contrasena varchar(20),
    PRIMARY KEY (idUsuario)
);

CREATE TABLE Curso (
    idCurso int NOT NULL auto_increment,
    nombre varchar(150),
    idCategoria int,
    precio double,
    fechaInicio date,
    fechaFin date,
    imagen varchar(300),
    idMaestro int,
    PRIMARY KEY (idCurso)
);

CREATE TABLE Grupo (
    idGrupo int auto_increment,
    cupo int DEFAULT 30,
    alumnos int DEFAULT 0,
    idCurso int,
    PRIMARY KEY (idGrupo)
);

CREATE TABLE Pago (
    idPago int NOT NULL auto_increment,
    informacionDePago varchar(500),
    estado varchar(20),
    idUsuario int,
    idGrupo int,
    PRIMARY KEY (idPago)
);

CREATE TABLE Categoria (
    idCategoria int NOT NULL auto_increment,
    nombre varchar(100),
    PRIMARY KEY (idCategoria)
);

CREATE TABLE Maestro (
    idMaestro int NOT NULL auto_increment,
    usuario varchar(50),
    contrasena varchar(20),
    nombre varchar(150),
    PRIMARY KEY (idMaestro)
);

ALTER TABLE Grupo ADD CONSTRAINT
    fk_grupo foreign key (idCurso)
    REFERENCES Curso (idCurso);

ALTER TABLE Pago ADD CONSTRAINT
    fk_pago1 foreign key (idUsuario)
    REFERENCES Usuario (idUsuario);

ALTER TABLE Pago ADD CONSTRAINT
    fk_pago2 foreign key (idGrupo)
    REFERENCES Grupo (idGrupo);

ALTER TABLE Curso ADD CONSTRAINT
    fk_curso foreign key (idCategoria)
    REFERENCES Categoria (idCategoria);

ALTER TABLE Curso ADD CONSTRAINT
    fk_maestro foreign key (idMaestro)
    REFERENCES Maestro (idMaestro);

INSERT INTO usuario (idUsuario,CURP,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,genero,matricula,contrasena)
    VALUES(NULL, "1221", "Manolo", "Pérez", "Verdejo", '1998-03-13', "Hombre", "zS16011702", "1234");

INSERT INTO usuario (idUsuario,CURP,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,genero,matricula,contrasena)
    VALUES(NULL, "1293", "Daniel", "Escamilla", "Cortés", '1997-02-17', "Hombre", "zS16011672", "1234");

INSERT INTO usuario (idUsuario,CURP,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,genero,matricula,contrasena)
    VALUES(NULL, "765237325", "Daniela", "Hernández", "Valenzuela", '1998-08-20', "Mujer", "zS16011678", "4321");

INSERT INTO categoria (nombre)
    VALUES("Matemáticas"),
    ("Economia"),
    ("Salud");

INSERT INTO curso (nombre,idcategoria,precio,fechaInicio,fechaFin,imagen)
    VALUES("Cálculo", 1, 135, '2018-03-13', '2018-04-02', "/resources/Cursos/1.jpg");

INSERT INTO curso (nombre,idcategoria,precio,fechaInicio,fechaFin,imagen)
    VALUES("Estadística", 1, 350, '2018-03-13', '2018-04-02', "/resources/Cursos/Estadistica.jpg");

INSERT INTO curso (nombre,idcategoria,precio,fechaInicio,fechaFin,imagen)
    VALUES("Economia", 2, 350, '2018-03-13', '2018-04-02', "/resources/Cursos/Economia.jpg");

INSERT INTO curso (nombre,idcategoria,precio,fechaInicio,fechaFin,imagen)
    VALUES("Primeros Auxilios", 3, 249, '2018-03-13', '2018-04-02', "/resources/Cursos/Salud.png");