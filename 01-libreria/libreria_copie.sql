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
-- Table structure for table `copie`
--

DROP TABLE IF EXISTS `copie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `copie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_copie` int NOT NULL,
  `is_disponibile` tinyint(1) DEFAULT NULL,
  `case_editrici_id` int DEFAULT NULL,
  `libri_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `case_editrici_id` (`case_editrici_id`),
  KEY `libri_id` (`libri_id`),
  CONSTRAINT `copie_ibfk_1` FOREIGN KEY (`case_editrici_id`) REFERENCES `case_editrici` (`id`),
  CONSTRAINT `copie_ibfk_2` FOREIGN KEY (`libri_id`) REFERENCES `libri` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copie`
--

LOCK TABLES `copie` WRITE;
/*!40000 ALTER TABLE `copie` DISABLE KEYS */;
INSERT INTO `copie` VALUES (1,5,1,2,1),(2,3,1,7,1),(3,0,0,2,2),(4,12,1,1,3),(5,4,1,5,3),(6,2,1,5,4),(7,7,1,1,5),(8,0,0,2,6),(9,3,1,2,7),(10,1,1,2,8),(11,6,1,1,9),(12,0,0,1,10),(13,9,1,6,11),(14,2,1,10,11),(15,4,1,6,12),(16,1,1,7,13),(17,8,1,10,14),(18,3,1,11,14),(19,0,0,3,15),(20,5,1,1,16),(21,2,1,3,17),(22,10,1,1,18),(23,4,1,11,18),(24,6,1,1,19),(25,2,1,7,20),(26,1,1,12,20),(27,0,0,3,21),(28,5,1,4,22),(29,3,1,2,23),(30,2,1,2,24),(31,4,1,4,25),(32,7,1,1,26),(33,9,1,1,27);
/*!40000 ALTER TABLE `copie` ENABLE KEYS */;
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
