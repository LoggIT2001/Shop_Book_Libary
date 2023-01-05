-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: librarymanagement
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `detailorder`
--

DROP TABLE IF EXISTS `detailorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detailorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_order` int NOT NULL,
  `id_book` int NOT NULL,
  `id_user` int NOT NULL,
  `quantity` int NOT NULL,
  `total_price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailorder`
--

LOCK TABLES `detailorder` WRITE;
/*!40000 ALTER TABLE `detailorder` DISABLE KEYS */;
INSERT INTO `detailorder` VALUES (1,1,1,3,1,35),(2,1,2,3,1,25.8),(3,2,2,4,1,25.8),(4,2,4,4,2,112),(5,3,30,3,1,49.95),(6,3,35,3,2,38),(7,3,34,3,5,247.5),(12,5,16,3,1,13.1),(13,5,1,3,1,35),(14,5,33,3,3,35.7),(18,7,4,3,5,280),(19,7,30,3,1,49.95),(20,7,33,3,1,11.9),(21,7,16,3,3,39.3),(22,8,4,3,1,56),(23,8,31,3,1,13.99),(24,9,17,3,3,315.6),(25,9,31,3,1,13.99),(26,9,32,3,1,24),(29,11,2,3,1,25.8),(30,11,4,3,6,336);
/*!40000 ALTER TABLE `detailorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-05 20:19:45
