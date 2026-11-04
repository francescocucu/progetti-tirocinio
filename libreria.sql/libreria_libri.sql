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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libri`
--

LOCK TABLES `libri` WRITE;
/*!40000 ALTER TABLE `libri` DISABLE KEYS */;
INSERT INTO `libri` VALUES (1,'La Divina Commedia',8,1321),(2,'Decameron',1,1353),(3,'I promessi sposi',6,1827),(4,'Canti',8,1831),(5,'Il fu Mattia Pascal',1,1904),(6,'Uno, nessuno e centomila',1,1926),(7,'L\'isola di Arturo',1,1957),(8,'La Storia',6,1974),(9,'Il barone rampante',1,1957),(10,'Il visconte dimezzato',3,1952),(11,'Il nome della rosa',2,1980),(12,'Il pendolo di Foucault',1,1988),(13,'Don Chisciotte della Mancia',10,1605),(14,'Orgoglio e pregiudizio',1,1813),(15,'Oliver Twist',1,1838),(16,'Canto di Natale',1,1843),(17,'Mrs Dalloway',1,1925),(18,'1984',4,1949),(19,'La fattoria degli animali',1,1945),(20,'I miserabili',6,1862),(21,'Madame Bovary',1,1856),(22,'Delitto e castigo',1,1866),(23,'I fratelli Karamazov',1,1880),(24,'Guerra e pace',6,1869),(25,'Anna Karenina',1,1877),(26,'Il vecchio e il mare',10,1952),(27,'Cent\'anni di solitudine',1,1967);
/*!40000 ALTER TABLE `libri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-11-04 15:18:20
