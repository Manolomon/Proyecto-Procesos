/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Deklok
 * Created: May 8, 2018
 */

CREATE TABLE Usuario (
    idUsuario int,
    nombre varchar(25),
    apellidoPaterno varchar(25),
    apellidoMaterno varchar(25),
    genero varchar(1),
    usuario varchar(30),
    contrasena varchar(20),
    PRIMARY KEY (idUsuario)
);

CREATE TABLE Grupo (
    idGrupo int,
    cupo int DEFAULT 30,
    PRIMARY KEY (idGrupo)
);

CREATE TABLE Curso (
    idGrupo int NOT NULL,
    nombre varchar(150),
    categoria varchar(100),
    precio double,
    fechaInicio date,
    fechaFin date,
    imagen varchar(300), --url referencia a la imagen / tbd estilo de url
    PRIMARY KEY (idGrupo)
);

CREATE TABLE Pago (
    idPago int,
    informacionDePago varchar(500),
    estado varchar(20),
    idUsuario int,
    idCurso int,
    PRIMARY KEY (idPago),
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (idCurso) REFERENCES Curso(idCurso)
);