-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: exam_task
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `season`
--

DROP TABLE IF EXISTS `season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `season` (
  `id_season` int NOT NULL AUTO_INCREMENT,
  `season_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_season`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `season`
--

LOCK TABLES `season` WRITE;
/*!40000 ALTER TABLE `season` DISABLE KEYS */;
/*!40000 ALTER TABLE `season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour_type`
--

DROP TABLE IF EXISTS `tour_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour_type` (
  `id_tour_type` int NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tour_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_type`
--

LOCK TABLES `tour_type` WRITE;
/*!40000 ALTER TABLE `tour_type` DISABLE KEYS */;
INSERT INTO `tour_type` VALUES (1,'sea tour'),(2,'sport tour'),(3,'others');
/*!40000 ALTER TABLE `tour_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourists`
--

DROP TABLE IF EXISTS `tourists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tourists` (
  `id_tourist` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tourist`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourists`
--

LOCK TABLES `tourists` WRITE;
/*!40000 ALTER TABLE `tourists` DISABLE KEYS */;
/*!40000 ALTER TABLE `tourists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourists_has_tours`
--

DROP TABLE IF EXISTS `tourists_has_tours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tourists_has_tours` (
  `tourists_id_tourist` int NOT NULL,
  `tours_id_tour` int NOT NULL,
  PRIMARY KEY (`tourists_id_tourist`,`tours_id_tour`),
  KEY `fk_tourists_has_tours_tours1_idx` (`tours_id_tour`),
  KEY `fk_tourists_has_tours_tourists1_idx` (`tourists_id_tourist`),
  CONSTRAINT `fk_tourists_has_tours_tourists1` FOREIGN KEY (`tourists_id_tourist`) REFERENCES `tourists` (`id_tourist`),
  CONSTRAINT `fk_tourists_has_tours_tours1` FOREIGN KEY (`tours_id_tour`) REFERENCES `tours` (`id_tour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourists_has_tours`
--

LOCK TABLES `tourists_has_tours` WRITE;
/*!40000 ALTER TABLE `tourists_has_tours` DISABLE KEYS */;
/*!40000 ALTER TABLE `tourists_has_tours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tours`
--

DROP TABLE IF EXISTS `tours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tours` (
  `id_tour` int NOT NULL AUTO_INCREMENT,
  `id_season` int DEFAULT NULL,
  `id_tour_type` int DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `cost` int NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tour`),
  KEY `id_season_idx` (`id_season`),
  KEY `id_tour_type_idx` (`id_tour_type`),
  CONSTRAINT `id_season` FOREIGN KEY (`id_season`) REFERENCES `season` (`id_season`),
  CONSTRAINT `id_tour_type` FOREIGN KEY (`id_tour_type`) REFERENCES `tour_type` (`id_tour_type`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tours`
--

LOCK TABLES `tours` WRITE;
/*!40000 ALTER TABLE `tours` DISABLE KEYS */;
INSERT INTO `tours` VALUES (1,NULL,1,'sum tour','2024-06-15','2024-06-29',1900,NULL),(2,NULL,1,'autumn tour','2024-09-15','2024-09-29',1500,NULL),(3,NULL,1,'winter tour','2024-12-15','2024-12-29',2874,NULL),(4,NULL,1,'spring tour','2025-03-15','2025-03-29',1950,NULL),(5,NULL,2,'hiking in the mountains','2024-06-19','2024-06-22',2000,NULL),(6,NULL,2,'rock climbing','2024-07-12','2024-07-14',3500,NULL),(7,NULL,3,'city tour','2024-08-10','2024-08-10',500,NULL),(8,NULL,3,'museum tour','2024-09-10','2024-09-12',750,NULL),(14,NULL,2,'bike tour','2025-12-19','2025-12-21',4950,NULL);
/*!40000 ALTER TABLE `tours` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-15 19:41:16
