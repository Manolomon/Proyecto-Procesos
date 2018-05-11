-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: Plataforma
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Curso`
--

DROP TABLE IF EXISTS `Curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Curso` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `imagen` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Curso`
--

LOCK TABLES `Curso` WRITE;
/*!40000 ALTER TABLE `Curso` DISABLE KEYS */;
INSERT INTO `Curso` VALUES (1,'Redes','Informatica',500,'2018-05-11','2018-08-11',NULL),(2,'Paradigmas de programacion','Informatica',450,'2018-05-11','2018-08-11',NULL),(3,'Programacion','Informatica',500,'2018-05-11','2018-08-11',NULL),(4,'Principios de diseño','Informatica',500,'2018-05-11','2018-08-11',NULL),(5,'Principios de construccion','Informatica',500,'2018-05-12','2018-08-12',NULL),(6,'Procesos de ingenieria de software','Informatica',500,'2018-05-12','2018-08-12',NULL),(7,'Requerimientos de software','Informatica',500,'2018-05-11','2018-08-11',NULL),(8,'Probabilidad','Estadistica',350,'2018-05-11','2018-08-11',NULL),(9,'Programacion Estadistica','Estadistica',400,'2018-05-11','2018-08-11',NULL),(10,'Macroeconomia','Economia',500,'2018-05-20','2018-08-20',NULL),(11,'Microeconomia','Economia',300,'2018-05-20','2018-08-20',NULL),(12,'Matematicas','Economia',300,'2018-05-20','2018-08-20',NULL),(13,'Cardiologia','Salud',500,'2018-05-11','2018-08-11',NULL),(14,'Nutricion','Salud',500,'2018-05-11','2018-08-11',NULL),(15,'Ginecologia','Salud',500,'2018-05-15','2018-08-15',NULL),(16,'Pediatria','Salud',500,'2018-05-15','2018-08-15',NULL),(17,'Neurologia','Salud',450,'2018-05-15','2018-08-15',NULL);
/*!40000 ALTER TABLE `Curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Grupo`
--

DROP TABLE IF EXISTS `Grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Grupo` (
  `idGrupo` int(11) NOT NULL AUTO_INCREMENT,
  `cupo` int(11) DEFAULT '30',
  `alumnos` int(11) DEFAULT '0',
  `idCurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idGrupo`),
  KEY `fk_grupo` (`idCurso`),
  CONSTRAINT `fk_grupo` FOREIGN KEY (`idCurso`) REFERENCES `Curso` (`idCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Grupo`
--

LOCK TABLES `Grupo` WRITE;
/*!40000 ALTER TABLE `Grupo` DISABLE KEYS */;
INSERT INTO `Grupo` VALUES (1,30,12,1),(2,30,13,2),(3,30,14,3),(4,30,15,4),(5,30,16,5),(6,30,17,6),(7,30,18,7),(8,30,19,8),(9,30,20,9),(10,30,21,10),(11,30,22,11),(12,30,22,12),(13,30,13,13),(14,30,15,14),(15,30,16,15),(16,30,16,16),(17,30,11,17),(18,30,13,17),(19,30,29,16),(20,30,12,15);
/*!40000 ALTER TABLE `Grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pago`
--

DROP TABLE IF EXISTS `Pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pago` (
  `idPago` int(11) NOT NULL AUTO_INCREMENT,
  `informacionDePago` varchar(500) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `idGrupo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPago`),
  KEY `fk_pago1` (`idUsuario`),
  KEY `fk_pago2` (`idGrupo`),
  CONSTRAINT `fk_pago1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`),
  CONSTRAINT `fk_pago2` FOREIGN KEY (`idGrupo`) REFERENCES `Grupo` (`idGrupo`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pago`
--

LOCK TABLES `Pago` WRITE;
/*!40000 ALTER TABLE `Pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `Pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `CURP` varchar(25) DEFAULT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `apellidoPaterno` varchar(25) DEFAULT NULL,
  `apellidoMaterno` varchar(25) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `genero` varchar(15) DEFAULT NULL,
  `matricula` varchar(30) DEFAULT NULL,
  `contrasena` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'1221','Manolo','Pérez','Verdejo','1998-03-13','Hombre','zS16011702','1234'),(2,'1293','Daniel','Escamilla','Cortez','1997-02-22','Hombre','zS16011672','1234'),(3,'765237325','Daniela','Hernández','Valenzuela','1998-08-20','Mujer','zS16011678','4321'),(4,'13443','Alejandra','Alcantara','Demuner','1998-05-25','Mujer','zS16011543','2222');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-10 23:48:42
