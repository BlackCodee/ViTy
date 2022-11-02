CREATE DATABASE IF NOT EXISTS `dbvity`;
USE `dbvity`;

CREATE TABLE `citas` (
  `idc` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `nombrePaciente` varchar(255) NOT NULL,
  `nombreEspecialista` varchar(255) NOT NULL,
  `detalle` varchar(255) NOT NULL,
  PRIMARY KEY (`idc`)
);

INSERT INTO `citas` (`idc`, `fecha`, `nombrePaciente`, `nombreEspecialista`, `detalle`) VALUES
(1, '2022-10-11', 'Leonardo Aguas', 'Lorena Mora', 'No asignada'),
(2, '2022-10-15', 'Marfred de Jesus', 'Daniel Ramos', 'Asignada');

CREATE TABLE `especialista` (
  `ide` int(11) NOT NULL,
  `documento` varchar(255) NOT NULL,
  `nombreEspecialista` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  PRIMARY KEY (`ide`)
);

INSERT INTO `especialista` (`ide`, `documento`, `nombreEspecialista`, `telefono`, `correo`) VALUES
(1, '10926534', 'Daniel Ramos', '3214568798', 'danielramos@gmail.com'),
(2, '19719102', 'Lorena Mora', '3217259812', 'lorenamo@gmail.com');

CREATE TABLE `paciente` (
  `idp` int(11) NOT NULL,
  `documento` varchar(255) NOT NULL,
  `nombrePaciente` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  PRIMARY KEY (`idp`)
);

INSERT INTO `paciente` (`idp`, `documento`, `nombrePaciente`, `telefono`, `correo`) VALUES
(1, '16235928', 'Marfred de Jesus', '3102619812', 'marfred@gmail.com'),
(2, '1002651789', 'Leonardo Aguas', '21387123', 'leonardo@gmail.com');

