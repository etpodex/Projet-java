-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 21 avr. 2024 à 11:20
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
('idbillet1', '2', 'id123', '34ff0fef-8cd4-4b92-b9e7-c322f9f4e472', 12, 2, 0, 1, 'A1'),
('idbillet2', '3', 'idpanda1', '34ff0fef-8cd4-4b92-b9e7-c322f9f4e472', 12, 1, 2, 1, 'B1'),
('idbillet3', '4', 'iduuid313', '4c6a7eac-fb25-4816-9550-09b70bbee919', 14, 2, 2, 0, 'C1');

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
  `uuid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `acteur` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `films`
--

INSERT INTO `films` (`nom`, `Synopsis`, `note`, `URL_image`, `PrixFilm`, `uuid`, `acteur`) VALUES
('Dune', 'c est l histoire de quelqu un qui adore,il est genre en communion avec le sable, c est El Lisan al gaib', 4, 'image1.jpg', 7, 'id123', 'Zendaya Chani,Timothée Chalamet'),
('Kung Fu Panda', 'Kung Fu Panda est lhistoire de Po, un panda maladroit et fan de kung fu, qui devient le guerrier dragon improbable et doit sauver la vallée de la menace d un léopard des neiges puissant et vengeur', 7, 'image2.jpg', 7, 'idpanda1', 'Jack Black, Dustin Hoffman, Angelina jolie'),
('365 dni', 'Un puissant chef de la mafia capture une jeune femme et lui donne un an pour tomber amoureuse de lui.', 7.5, '365dni_image.jpg', 10, 'iduiid313', 'Michele Morrone, anna-maria Sieklucka');

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

DROP TABLE IF EXISTS `offre`;
CREATE TABLE IF NOT EXISTS `offre` (
  `nom` text NOT NULL,
  `reduction` int NOT NULL,
  `code_promo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`nom`, `reduction`, `code_promo`) VALUES
('promo noel', 30, 'AZERTY'),
('anniversaire', 10, 'SDfGG');

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

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id_salle`, `adresse`, `nbplace`) VALUES
(1, '25ruejeanmoulin', 100),
(2, '31 rue destienne Orves Vincennes', 100),
(3, '10 rue grimoult maison alfort', 100);

-- --------------------------------------------------------

--
-- Structure de la table `sceance`
--

DROP TABLE IF EXISTS `sceance`;
CREATE TABLE IF NOT EXISTS `sceance` (
  `id_sceance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `id_film` varchar(255) DEFAULT NULL,
  `horaire` text,
  `id_salle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date` text NOT NULL,
  `nb_place_restante` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `sceance`
--

INSERT INTO `sceance` (`id_sceance`, `id_film`, `horaire`, `id_salle`, `date`, `nb_place_restante`) VALUES
('2', 'id123', '14h00', '1', '2024-06-09', 100),
('3', 'idpanda1', '16h00', '2', '2024-06-09', 100),
('4', 'iduuid313', '18h00', '3', '2024-06-09', 100);

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
('34ff0fef-8cd4-4b92-b9e7-c322f9f4e472', 'ethan@gmail.com', 'mdp', 4, 1, 'Berneau', 'Ethan'),
('4c6a7eac-fb25-4816-9550-09b70bbee919', 'coco@gmail.com', 'mdp', 35, 3, 'brown', 'coco'),
('azerhiieur-23ezrzt-9Re12otkqsjf123', 'admin@gmail.com', 'mdp', 41, 2, 'claude', 'jean'),
('kljqsfqsjf-zaerze-r-rze', 'estelle@gmail.com', 'mdp', 80, 4, 'Estelle', 'Hervault');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
