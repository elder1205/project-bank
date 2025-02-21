-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: bank
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `movement_entity`
--

DROP TABLE IF EXISTS `movement_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movement_entity` (
  `id_movement` varchar(255) NOT NULL,
  `amount` decimal(38,2) DEFAULT NULL,
  `balance` decimal(38,2) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `movement_description` varchar(255) DEFAULT NULL,
  `movement_type` varchar(255) DEFAULT NULL,
  `id_account` varchar(255) NOT NULL,
  PRIMARY KEY (`id_movement`),
  KEY `FK8ch4owgwrd0sw3sk3v5ritqa0` (`id_account`),
  CONSTRAINT `FK8ch4owgwrd0sw3sk3v5ritqa0` FOREIGN KEY (`id_account`) REFERENCES `account_entity` (`id_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movement_entity`
--

LOCK TABLES `movement_entity` WRITE;
/*!40000 ALTER TABLE `movement_entity` DISABLE KEYS */;
INSERT INTO `movement_entity` VALUES ('31e5e0cb-0bb6-4c0c-bcfa-4ab6778bb9b8',-1000.00,50000.00,'2025-02-15 19:24:44.918826','Withdrawal of 1000','Withdrawal','fad52d5b-14bb-4305-9d08-a6953aca15a3'),('339a3599-5e1f-4f53-b76c-2c3524c7d4b0',-1000.00,51000.00,'2025-02-15 19:21:58.528493','Withdrawal of 1000','Withdrawal','fad52d5b-14bb-4305-9d08-a6953aca15a3'),('36df5a1b-7f6a-4532-836b-e6f98e53237d',-1000.00,47000.00,'2025-02-20 11:49:56.396398','Withdrawal of 1000','Withdrawal','fad52d5b-14bb-4305-9d08-a6953aca15a3'),('55891177-bec3-4fc4-a1d4-d9865b8f2ca2',-1000.00,45000.00,'2025-02-21 15:12:02.544752','Withdrawal of 1000','Withdrawal','fad52d5b-14bb-4305-9d08-a6953aca15a3');
/*!40000 ALTER TABLE `movement_entity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-21 16:23:11
