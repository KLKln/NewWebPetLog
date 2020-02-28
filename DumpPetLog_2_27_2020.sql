-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: petlog.cn6mwhq0d6vb.us-east-2.rds.amazonaws.com    Database: petlog
-- ------------------------------------------------------
-- Server version	8.0.16

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owner` (
  `OWNER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OWNER_NAME` varchar(15) NOT NULL,
  PRIMARY KEY (`OWNER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'Kelly'),(2,'Kelly'),(3,'Rachel'),(4,'Krystle'),(5,'Sally'),(6,'Sally'),(7,'Sally'),(8,'Sally'),(9,'Walt'),(10,'Terry'),(11,'Terry'),(22,'Terry'),(24,'Terry'),(26,'Terry'),(28,'Walt'),(29,'Justin'),(30,'Justin'),(31,'Terry'),(33,'Terry'),(35,'Terry'),(36,'Terry'),(37,'Terry'),(38,'Terry'),(39,'Terry'),(40,'Terry'),(42,'Trey'),(44,'Johnny'),(45,'Wynona'),(46,'Wynona'),(47,'Pete'),(48,'Pete'),(49,'Yoda'),(50,'Barbeque'),(51,'Monica');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owners_pet_list`
--

DROP TABLE IF EXISTS `owners_pet_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owners_pet_list` (
  `LIST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LIST_NAME` varchar(30) DEFAULT NULL,
  `OWNER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`LIST_ID`),
  KEY `OWNER_ID` (`OWNER_ID`),
  CONSTRAINT `owners_pet_list_ibfk_1` FOREIGN KEY (`OWNER_ID`) REFERENCES `owner` (`OWNER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owners_pet_list`
--

LOCK TABLES `owners_pet_list` WRITE;
/*!40000 ALTER TABLE `owners_pet_list` DISABLE KEYS */;
INSERT INTO `owners_pet_list` VALUES (1,'\"Wynona\'s Pets\"',45),(2,'\"Wynona\'s Pets\"',46),(3,'\"Pete\'s Pets\"',47),(4,'\"Pete\'s Pets\"',48),(5,'Yoda\'s Pets',49),(6,'Sweet',50),(7,'Monicas Pets',51);
/*!40000 ALTER TABLE `owners_pet_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `PET_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PET_NAME` varchar(15) NOT NULL,
  `PET_TYPE` varchar(15) NOT NULL,
  `OWNER_NAME` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`PET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `petlog`
--

DROP TABLE IF EXISTS `petlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `petlog` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  `OWNER` varchar(20) NOT NULL,
  `TYPE` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `petlog`
--

LOCK TABLES `petlog` WRITE;
/*!40000 ALTER TABLE `petlog` DISABLE KEYS */;
INSERT INTO `petlog` VALUES (6,'Biscuit','Krystle','Dog'),(16,'Mr. Bun','Suzie','Rabbit'),(25,'Hobbes','Calvin','Tiger'),(30,'Odin','Kelly','Dog'),(33,'Athena','Rachel','Dog'),(34,'Wilma','Eddie','Cat'),(60,'Odie','Susan','Dog'),(68,'Athena','Susan','Dog'),(69,'Odie','NewSusan','Dog'),(70,'Garfield','Susan','Cat'),(74,'Wolfy','Johnny','Dog'),(76,'Mr. Meows','Johhny','Cat'),(77,'Stacy\'s','Got It Goin On','Mom'),(79,'Garfield','John','Cat'),(80,'Wolfy','Sarah','Wolf'),(81,'Ratniss Everdeen','Kelly','Rat'),(82,'Leo','Splinter','Lion');
/*!40000 ALTER TABLE `petlog` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-27 19:53:53
