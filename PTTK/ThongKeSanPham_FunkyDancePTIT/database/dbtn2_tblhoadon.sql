-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: dbtn2
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `tblhoadon`
--

DROP TABLE IF EXISTS `tblhoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblhoadon` (
  `idhoadon` int NOT NULL,
  `idhh` int NOT NULL,
  `iddlc` int NOT NULL,
  `tongTien` int DEFAULT NULL,
  `tongSoluong` int DEFAULT NULL,
  PRIMARY KEY (`idhoadon`),
  KEY `tblhoadon_fbk1_idx` (`idhh`),
  KEY `tblhoadon_fbk2_idx` (`iddlc`),
  CONSTRAINT `tblhoadon_fbk1` FOREIGN KEY (`idhh`) REFERENCES `tblhanghoa` (`idhh`),
  CONSTRAINT `tblhoadon_fbk2` FOREIGN KEY (`iddlc`) REFERENCES `tbldlc` (`iddlc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblhoadon`
--

LOCK TABLES `tblhoadon` WRITE;
/*!40000 ALTER TABLE `tblhoadon` DISABLE KEYS */;
INSERT INTO `tblhoadon` VALUES (1,1,1,NULL,NULL),(2,5,2,NULL,NULL),(3,3,3,NULL,NULL),(4,4,6,NULL,NULL),(5,5,5,NULL,NULL),(6,6,6,NULL,NULL),(7,7,7,NULL,NULL),(8,8,8,NULL,NULL),(9,9,9,NULL,NULL),(10,10,10,NULL,NULL);
/*!40000 ALTER TABLE `tblhoadon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 22:19:24
