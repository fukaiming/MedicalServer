-- MySQL dump 10.13  Distrib 5.6.21, for Win32 (x86)
--
-- Host: localhost    Database: medical
-- ------------------------------------------------------
-- Server version	5.6.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `hospital_id` int(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `office` varchar(50) NOT NULL,
  `skill` varchar(50) NOT NULL,
  `experience` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hospital_id` (`hospital_id`),
  CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `hospital_name` varchar(50) NOT NULL,
  `hospital_address` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `pic` varchar(50) NOT NULL,
  `treat_id` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `treat_id` (`treat_id`),
  CONSTRAINT `material_ibfk_1` FOREIGN KEY (`treat_id`) REFERENCES `user_treat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_time`
--

DROP TABLE IF EXISTS `schedule_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_time` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `time` varchar(50) DEFAULT NULL,
  `period` varchar(50) DEFAULT NULL,
  `content` varchar(50) DEFAULT NULL,
  `doctor_id` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `schedule_time_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_time`
--

LOCK TABLES `schedule_time` WRITE;
/*!40000 ALTER TABLE `schedule_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'fukaiming','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(2,'fukailiang','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(3,'xiaobai','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(4,'xiaoming','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(5,'fu','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(6,'abc','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(7,'abc','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(8,'xiaoming123','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(9,'nihao','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(10,'nihao1','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(11,'nihao1','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(12,'nihaome','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(13,'nihaome','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(14,'nihaome123','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(15,'xiaoming123321','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(16,'fukaiming123321','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(17,'xiaoliang123','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(18,'qwer','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(19,'qwer','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(20,'qwer','c8837b23ff8aaa8a2dde915473ce991','18629629611'),(21,'qwer','c8837b23ff8aaa8a2dde915473ce991','18629629611');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_evaluate`
--

DROP TABLE IF EXISTS `user_evaluate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_evaluate` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `doctor_id` int(20) NOT NULL,
  `treat_evaluate` varchar(50) DEFAULT NULL,
  `attitude_evaluate` varchar(50) DEFAULT NULL,
  `class_type` varchar(50) DEFAULT NULL,
  `treat_method` varchar(50) DEFAULT NULL,
  `content_evaluate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `user_evaluate_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_evaluate_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_evaluate`
--

LOCK TABLES `user_evaluate` WRITE;
/*!40000 ALTER TABLE `user_evaluate` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_evaluate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_treat`
--

DROP TABLE IF EXISTS `user_treat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_treat` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `class_type` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_treat_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_treat`
--

LOCK TABLES `user_treat` WRITE;
/*!40000 ALTER TABLE `user_treat` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_treat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-27  8:59:31
