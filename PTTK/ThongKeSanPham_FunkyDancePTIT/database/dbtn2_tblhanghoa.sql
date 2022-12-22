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
-- Table structure for table `tblhanghoa`
--

DROP TABLE IF EXISTS `tblhanghoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblhanghoa` (
  `idhh` int NOT NULL,
  `maHH` int NOT NULL,
  `tenHH` varchar(255) NOT NULL,
  `moTa` varchar(255) NOT NULL,
  `soLuong` int DEFAULT NULL,
  `giaBan` int DEFAULT NULL,
  `ngaygio` date DEFAULT NULL,
  PRIMARY KEY (`idhh`),
  KEY `idhoten` (`soLuong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblhanghoa`
--

LOCK TABLES `tblhanghoa` WRITE;
/*!40000 ALTER TABLE `tblhanghoa` DISABLE KEYS */;
INSERT INTO `tblhanghoa` VALUES (1,2,'Dolce','Xuat khau',100,1000,'2020-02-02'),(2,2,'Gucci','Noi dia',101,5000,'2033-03-03'),(3,3,'Hermes','Xuat Khau',102,9000,'2034-04-04'),(4,4,'Luis Vutton','Noi dia',103,8000,'2035-05-05'),(5,5,'Sony','Hang Trung Quoc',104,7000,'2036-06-06'),(6,6,'Canon','hang Lien Xo',105,6000,'2038-08-08'),(7,7,'Toshiba','China',106,700,'1978-11-11'),(8,8,'Apple','Soviet',107,800,'1879-05-05'),(9,9,'Oppo','UK',108,500,'1654-02-02'),(10,10,'Realmi','Japan',109,6000,'1758-06-06');
/*!40000 ALTER TABLE `tblhanghoa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 22:19:23
