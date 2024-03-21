-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 21 mars 2024 à 10:58
-- Version du serveur : 8.0.32
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cinemaprojet`
--

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
                                         `id` int DEFAULT NULL,
                                         `email` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `age` int DEFAULT NULL,
    `nvAvantage` int DEFAULT NULL,
    `nom` varchar(255) DEFAULT NULL,
    `prenom` varchar(255) DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`id`, `email`, `password`, `age`, `nvAvantage`, `nom`, `prenom`) VALUES
                                                                                            (NULL, 't', 't', 4, 1, 't', 't'),
                                                                                            (NULL, 'y', 'y', 1, 1, 'y', 'y'),
                                                                                            (NULL, 'q', 'q', 6, 1, 'qq', 'q');

-- --------------------------------------------------------

--
-- Structure de la table `employes`
--

DROP TABLE IF EXISTS `employes`;
CREATE TABLE IF NOT EXISTS `employes` (
                                          `nom` int NOT NULL,
                                          `prenom` int NOT NULL,
                                          `email` int NOT NULL,
                                          `password` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `films`
--

DROP TABLE IF EXISTS `films`;
CREATE TABLE IF NOT EXISTS `films` (
                                       `id` int DEFAULT NULL,
                                       `nom` varchar(255) DEFAULT NULL,
    `Synopsis` text,
    `note` float DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `sceance`
--

DROP TABLE IF EXISTS `sceance`;
CREATE TABLE IF NOT EXISTS `sceance` (
                                         `id` int DEFAULT NULL,
                                         `id_film` int DEFAULT NULL,
                                         `horaire` datetime DEFAULT NULL,
                                         `id_salle` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
