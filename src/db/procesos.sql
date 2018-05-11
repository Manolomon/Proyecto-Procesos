    informacionDePago varchar(500),
    estado varchar(20),
    idUsuario int,
    idGrupo int,
    PRIMARY KEY (idPago)
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
 
INSERT INTO usuario (idUsuario,CURP,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,genero,matricula,contrasena)
    VALUES(NULL, "1221", "Manolo", "Pérez", "Verdejo", '1998-03-13', "Hombre", "zS16011702", "1234");
 
INSERT INTO usuario (idUsuario,CURP,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,genero,matricula,contrasena)
    VALUES(NULL, "1293", "Daniel", "Escamilla", "Cortez", '1997-02-22', "Hombre", "zS16011672", "1234");
 
INSERT INTO usuario (idUsuario,CURP,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,genero,matricula,contrasena)
    VALUES(NULL, "765237325", "Daniela", "Hernández", "Valenzuela", '1998-08-20', "Mujer", "zS16011678", "4321");
 
INSERT INTO curso (nombre,categoria,precio,fechaInicio,fechaFin,imagen)
    VALUES("Cálculo", "Matemáticas", 135, '2018-03-13', '2018-04-02', "/resources/Cursos/1.jpg");
 
INSERT INTO curso (nombre,categoria,precio,fechaInicio,fechaFin,imagen)
    VALUES("Geometría Analítica", "Matemáticas", 135, '2018-03-13', '2018-04-02', "/resources/Cursos/1.jpg");
 
INSERT INTO curso (nombre,categoria,precio,fechaInicio,fechaFin,imagen)
    VALUES("Español Antiguo", "Literatura", 135, '2018-03-13', '2018-04-02', "/resources/Cursos/1.jpg");