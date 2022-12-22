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
-- Table structure for table `tblthanhvien`
--

DROP TABLE IF EXISTS `tblthanhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblthanhvien` (
  `idnhanvien` int NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `vaiTro` varchar(255) NOT NULL,
  `diaChi` varchar(46) NOT NULL,
  `hoTen` varchar(45) NOT NULL,
  PRIMARY KEY (`idnhanvien`),
  KEY `iddiachi` (`diaChi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblthanhvien`
--

LOCK TABLES `tblthanhvien` WRITE;
/*!40000 ALTER TABLE `tblthanhvien` DISABLE KEYS */;
INSERT INTO `tblthanhvien` VALUES (1,'Khiem','Khiem','113','quanli','Thanh Chuong','Khiem Nguyen'),(2,'PoppinKhiem','Khiem','114','quanli','Vinh','Nguyen Khiem'),(3,'Khiemnv','Khiemnv','115','Nhanvien','BacGiang','Khiem Le'),(4,'PoppingKhiem','Khiem','116','quanli','Do Luong','Khiem Tran'),(5,'Khiem456','Khiem','117','quanli','Yen Thanh','Khiem Dinh'),(6,'admin','admin','118','quanli','Thanh Chuong','Khiem Mac');
/*!40000 ALTER TABLE `tblthanhvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 22:19:22
