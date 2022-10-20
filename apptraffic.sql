-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-10-2022 a las 23:30:00
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `apptraffic`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tba_usuarios`
--

CREATE TABLE `tba_usuarios` (
  `CodUsuario` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Apellido` varchar(100) NOT NULL,
  `Celular` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` text NOT NULL,
  `CorreElectronico` varchar(100) NOT NULL,
  `CodDistrito` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tba_usuarios`
--

INSERT INTO `tba_usuarios` (`CodUsuario`, `Nombre`, `Apellido`, `Celular`, `Username`, `Password`, `CorreElectronico`, `CodDistrito`) VALUES
(1, 'David', '', '', 'dav123', '$2y$10$2DbBz0DtLoe/i7nD9D4Kk.MJ.ZvybW28ba68b/3n4iPk8EdR2k53K', 'dav123@gmai.com', ''),
(2, 'David', 'Poblette', '12345678', 'dplin', '$2y$10$ub6GiMnkym0ygdBQ6PeYZeW686D4xDqVCbHt8dNsDJ6Hqj.tKSpdC', 'dplin@12.com', 'Cayma');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tba_usuarios`
--
ALTER TABLE `tba_usuarios`
  ADD PRIMARY KEY (`CodUsuario`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `CorreElectronico` (`CorreElectronico`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tba_usuarios`
--
ALTER TABLE `tba_usuarios`
  MODIFY `CodUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
