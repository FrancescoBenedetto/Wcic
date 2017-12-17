-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 02, 2016 alle 15:25
-- Versione del server: 5.7.14
-- Versione PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recipes`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `dish`
--

CREATE TABLE `dish` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `instructions` text NOT NULL,
  `type` varchar(20) NOT NULL,
  `time` varchar(10) DEFAULT '0',
  `difficulty` varchar(20) DEFAULT 'non specificata',
  `origin` varchar(30) DEFAULT 'non specificata',
  `primary_ingredient` varchar(30) DEFAULT 'non specificato'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `ingredient`
--

CREATE TABLE `ingredient` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `recipe_composition`
--

CREATE TABLE `recipe_composition` (
  `id_dish` bigint(20) UNSIGNED NOT NULL,
  `id_ingredient` bigint(20) UNSIGNED NOT NULL,
  `quantity` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `dish`
--
ALTER TABLE `dish`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indici per le tabelle `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `name` (`name`);

--
-- Indici per le tabelle `recipe_composition`
--
ALTER TABLE `recipe_composition`
  ADD PRIMARY KEY (`id_dish`,`id_ingredient`),
  ADD KEY `ing2composition` (`id_ingredient`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `dish`
--
ALTER TABLE `dish`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `recipe_composition`
--
ALTER TABLE `recipe_composition`
  ADD CONSTRAINT `dish2composition` FOREIGN KEY (`id_dish`) REFERENCES `dish` (`id`),
  ADD CONSTRAINT `ing2composition` FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
