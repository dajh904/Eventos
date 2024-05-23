-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 18-05-2024 a las 18:02:48
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion_eventos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistente`
--

CREATE TABLE `asistente` (
  `Id_asistente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `num_doc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadoevento`
--

CREATE TABLE `estadoevento` (
  `Id_Estadoevento` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento`
--

CREATE TABLE `evento` (
  `Id_evento` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `fecha_ini` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL,
  `Id_organizador` int(11) NOT NULL,
  `Id_Estadoevento` int(11) NOT NULL,
  `Aforo` int(11) NOT NULL,
  `Id_Ubicacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagenevento`
--

CREATE TABLE `imagenevento` (
  `Id_imagenevento` int(11) NOT NULL,
  `direccion` varchar(1000) NOT NULL,
  `Id_evento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `organizador`
--

CREATE TABLE `organizador` (
  `Id_organizador` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `num_doc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prueba`
--

CREATE TABLE `prueba` (
  `id_prueba` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoboleto`
--

CREATE TABLE `tipoboleto` (
  `Id_Tipoboleto` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoboleto_evento`
--

CREATE TABLE `tipoboleto_evento` (
  `Id_TipoBoleto_Evento` int(11) NOT NULL,
  `Id_Tipoboleto` int(11) NOT NULL,
  `precioboleto` decimal(10,0) NOT NULL,
  `cantidad_disp` int(11) NOT NULL,
  `Id_evento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacionevento`
--

CREATE TABLE `ubicacionevento` (
  `Id_Ubicacionevento` int(11) NOT NULL,
  `nombre` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `videoevento`
--

CREATE TABLE `videoevento` (
  `Id_videoevento` int(11) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `Id_evento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistente`
--
ALTER TABLE `asistente`
  ADD PRIMARY KEY (`Id_asistente`);

--
-- Indices de la tabla `estadoevento`
--
ALTER TABLE `estadoevento`
  ADD PRIMARY KEY (`Id_Estadoevento`);

--
-- Indices de la tabla `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`Id_evento`),
  ADD KEY `fk_Id_organizador` (`Id_organizador`),
  ADD KEY `fk_Id_Estadoevento` (`Id_Estadoevento`),
  ADD KEY `fk_Id_Ubicacionevento` (`Id_Ubicacion`);

--
-- Indices de la tabla `imagenevento`
--
ALTER TABLE `imagenevento`
  ADD PRIMARY KEY (`Id_imagenevento`),
  ADD KEY `fk_Id_evento` (`Id_evento`);

--
-- Indices de la tabla `organizador`
--
ALTER TABLE `organizador`
  ADD PRIMARY KEY (`Id_organizador`);

--
-- Indices de la tabla `tipoboleto`
--
ALTER TABLE `tipoboleto`
  ADD PRIMARY KEY (`Id_Tipoboleto`);

--
-- Indices de la tabla `tipoboleto_evento`
--
ALTER TABLE `tipoboleto_evento`
  ADD PRIMARY KEY (`Id_TipoBoleto_Evento`),
  ADD KEY `FK_Id_Tipoboleto` (`Id_Tipoboleto`),
  ADD KEY `FK_Id_evento_boleto` (`Id_evento`);

--
-- Indices de la tabla `ubicacionevento`
--
ALTER TABLE `ubicacionevento`
  ADD PRIMARY KEY (`Id_Ubicacionevento`);

--
-- Indices de la tabla `videoevento`
--
ALTER TABLE `videoevento`
  ADD PRIMARY KEY (`Id_videoevento`),
  ADD KEY `FK_Id_eventov` (`Id_evento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistente`
--
ALTER TABLE `asistente`
  MODIFY `Id_asistente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estadoevento`
--
ALTER TABLE `estadoevento`
  MODIFY `Id_Estadoevento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `evento`
--
ALTER TABLE `evento`
  MODIFY `Id_evento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `imagenevento`
--
ALTER TABLE `imagenevento`
  MODIFY `Id_imagenevento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `organizador`
--
ALTER TABLE `organizador`
  MODIFY `Id_organizador` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipoboleto`
--
ALTER TABLE `tipoboleto`
  MODIFY `Id_Tipoboleto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipoboleto_evento`
--
ALTER TABLE `tipoboleto_evento`
  MODIFY `Id_TipoBoleto_Evento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ubicacionevento`
--
ALTER TABLE `ubicacionevento`
  MODIFY `Id_Ubicacionevento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `videoevento`
--
ALTER TABLE `videoevento`
  MODIFY `Id_videoevento` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `fk_Id_Estadoevento` FOREIGN KEY (`Id_Estadoevento`) REFERENCES `estadoevento` (`Id_Estadoevento`),
  ADD CONSTRAINT `fk_Id_Ubicacionevento` FOREIGN KEY (`Id_Ubicacion`) REFERENCES `ubicacionevento` (`Id_Ubicacionevento`),
  ADD CONSTRAINT `fk_Id_organizador` FOREIGN KEY (`Id_organizador`) REFERENCES `organizador` (`Id_organizador`);

--
-- Filtros para la tabla `imagenevento`
--
ALTER TABLE `imagenevento`
  ADD CONSTRAINT `fk_Id_evento` FOREIGN KEY (`Id_evento`) REFERENCES `evento` (`Id_evento`);

--
-- Filtros para la tabla `tipoboleto_evento`
--
ALTER TABLE `tipoboleto_evento`
  ADD CONSTRAINT `FK_Id_Tipoboleto` FOREIGN KEY (`Id_Tipoboleto`) REFERENCES `tipoboleto` (`Id_Tipoboleto`),
  ADD CONSTRAINT `FK_Id_evento_boleto` FOREIGN KEY (`Id_evento`) REFERENCES `evento` (`Id_evento`);

--
-- Filtros para la tabla `videoevento`
--
ALTER TABLE `videoevento`
  ADD CONSTRAINT `FK_Id_eventov` FOREIGN KEY (`Id_evento`) REFERENCES `evento` (`Id_evento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
