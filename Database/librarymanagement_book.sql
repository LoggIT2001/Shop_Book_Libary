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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(250) COLLATE utf8mb3_unicode_ci NOT NULL,
  `author` varchar(250) COLLATE utf8mb3_unicode_ci NOT NULL,
  `category` varchar(250) COLLATE utf8mb3_unicode_ci NOT NULL,
  `description` varchar(250) COLLATE utf8mb3_unicode_ci NOT NULL,
  `release_date` date DEFAULT NULL,
  `page` int NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Crypto Trading','Jelle Peters','Crypto','While many resources for network and IT security are available, detailed knowledge regarding modern web application security has been lacking—until now. ','2018-02-15',674,35),(2,'Spring Boot','Greg L. Turnquist','Program','Need to build a Java app without wasting time? Learning Spring Boot 3.0 will show you how with Java’s de facto standard toolkit','2022-10-07',888,25.8),(4,'Taming Thymeleaf','Wim Deblauwe','Program','Thymeleaf for HTML','2022-10-03',1101,56),(5,'AI Crash Course','Hadelin de Ponteves','Program','Unlock the power of artificial intelligence with top Udemy AI instructor Hadelin de Ponteves.','2022-09-26',325,45.3),(16,'Web Application Security','Andrew Hoffman','Security','While many resources for network and IT security are available, detailed knowledge regarding modern web application security has been lacking—until now.','2019-08-01',437,13.1),(17,'Clean Code','Robert C. Martin','Software','Noted software expert Robert C. Martin, presents a revolutionary paradigm with Clean Code: A Handbook of Agile Software Craftsmanship. ','2016-05-12',952,105.2),(30,'Sherlock Holmes','Richard T. Ryan','Detective novel','The ongoing saga of a beautiful friendship!','2022-11-13',289,49.95),(31,'Grimm\'s Fairy Tales','Jacob & Wilhelm Grimm','Novel','Grimm\'s Fairy Tales is a collection of German fairy tales first published in 1812 by the Grimm Brothers, Jacob and Wilhelm.','1982-05-19',315,13.99),(32,'Predictive Analytics','Eric Siegel','Math','Prediction is booming. It reinvents industries and runs the world.','2020-07-20',400,24),(33,'Death on the Nile','Agatha Christie','Detective novel','Beloved detective Hercule Poirot embarks on a journey to Egypt in one of Agatha Christie’s most famous mysteries.','2016-12-15',235,11.9),(34,'Effective Java','Joshua Bloch','Program','In this new edition of Effective Java, Bloch explores new design patterns and language idioms that have been introduced since the second edition was released in 2008.','2015-08-07',329,49.5),(35,'Web3 Revolution','Nicola Accialini','Security','The term Web3 was born in 2014 as an antithesis to Web2, characterized by the centralization of data by a small number of companies, the so-called Big Tech.','2021-07-10',493,19);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
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
