-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: libreria
-- ------------------------------------------------------
-- Server version	8.4.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autore`
--

DROP TABLE IF EXISTS `autore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autore` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(100) NOT NULL,
  `data_nascita` int DEFAULT NULL,
  `nazionalita` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autore`
--

LOCK TABLES `autore` WRITE;
/*!40000 ALTER TABLE `autore` DISABLE KEYS */;
INSERT INTO `autore` VALUES (1,'Dante','Alighieri',1265,'italiana'),(2,'Giovanni','Boccaccio',1313,'italiana'),(3,'Alessandro','Manzoni',1785,'italiana'),(4,'Giacomo','Leopardi',1798,'italiana'),(5,'Luigi','Pirandello',1867,'italiana'),(6,'Elsa','Morante',1912,'italiana'),(7,'Italo','Calvino',1923,'italiana'),(8,'Umberto','Eco',1932,'italiana'),(9,'Miguel','de Cervantes',1547,'spagnola'),(10,'William','Shakespeare',1564,'inglese'),(11,'Jane','Austen',1775,'inglese'),(12,'Charles','Dickens',1812,'inglese'),(13,'Virginia','Woolf',1882,'inglese'),(14,'George','Orwell',1903,'inglese'),(15,'Victor','Hugo',1802,'francese'),(16,'Gustave','Flaubert',1821,'francese'),(17,'Fëdor','Dostoevskij',1821,'russa'),(18,'Lev','Tolstoj',1828,'russa'),(19,'Ernest','Hemingway',1899,'statunitense'),(20,'Gabriel','García Márquez',1927,'colombiana');
/*!40000 ALTER TABLE `autore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case_editrici`
--

DROP TABLE IF EXISTS `case_editrici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `case_editrici` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_editrici`
--

LOCK TABLES `case_editrici` WRITE;
/*!40000 ALTER TABLE `case_editrici` DISABLE KEYS */;
INSERT INTO `case_editrici` VALUES (1,'Mondadori'),(2,'Einaudi'),(3,'Feltrinelli'),(4,'Adelphi'),(5,'Garzanti'),(6,'Bompiani'),(7,'Rizzoli'),(8,'Laterza'),(9,'Sellerio'),(10,'Newton Compton'),(11,'Penguin Books'),(12,'Gallimard');
/*!40000 ALTER TABLE `case_editrici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copie`
--

DROP TABLE IF EXISTS `copie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `copie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_copie` int NOT NULL,
  `case_editrici_id` int DEFAULT NULL,
  `libri_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `case_editrici_id` (`case_editrici_id`),
  KEY `libri_id` (`libri_id`),
  CONSTRAINT `copie_ibfk_1` FOREIGN KEY (`case_editrici_id`) REFERENCES `case_editrici` (`id`),
  CONSTRAINT `copie_ibfk_2` FOREIGN KEY (`libri_id`) REFERENCES `libri` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copie`
--

LOCK TABLES `copie` WRITE;
/*!40000 ALTER TABLE `copie` DISABLE KEYS */;
INSERT INTO `copie` VALUES (1,5,2,1),(2,3,7,1),(3,0,2,2),(4,12,1,3),(5,4,5,3),(6,2,5,4),(7,7,1,5),(8,0,2,6),(9,3,2,7),(10,1,2,8),(11,6,1,9),(12,0,1,10),(13,9,6,11),(14,2,10,11),(15,4,6,12),(16,1,7,13),(17,8,10,14),(18,3,11,14),(19,0,3,15),(20,5,1,16),(21,2,3,17),(22,10,1,18),(23,4,11,18),(24,6,1,19),(25,2,7,20),(26,1,12,20),(27,0,3,21),(28,5,4,22),(29,3,2,23),(30,2,2,24),(31,4,4,25),(32,7,1,26),(33,9,1,27),(34,13,4,28),(35,1,6,29);
/*!40000 ALTER TABLE `copie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generi`
--

DROP TABLE IF EXISTS `generi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generi`
--

LOCK TABLES `generi` WRITE;
/*!40000 ALTER TABLE `generi` DISABLE KEYS */;
INSERT INTO `generi` VALUES (1,'Poesia'),(2,'Giallo'),(3,'Fantastico'),(4,'Fantascienza'),(5,'Horror'),(6,'Storico'),(7,'Biografia'),(8,'Saggio'),(9,'Avventura'),(10,'Novelle'),(11,'Psicologico'),(12,'Formazione'),(13,'Sentimentale'),(14,'Realista'),(15,'Satira'),(16,'Realismo magico'),(17,'Fantasy');
/*!40000 ALTER TABLE `generi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libri`
--

DROP TABLE IF EXISTS `libri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libri` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titolo` varchar(100) NOT NULL,
  `id_genere` int DEFAULT NULL,
  `anno` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_genere` (`id_genere`),
  CONSTRAINT `libri_ibfk_1` FOREIGN KEY (`id_genere`) REFERENCES `generi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libri`
--

LOCK TABLES `libri` WRITE;
/*!40000 ALTER TABLE `libri` DISABLE KEYS */;
INSERT INTO `libri` VALUES (1,'La Divina Commedia',1,1321),(2,'Decameron',10,1353),(3,'I promessi sposi',6,1827),(4,'Canti',1,1831),(5,'Il fu Mattia Pascal',11,1904),(6,'Uno, nessuno e centomila',11,1926),(7,'L\'isola di Arturo',12,1957),(8,'La Storia',6,1974),(9,'Il barone rampante',3,1957),(10,'Il visconte dimezzato',3,1952),(11,'Il nome della rosa',2,1980),(12,'Il pendolo di Foucault',2,1988),(13,'Don Chisciotte della Mancia',9,1605),(14,'Orgoglio e pregiudizio',13,1813),(15,'Oliver Twist',14,1838),(16,'Canto di Natale',3,1843),(17,'Mrs Dalloway',11,1925),(18,'1984',4,1949),(19,'La fattoria degli animali',15,1945),(20,'I miserabili',6,1862),(21,'Madame Bovary',14,1856),(22,'Delitto e castigo',11,1866),(23,'I fratelli Karamazov',11,1880),(24,'Guerra e pace',6,1869),(25,'Anna Karenina',14,1877),(26,'Il vecchio e il mare',9,1952),(27,'Cent\'anni di solitudine',16,1967),(28,'Lo Hobbit',17,1937),(29,'Il Signore degli Anelli',17,1954);
/*!40000 ALTER TABLE `libri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libri_autore`
--

DROP TABLE IF EXISTS `libri_autore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libri_autore` (
  `id_libri` int DEFAULT NULL,
  `id_autore` int DEFAULT NULL,
  KEY `id_libri` (`id_libri`),
  KEY `id_autore` (`id_autore`),
  CONSTRAINT `libri_autore_ibfk_1` FOREIGN KEY (`id_libri`) REFERENCES `libri` (`id`),
  CONSTRAINT `libri_autore_ibfk_2` FOREIGN KEY (`id_autore`) REFERENCES `autore` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libri_autore`
--

LOCK TABLES `libri_autore` WRITE;
/*!40000 ALTER TABLE `libri_autore` DISABLE KEYS */;
INSERT INTO `libri_autore` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,5),(7,6),(8,6),(9,7),(10,7),(11,8),(12,8),(13,9),(14,11),(15,12),(16,12),(17,13),(18,14),(19,14),(20,15),(21,16),(22,17),(23,17),(24,18),(25,18),(26,19),(27,20);
/*!40000 ALTER TABLE `libri_autore` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-11-04 21:02:19
