-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 08 avr. 2024 à 08:48
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
-- Structure de la table `billet`
--

DROP TABLE IF EXISTS `billet`;
CREATE TABLE IF NOT EXISTS `billet` (
                                        `id_billet` varchar(255) NOT NULL,
    `id_sceance` varchar(255) NOT NULL,
    `id_film` varchar(255) NOT NULL,
    `id_utilisateur` varchar(255) NOT NULL,
    `prixcommande` int NOT NULL,
    `nombreBilletAdulte` int NOT NULL,
    `nombreBilletEnfant` int NOT NULL,
    `nombreBilletSenior` int NOT NULL,
    `siegeBillet` text NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `billet`
--

INSERT INTO `billet` (`id_billet`, `id_sceance`, `id_film`, `id_utilisateur`, `prixcommande`, `nombreBilletAdulte`, `nombreBilletEnfant`, `nombreBilletSenior`, `siegeBillet`) VALUES
    ('4a2ef428-e1bb-4770-8215-d8c4e39ed7b1', '1', '[value-6]', '34ff0fef-8cd4-4b92-b9e7-c322f9f4e472', 2, 1, 1, 1, 'A2');

-- --------------------------------------------------------

--
-- Structure de la table `films`
--

DROP TABLE IF EXISTS `films`;
CREATE TABLE IF NOT EXISTS `films` (
                                       `nom` varchar(255) DEFAULT NULL,
    `Synopsis` text,
    `note` float DEFAULT NULL,
    `URL_image` text NOT NULL,
    `PrixFilm` int NOT NULL,
    `uuid` char(36) DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `films`
--

INSERT INTO `films` (`nom`, `Synopsis`, `note`, `URL_image`, `PrixFilm`, `uuid`) VALUES
    ('[value-1]', '[value-2]', 3, '[value-4]', 5, '[value-6]');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
                                       `id_salle` int NOT NULL,
                                       `adresse` text NOT NULL,
                                       `nbplace` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `sceance`
--

DROP TABLE IF EXISTS `sceance`;
CREATE TABLE IF NOT EXISTS `sceance` (
                                         `id_sceance` text,
                                         `id_film` varchar(255) DEFAULT NULL,
    `horaire` text,
    `id_salle` text,
    `date` text NOT NULL,
    `nb_place_restante` int NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `sceance`
--

INSERT INTO `sceance` (`id_sceance`, `id_film`, `horaire`, `id_salle`, `date`, `nb_place_restante`) VALUES
    ('1', 'idfilm', '14h00', '1', '9juin', 12);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
                                             `uuid` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `email` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `age` int DEFAULT NULL,
    `nvAvantage` int DEFAULT NULL,
    `nom` varchar(255) DEFAULT NULL,
    `prenom` varchar(255) DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`uuid`, `email`, `password`, `age`, `nvAvantage`, `nom`, `prenom`) VALUES
                                                                                                  ('34ff0fef-8cd4-4b92-b9e7-c322f9f4e472', 'ethan', 'berneau', 1, 1, 'etha,', 'zre'),
                                                                                                  ('4c6a7eac-fb25-4816-9550-09b70bbee919', 'coco', 'za', 10, 1, 'eza', 'rze');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
