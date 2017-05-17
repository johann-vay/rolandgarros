-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mer 17 Mai 2017 à 09:19
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `rolandgarros`
--

-- --------------------------------------------------------

--
-- Structure de la table `compose`
--

CREATE TABLE `compose` (
  `idPlayer` int(11) NOT NULL,
  `idTeam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `country`
--

CREATE TABLE `country` (
  `idCountry` int(11) NOT NULL,
  `label` varchar(255) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `country`
--

INSERT INTO `country` (`idCountry`, `label`, `version`) VALUES
(1, 'FRA', 0),
(2, 'GBR', 0),
(3, 'ESP', 0),
(4, 'SRB', 0),
(5, 'SUI', 0),
(6, 'CAN', 0),
(7, 'AUT', 0),
(8, 'CRO', 0),
(9, 'JPN', 0),
(10, 'BEL', 0),
(11, 'BUL', 0),
(12, 'CZE', 0),
(13, 'USA', 0),
(14, 'GER', 0),
(15, 'AUS', 0),
(16, 'ROU', 0),
(17, 'SVK', 0),
(18, 'RUS', 0),
(19, 'POL', 0),
(20, 'DEN', 0),
(21, 'UKR', 0),
(22, 'LAT', 0),
(23, 'NED', 0),
(24, 'IRN', 0),
(25, 'BRE', 0),
(26, 'POR', 0),
(27, 'IRL', 0);

-- --------------------------------------------------------

--
-- Structure de la table `court`
--

CREATE TABLE `court` (
  `idCourt` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `court`
--

INSERT INTO `court` (`idCourt`, `name`, `version`) VALUES
(1, 'Philippe Chatrier', 0),
(2, 'Suzanne Lenglen', 0),
(3, 'Court N°1', 0);

-- --------------------------------------------------------

--
-- Structure de la table `game`
--

CREATE TABLE `game` (
  `idGame` int(11) NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime DEFAULT NULL,
  `idReferee` int(11) NOT NULL,
  `idCourt` int(11) NOT NULL,
  `idTournament` int(11) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `game`
--

INSERT INTO `game` (`idGame`, `startDate`, `endDate`, `idReferee`, `idCourt`, `idTournament`, `version`) VALUES
(1, '2017-05-15 11:30:00', '2017-05-15 14:30:00', 1, 2, 1, 0),
(2, '2017-06-03 15:00:00', NULL, 4, 1, 1, 0),
(3, '2017-06-04 12:30:00', NULL, 2, 3, 1, 0),
(4, '2017-05-07 13:30:00', NULL, 5, 2, 1, 0),
(5, '2017-06-05 11:00:00', NULL, 3, 1, 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `play`
--

CREATE TABLE `play` (
  `idPlayer` int(11) NOT NULL,
  `idGame` int(11) NOT NULL,
  `nbSetWon` int(11) DEFAULT NULL,
  `winner` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `play`
--

INSERT INTO `play` (`idPlayer`, `idGame`, `nbSetWon`, `winner`) VALUES
(1, 1, 2, 0),
(2, 1, 3, 1),
(3, 3, NULL, 0),
(4, 2, NULL, 0),
(5, 5, NULL, 0),
(6, 3, NULL, 0),
(9, 5, NULL, 0),
(11, 2, NULL, 0),
(13, 4, NULL, 0),
(17, 4, NULL, 0);

-- --------------------------------------------------------

--
-- Structure de la table `playdouble`
--

CREATE TABLE `playdouble` (
  `idTeam` int(11) NOT NULL,
  `idGame` int(11) NOT NULL,
  `nbSetWon` int(11) NOT NULL,
  `winner` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `player`
--

CREATE TABLE `player` (
  `idPlayer` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `gender` char(1) NOT NULL,
  `birthday` date NOT NULL,
  `idCountry` int(11) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `player`
--

INSERT INTO `player` (`idPlayer`, `firstname`, `name`, `gender`, `birthday`, `idCountry`, `version`) VALUES
(1, 'Andy', 'MURRAY', 'M', '1987-05-15', 2, 0),
(2, 'Novak', 'DJOKOVIC', 'M', '1987-05-22', 4, 0),
(3, 'Stan', 'WAWRINKA', 'M', '1985-03-28', 5, 0),
(4, 'Rafael', 'NADAL', 'M', '1986-06-03', 3, 0),
(5, 'Roger', 'FEDERER', 'M', '1981-08-08', 5, 0),
(6, 'Milos', 'RAONIC', 'M', '1990-12-27', 6, 0),
(7, 'Dominic', 'THIEM', 'M', '1993-09-03', 7, 0),
(8, 'Marin', 'CILIC', 'M', '1988-09-28', 8, 0),
(9, 'Kei', 'NISHIKORI', 'M', '1989-12-29', 9, 0),
(10, 'David', 'GOFFIN', 'M', '1990-12-07', 10, 0),
(11, 'Grigor', 'DIMITROV', 'M', '1991-05-16', 11, 0),
(12, 'Jo-Wilfried', 'TSONGA', 'M', '1985-04-17', 1, 0),
(13, 'Tomas', 'BERDYCH', 'M', '1985-09-17', 12, 0),
(14, 'Jack', 'SOCK', 'M', '1992-09-24', 13, 0),
(15, 'Gael', 'MONFILS', 'M', '1986-09-01', 1, 0),
(16, 'Lucas', 'POUILLE', 'M', '1994-02-23', 1, 0),
(17, 'Alexander', 'ZVEREV', 'M', '1997-04-20', 14, 0),
(18, 'Nick', 'KYRGIOS', 'M', '1995-04-27', 15, 0),
(19, 'Albert', 'RAMOS-VINOLAS', 'M', '1988-01-17', 3, 0),
(20, 'Roberto', 'BAUTISTA AGUT', 'M', '1988-04-14', 3, 0),
(21, 'Angelique', 'KERBER', 'F', '1988-01-18', 14, 0),
(22, 'Serena', 'WILLIAMS', 'F', '1981-09-26', 13, 0),
(23, 'Karolina', 'PLISKOVA', 'F', '1992-03-21', 12, 0),
(24, 'Simona', 'HALEP', 'F', '1991-09-27', 16, 0),
(25, 'Dominika', 'CIBULKOVA', 'F', '1989-05-06', 17, 0),
(26, 'Johanna', 'KONTA', 'F', '1991-05-17', 2, 0),
(27, 'Garbine', 'MUGURUZA', 'F', '1993-10-08', 3, 0),
(28, 'Svetlana', 'KUZNESTSOVA', 'F', '1985-06-27', 18, 0),
(29, 'Agnieszka', 'RADWANSKA', 'F', '1989-03-06', 19, 0),
(30, 'Caroline', 'WOZNIACKI', 'F', '1990-07-11', 20, 0),
(31, 'Elina', 'SVITOLINA', 'F', '1994-09-12', 21, 0),
(32, 'Venus', 'WILLIAMS', 'F', '1980-06-17', 18, 0),
(33, 'Madison', 'KEYS', 'F', '1995-02-17', 13, 0),
(34, 'Kristina', 'MLADENOVIC', 'F', '1993-05-14', 1, 0),
(35, 'Elena', 'VESNINA', 'F', '1986-08-01', 18, 0),
(36, 'Petra', 'KVITOVA', 'F', '1990-03-08', 12, 0),
(37, 'Anastasia', 'PAVLYUCHENKOVA', 'F', '1991-07-03', 18, 0),
(38, 'Anastasija', 'SEVASTOVA', 'F', '1990-04-13', 22, 0),
(39, 'Coco', 'VANDEWEGHE', 'F', '1991-12-06', 13, 0),
(40, 'Kiki', 'BERTENS', 'F', '1991-12-10', 23, 0);

-- --------------------------------------------------------

--
-- Structure de la table `referee`
--

CREATE TABLE `referee` (
  `idReferee` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `idCountry` int(11) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `referee`
--

INSERT INTO `referee` (`idReferee`, `firstname`, `name`, `idCountry`, `version`) VALUES
(1, 'Ali', 'NILI', 24, 0),
(2, 'Carlos', 'BERNARDES', 25, 0),
(3, 'Carlos', 'RAMOS', 26, 0),
(4, 'Cédric', 'MOURIER', 1, 0),
(5, 'Damien', 'DUMUSOIS', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `team`
--

CREATE TABLE `team` (
  `idTeam` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `version` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tournament`
--

CREATE TABLE `tournament` (
  `idTournament` int(11) NOT NULL,
  `label` varchar(255) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tournament`
--

INSERT INTO `tournament` (`idTournament`, `label`, `version`) VALUES
(1, 'Simple messieurs', 0),
(2, 'Simple dames', 0),
(3, 'Double messieurs', 0),
(4, 'Double dames', 0),
(5, 'Double mixte', 0),
(6, 'Simples Juniors Garçons et Filles', 0),
(7, 'Doubles Juniors Garçons et Filles', 0);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(512) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `compose`
--
ALTER TABLE `compose`
  ADD PRIMARY KEY (`idPlayer`,`idTeam`),
  ADD KEY `FK_compose_idTeam` (`idTeam`);

--
-- Index pour la table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`idCountry`);

--
-- Index pour la table `court`
--
ALTER TABLE `court`
  ADD PRIMARY KEY (`idCourt`);

--
-- Index pour la table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`idGame`),
  ADD KEY `FK_game_idReferee` (`idReferee`),
  ADD KEY `FK_game_idCourt` (`idCourt`),
  ADD KEY `FK_game_idTournament` (`idTournament`);

--
-- Index pour la table `play`
--
ALTER TABLE `play`
  ADD PRIMARY KEY (`idPlayer`,`idGame`),
  ADD KEY `FK_play_idGame` (`idGame`);

--
-- Index pour la table `playdouble`
--
ALTER TABLE `playdouble`
  ADD PRIMARY KEY (`idTeam`,`idGame`),
  ADD KEY `FK_playDouble_idGame` (`idGame`);

--
-- Index pour la table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`idPlayer`),
  ADD KEY `FK_player_idCountry` (`idCountry`);

--
-- Index pour la table `referee`
--
ALTER TABLE `referee`
  ADD PRIMARY KEY (`idReferee`),
  ADD KEY `FK_referee_idCountry` (`idCountry`);

--
-- Index pour la table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`idTeam`);

--
-- Index pour la table `tournament`
--
ALTER TABLE `tournament`
  ADD PRIMARY KEY (`idTournament`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `country`
--
ALTER TABLE `country`
  MODIFY `idCountry` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT pour la table `court`
--
ALTER TABLE `court`
  MODIFY `idCourt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `game`
--
ALTER TABLE `game`
  MODIFY `idGame` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `player`
--
ALTER TABLE `player`
  MODIFY `idPlayer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT pour la table `referee`
--
ALTER TABLE `referee`
  MODIFY `idReferee` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `team`
--
ALTER TABLE `team`
  MODIFY `idTeam` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `tournament`
--
ALTER TABLE `tournament`
  MODIFY `idTournament` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `compose`
--
ALTER TABLE `compose`
  ADD CONSTRAINT `FK_compose_idPlayer` FOREIGN KEY (`idPlayer`) REFERENCES `player` (`idPlayer`),
  ADD CONSTRAINT `FK_compose_idTeam` FOREIGN KEY (`idTeam`) REFERENCES `team` (`idTeam`);

--
-- Contraintes pour la table `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `FK_game_idCourt` FOREIGN KEY (`idCourt`) REFERENCES `court` (`idCourt`),
  ADD CONSTRAINT `FK_game_idReferee` FOREIGN KEY (`idReferee`) REFERENCES `referee` (`idReferee`),
  ADD CONSTRAINT `FK_game_idTournament` FOREIGN KEY (`idTournament`) REFERENCES `tournament` (`idTournament`);

--
-- Contraintes pour la table `play`
--
ALTER TABLE `play`
  ADD CONSTRAINT `FK_play_idGame` FOREIGN KEY (`idGame`) REFERENCES `game` (`idGame`),
  ADD CONSTRAINT `FK_play_idPlayer` FOREIGN KEY (`idPlayer`) REFERENCES `player` (`idPlayer`);

--
-- Contraintes pour la table `playdouble`
--
ALTER TABLE `playdouble`
  ADD CONSTRAINT `FK_playDouble_idGame` FOREIGN KEY (`idGame`) REFERENCES `game` (`idGame`),
  ADD CONSTRAINT `FK_playDouble_idTeam` FOREIGN KEY (`idTeam`) REFERENCES `team` (`idTeam`);

--
-- Contraintes pour la table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `FK_player_idCountry` FOREIGN KEY (`idCountry`) REFERENCES `country` (`idCountry`);

--
-- Contraintes pour la table `referee`
--
ALTER TABLE `referee`
  ADD CONSTRAINT `FK_referee_idCountry` FOREIGN KEY (`idCountry`) REFERENCES `country` (`idCountry`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
