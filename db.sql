CREATE DATABASE  IF NOT EXISTS `androidserver` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `androidserver`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: androidserver
-- ------------------------------------------------------
-- Server version	5.7.40-log

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
-- Table structure for table `history_items`
--

DROP TABLE IF EXISTS `history_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `result` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_items`
--

LOCK TABLES `history_items` WRITE;
/*!40000 ALTER TABLE `history_items` DISABLE KEYS */;
INSERT INTO `history_items` VALUES (1,1,'2,4-D','2022-01-19 03:14:07','合格'),(2,1,'百草枯','2022-01-19 03:14:07','合格'),(3,1,'敌敌畏','2022-01-19 03:14:07','不合格'),(4,1,'农药1','2022-11-22 03:14:07','合格'),(5,1,'农药2','2022-10-22 03:14:07','不合格'),(6,2,'敌敌畏1','2022-01-19 03:14:07','不合格'),(7,2,'农药3','2022-01-22 03:14:07','合格'),(8,2,'农药4','2022-02-22 03:14:07','合格'),(9,1,'Test Model','Wed Nov 23 08:36:56 GMT 2022','250.89099999999996'),(10,1,'Test Model','Wed Nov 23 08:37:50 GMT 2022','250.89099999999996'),(11,1,'aaa','Thu Nov 24 15:11:12 GMT 2022','213.7760535384462'),(12,1,'aaa','Thu Nov 24 15:16:01 GMT 2022','213.7760535384462'),(13,1,'new Model1','Fri Nov 25 00:10:55 GMT+08:00 2022','618.3013075999996'),(14,1,'new Model1','Fri Nov 25 00:11:08 GMT+08:00 2022','484.5492419999997'),(15,1,'on phone 1','Fri Nov 25 00:12:21 GMT+08:00 2022','1242.1080218073248'),(16,1,'on phone 1','Fri Nov 25 00:14:49 GMT+08:00 2022','1759.2096487738852'),(17,1,'on phone 1','Fri Nov 25 00:15:05 GMT+08:00 2022','1225.6548108917198'),(18,1,'on phone 1','Fri Nov 25 00:18:45 GMT+08:00 2022','1225.6548108917198'),(19,1,'new Model1','Sat Nov 26 13:42:12 GMT 2022','36.76533319999999'),(20,1,'model1126','Sat Nov 26 13:43:13 GMT 2022','230.71659825523392');
/*!40000 ALTER TABLE `history_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models`
--

DROP TABLE IF EXISTS `models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `models` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` varchar(100) DEFAULT NULL,
  `A` double DEFAULT NULL,
  `B` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
INSERT INTO `models` VALUES (1,'敌敌畏',8,'2022-01-19 03:14:07',1,2),(2,'2-4 D',8,'2022-01-19 04:44:17',123.123213,-123.12313),(3,'new Model1',1,'1669263898476',2.5177333333333323,-0.8823333333333219),(4,'aaa',1,'1669259217365',-0.7121025641026169,231.5757692307552),(5,'on phone 1',1,'1669306322961',9.974665605095542,0.4067866242038209),(6,'model1126',1,'1669470182329',-1.5535278588706312,269.5485806155642);
/*!40000 ALTER TABLE `models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `password` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1','hjyhjy','111111'),(2,'2','zxx','222222'),(3,'3@qq.com','zxxhjy','1111111'),(4,'4@qq.com','myb','34234111'),(5,'5@qq.com','ljy','1111111'),(6,'6@qq.com','zm','123111'),(7,'7@qq.com','XiangxiZheng','123123'),(8,'test','test','123456');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-28 23:44:45
